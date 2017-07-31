package com.whatshouldiwatchnext.Service;

import com.whatshouldiwatchnext.Entity.Movie;
import com.whatshouldiwatchnext.dao.MovieDao;
import com.whatshouldiwatchnext.dao.MovieDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie getMovieById(long id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public Long addMovie(Movie movie) {
        return movieDao.addMovie(movie);
    }

    @Override
    public void deleteMovie(long id) {
        movieDao.deleteMovie(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDao.updateMovie(movie);
    }

    @Override
    public List<Movie> getMovies(Integer year, String name,int limit, int offset) {
        return movieDao.getMovies(year,name,limit,offset);
    }
}
