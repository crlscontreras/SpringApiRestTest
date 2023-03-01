package dev.crlsa.movies.controller;

import dev.crlsa.movies.service.MovieService;
import dev.crlsa.movies.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
/*
In rest API there are multiple layers, one of these is the API Layer, which is this Controller
it will only concern itself about the task of: getting a request and returning a response
it's using a service class and delegating the task of: fetching all the movies from the database
it calls that method from service, get the movies and returns them with HTTP status OK.

It doesn't know what is going on inside the service class
 */

@RestController
@RequestMapping("/api/v1/movies")//any request to this endpoint will be handled by this controller
public class MovieController {
    //we need a reference to our service class
    @Autowired//this will let the framework know that we want the framework to instantiate this class "MovieService" for us
    private MovieService movieService;

    //use ResponseEntity to return a proper status code like 200 (HttpStatus.OK===200)
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    //{argument}
    //@PathVariable let the framework know that we will be passing the information we got in the path variable {id}
    //and convert it to an ObjectID  called id
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
