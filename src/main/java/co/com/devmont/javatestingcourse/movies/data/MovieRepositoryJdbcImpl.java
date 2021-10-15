package co.com.devmont.javatestingcourse.movies.data;

import co.com.devmont.javatestingcourse.movies.model.Genre;
import co.com.devmont.javatestingcourse.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.List;

public class MovieRepositoryJdbcImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public List<Movie> findByName(String name) {
        Object[] args = {"%" + name.toLowerCase() + "%"};
        return jdbcTemplate.query("select * from movies where lower(name) like ?", args, movieMapper);
    }

    @Override
    public List<Movie> findByDirector(String director) {
        Object[] args = {"%" + director.toLowerCase() + "%"};
        return jdbcTemplate.query("select * from movies where lower(director) like ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update(
                "insert into movies(name, minutes, genre, director) values(?, ?, ?, ?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString(),
                movie.getDirector()
        );
    }

    private static RowMapper<Movie> movieMapper = (resultSet, i) -> new Movie(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre")),
            resultSet.getString("name")
    );
}
