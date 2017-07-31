package com.whatshouldiwatchnext.Controller;

import com.whatshouldiwatchnext.Entity.Movie;
import com.whatshouldiwatchnext.Service.MovieService;
import com.whatshouldiwatchnext.Service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
@RestController
public class MovieControllerImpl implements MovieController {

    @Autowired
    private MovieService movieService;

    @Override
    @RequestMapping(path = "/movie/:id", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable(name = "id") Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @RequestMapping(path = "/movie", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(value = "year", required = false) Integer year,
                                                 @RequestParam(value = "name", required = false) String name,
                                                 @RequestParam("limit") int limit,
                                                 @RequestParam("offset") int offset) {
        List<Movie> movies = movieService.getMovies(year, name, limit, offset);
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "/movie", method = RequestMethod.POST)
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Long addedMovieId = movieService.addMovie(movie);
            Movie addedMovie = movieService.getMovieById(addedMovieId);
            return new ResponseEntity<>(addedMovie, HttpStatus.OK);
        }
    }

    @Override
    @RequestMapping(path = "/movie", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> updateMovie(Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            movieService.updateMovie(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @Override
    @RequestMapping(path = "/movie/:id", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
