package com.whatshouldiwatchnext.dao;

import com.whatshouldiwatchnext.Entity.Genre;
import com.whatshouldiwatchnext.Entity.Movie;
import com.whatshouldiwatchnext.Entity.Person;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by diwakar on 08/07/17.
 */
@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Movie getMovieById(Long id) {
        return getCurrentSession().get(Movie.class, id);
    }

    @Override
    public Long addMovie(Movie movie) {
        return (Long) getCurrentSession().save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        getCurrentSession().update(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        Session session = getCurrentSession();
        Movie movie = session.get(Movie.class, id);
        if (movie != null) {
            session.delete(movie);
        }
    }

    @Override
    public List<Movie> getMovies(Integer year, String name, int limit, int offset) {
        Criteria movieCriteria  = getCurrentSession().createCriteria(Movie.class).setMaxResults(limit).setFirstResult(offset);
        if(year != null){
            Calendar greaterThan = Calendar.getInstance();
            greaterThan.set(Calendar.YEAR, year);
            greaterThan.set(Calendar.DATE, 1);
            greaterThan.set(Calendar.MONTH, 0);
            Calendar lessThan = Calendar.getInstance();
            lessThan.set(Calendar.YEAR, year);
            lessThan.set(Calendar.DATE, 1);
            lessThan.set(Calendar.MONTH, 0);
            movieCriteria.add(Restrictions.and(Restrictions.gt("releaseDate", greaterThan.getTime()), Restrictions.lt("releaseDate", lessThan.getTime())));
        }
        if(name != null){
            movieCriteria.add(Restrictions.eq("title", name));
        }
        return movieCriteria.list();
    }

    @Override
    public List<Movie> getMoviesByDirector(Person director) {
        long directorId = director.getId();
        Query query = getCurrentSession().createSQLQuery("SELECT * FROM movie_directors WHERE directors_id = :dirId JOIN Movie ON movie_directors.movie_id=Movie.id JOIN Person ON movie_directors.directors_id=Person.id");
        query.setLong("dirId",directorId);
        return query.list();
    }

    @Override
    public List<Movie> getMoviesByActor(Person actor) {
        long actorId = actor.getId();
        Query query = getCurrentSession().createSQLQuery("SELECT * FROM movie_actors WHERE actors_id = :actId JOIN Movie ON movie_directors.movie_id=Movie.id JOIN Person ON movie_actors.actors_id=Person.id");
        query.setLong("actId",actorId);
        return query.list();
    }

    @Override
    public List<Movie> getMoviesByGenre(Genre genre) {
        long genreId = genre.getId();
        Query query = getCurrentSession().createSQLQuery("SELECT * FROM movie_genre WHERE genre_id = :actId JOIN Movie ON movie_directors.movie_id=Movie.id JOIN Genre ON movie_genre.genre_id=Genre.id");
        query.setLong("genId",genreId);
        return query.list();
    }
}
