package dev.crlsa.movies; //declaring a package

/*
first import the class called SpringApplication: it contains a method called "run"
we need this method to start the spring application
"run" needs: our application class (public class MoviesApplication{})
*/
import org.springframework.boot.SpringApplication;

/*
annotations @: to let the compiler know what a class does
*/
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Let the app know this is a Rest API Controller and not just another class
import org.springframework.web.bind.annotation.RestController;
@RestController
 */

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
