package dev.srijit.BookMyShow.repository;

import dev.srijit.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findTheatreByName(String theatreName);
}
