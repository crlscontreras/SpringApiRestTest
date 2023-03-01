package dev.crlsa.movies.entity;

import lombok.AllArgsConstructor;//@ for creating a constructor that takes all the private fields as argument
import lombok.Data;//@ that take cares of all the get and set methods
import lombok.NoArgsConstructor;//@ for creating a constructor that takes no arguments
import org.bson.types.ObjectId;//Cannot resolve symbol 'ObjectId'
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//@Document: this will let the framework knows that this class represents each document in the movies collection
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    //@Id will let the framework know that this property should be treated
    //as the unique identifier for each movie
    @Id
    private ObjectId id; //the id of the movie
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    //manual reference relationship
    //@DocumentReference: this will cause the database to store ONLY the ids of the review,
    // and the reviews itself will be in a separate collection
    @DocumentReference
    private List<Review> reviewsId; //one movie can have many reviews
}
