package com.whatshouldiwatchnext.dao;

import com.whatshouldiwatchnext.Entity.Genre;
import com.whatshouldiwatchnext.Entity.Movie;
import com.whatshouldiwatchnext.Entity.Person;

import java.util.Date;
import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
public interface MovieDao {

    Movie getMovieById(Long id);

    Long addMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(Long id);

    List<Movie> getMovies(Integer year, String name, int limit, int offset);

    List<Movie> getMoviesByDirector(Person director);

    List<Movie> getMoviesByActor(Person actor);

    List<Movie> getMoviesByGenre(Genre genre);
}
