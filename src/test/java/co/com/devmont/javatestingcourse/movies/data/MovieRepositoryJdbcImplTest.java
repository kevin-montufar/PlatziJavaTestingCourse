package co.com.devmont.javatestingcourse.movies.data;

import co.com.devmont.javatestingcourse.movies.model.Genre;
import co.com.devmont.javatestingcourse.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieRepositoryJdbcImplTest {

    private MovieRepositoryJdbcImpl movieRepository;
    private DriverManagerDataSource dataSource;

    @Before
    public void before() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbcImpl(jdbcTemplate);
    }

    @Test
    public void loadAllMovies() {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(
                movies,
                is(Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Mel Gibson"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Tarantino"),
                        new Movie(3, "Matrix", 136, Genre.ACTION, "Adam"))
                )
        );
    }

    @Test
    public void loadMovieById() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Tarantino")));
    }

    @Test
    public void loadMovieByName() {
        List<Movie> movie = movieRepository.findByName("mem");
        assertTrue(movie.contains(new Movie(2, "Memento", 113, Genre.THRILLER, "Tarantino")));
    }

    @Test
    public void loadMovieByDirector() {
        List<Movie> movie = movieRepository.findByDirector("tara");
        assertTrue(movie.contains(new Movie(2, "Memento", 113, Genre.THRILLER, "Tarantino")));
    }

    @Test
    public void insertMovie() {
        Movie movie = new Movie("Avengers", 213, Genre.ACTION, "Tarantino");
        movieRepository.saveOrUpdate(movie);
        Movie movieInserted = movieRepository.findById(4);
        assertThat(movieInserted, is(new Movie(4, "Avengers", 213, Genre.ACTION, "Tarantino")));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
    }
}