package dev.srijit.BookMyShow.repository;

import dev.srijit.BookMyShow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByName(String movieName);
}
