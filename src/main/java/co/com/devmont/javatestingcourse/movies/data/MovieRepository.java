package co.com.devmont.javatestingcourse.movies.data;

import co.com.devmont.javatestingcourse.movies.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieRepository {

    Movie findById(long id);
    List<Movie> findByName(String name);
    List<Movie> findByDirector(String director);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
