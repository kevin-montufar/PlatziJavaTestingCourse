package co.com.devmont.javatestingcourse.movies.service;

import co.com.devmont.javatestingcourse.movies.data.MovieRepository;
import co.com.devmont.javatestingcourse.movies.model.Genre;
import co.com.devmont.javatestingcourse.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;
    MovieService movieService;

    @Before
    public void before() {
        movieService = new MovieService(movieRepository);
        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Movie 1",12, Genre.ACTION, ""),
                new Movie(2, "Movie 2",14, Genre.HORROR, ""),
                new Movie(3, "Movie 3",20, Genre.DRAMA, ""),
                new Movie(4, "Movie 4",100, Genre.COMEDY, ""),
                new Movie(5, "Movie 5",120, Genre.ACTION, "")
        ));
    }

    @Test
    public void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.ACTION);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1,5)));
    }

    @Test
    public void returnMoviesByDuration() {
        Collection<Movie> movies = movieService.findMoviesByLength(20);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1,2,3)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}