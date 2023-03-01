package dev.crlsa.movies.controller;

import dev.crlsa.movies.service.ReviewService;
import dev.crlsa.movies.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /*
    @RequestBody Map<String, String> payload
    what we are saying here is that: whatever we get in the request body
    we would like to convert it to a map of <Key String, Value String>
    and we name this map "payload"

    .CREATED = 201
     */

    /*
    This endpoint will receive a JSON data from the frontend {reviewBody:"something" ,imdbId:"id of a movie" }
    and then convert it to a map where:
    the keys are a string: reviewBody, imdbId
    and values are a string: something, id of a movie
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(
                reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);

    }
}
