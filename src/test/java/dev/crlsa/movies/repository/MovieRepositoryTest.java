package dev.crlsa.movies.repository;

import dev.crlsa.movies.entity.Movie;
import dev.crlsa.movies.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
https://howtodoinjava.com/spring-boot/testcontainers-with-junit-and-spring-boot/
https://www.youtube.com/watch?v=Geq60OVyBPg
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Container
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0")
            .withExposedPorts(27017);

    @DynamicPropertySource
    static void mongoDbProperties(DynamicPropertyRegistry registry) {
        mongoDBContainer.start();
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    /*
    This test creates a Movie and saves it in MongoDB container, then verifies that the movie has been created using its Imdb id.
     */
    @Test
    public void givenProduct_whenSave_thenProductIsSaved() {
        //given: an object (a movie)
        Movie movie = new Movie();
        movie.setImdbId("imdbTest1");
        Movie savedMovie = movieRepository.save(movie);

        //when: the method that we are testing
        Optional <Movie> foundMovie = movieRepository.findMovieByImdbId("imdbTest1");

        //then: the assertion
        assertEquals(movie.getImdbId(), savedMovie.getImdbId());
        //It is an Optional<T> object, that can be either present or absent.
        //you must first .get() the items before calling getImdbId() on the object Movie.
        //the method should return the movie given its imdbId
        assertEquals(movie.getImdbId(), foundMovie.get().getImdbId());
    }

}