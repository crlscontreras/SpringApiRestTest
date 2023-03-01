package dev.crlsa.movies.repository;
//repository is of type interface

import dev.crlsa.movies.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;//@Repository to let the framework know that it is a repository

import java.util.Optional;

//MongoRepository = MongoRepository provides all the necessary methods which help to create a CRUD application and it also supports the custom derived query methods.
//MongoRepository<Domain type that repository manages (Generally the Entity/Model class name),Type of the id of the entity that repository manages>

/*
Repository: Data access layer of the API
it does the job of actually talking with the database and getting the data back
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //automatic queries
    //findMovieBy{propertyName}: by naming it this way, Spring Data MongoDB will understand what we are trying to do (is that intelligent)
    //we can form dynamic queries like this, as long as the property in the model class is unique
    Optional<Movie> findMovieByImdbId(String imdbId);
}
