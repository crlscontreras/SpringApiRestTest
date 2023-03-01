package dev.crlsa.movies.repository;

import dev.crlsa.movies.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
it works as the intermediary layer between the service class and the DB
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
