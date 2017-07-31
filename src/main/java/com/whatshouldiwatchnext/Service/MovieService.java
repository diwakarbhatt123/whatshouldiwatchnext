package com.whatshouldiwatchnext.Service;

import com.whatshouldiwatchnext.Entity.Movie;

import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
public interface MovieService {

    Movie getMovieById(long id);

    Long addMovie(Movie movie);

    void deleteMovie(long id);

    void updateMovie(Movie movie);

    List<Movie> getMovies(Integer year, String name, int limit, int offset);

}
