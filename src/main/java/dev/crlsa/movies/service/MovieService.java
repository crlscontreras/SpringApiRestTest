package dev.crlsa.movies.service;

import dev.crlsa.movies.entity.Movie;
import dev.crlsa.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//in this class we write the database access methods
/*
This is where most of our business logic will go
It uses the repository class to talk to the database
 */

@Service
public class MovieService {
    //we need a reference of the repository
    //In java you'll have to initialize this bit of code with a constructor
    //or we can use AutoWire

    @Autowired //this will let the framework know that we want the framework to instantiate this class "MovieRepository" for us
    private MovieRepository movieRepository;


    public List<Movie> allMovies(){
        //the ".findAll()" method is described inside the MongoRepository<T,ID> class
        return movieRepository.findAll();
    }

    //Optional<Movie> because it may return null
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
