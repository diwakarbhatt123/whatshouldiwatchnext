package com.whatshouldiwatchnext.Controller;

import com.whatshouldiwatchnext.Entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
public interface MovieController {

    ResponseEntity<Movie> getMovie(Long id);

    ResponseEntity<List<Movie>> getMovies(Integer year, String name, int limit, int offset);

    ResponseEntity<Movie> addMovie(Movie movie, BindingResult result);

    ResponseEntity<HttpStatus> updateMovie(Movie movie, BindingResult result);

    ResponseEntity<HttpStatus> deleteMovie(Long id);

}
