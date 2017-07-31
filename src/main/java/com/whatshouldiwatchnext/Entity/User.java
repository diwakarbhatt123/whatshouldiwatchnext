package com.whatshouldiwatchnext.Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by diwakar on 22/06/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "user_preferredActors",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "actor_Id"))
    private List<Person> preferredActors;
    @ManyToMany
    @JoinTable(name = "user_preferredDirector", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Person> preferredDirectors;
    @ManyToMany
    @JoinTable(name = "user_preferredGenre",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> preferredGenres;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Person> getPreferredActors() {
        return preferredActors;
    }

    public void setPreferredActors(List<Person> preferredActors) {
        this.preferredActors = preferredActors;
    }

    public List<Person> getPreferredDirectors() {
        return preferredDirectors;
    }

    public void setPreferredDirectors(List<Person> preferredDirectors) {
        this.preferredDirectors = preferredDirectors;
    }

    public List<Genre> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(List<Genre> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferredActors=" + preferredActors +
                ", preferredDirectors=" + preferredDirectors +
                ", preferredGenres=" + preferredGenres +
                '}';
    }
}
