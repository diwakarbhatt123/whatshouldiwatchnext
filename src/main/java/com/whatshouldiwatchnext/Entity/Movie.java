package com.whatshouldiwatchnext.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by diwakar on 22/06/17.
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(length = 1000)
    private String plot;
    @ManyToMany
    @JoinTable(name = "movie_genre",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    @ManyToMany
    @JoinTable(name = "movie_directors",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "directors_id"))
    private List<Person> directors;
    @ManyToMany
    @JoinTable(name = "movie_actors",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "actors_id"))
    private List<Person> actors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", plot='" + plot + '\'' +
                ", genres=" + genres +
                '}';
    }
}
