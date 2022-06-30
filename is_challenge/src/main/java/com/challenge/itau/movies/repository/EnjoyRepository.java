package com.challenge.itau.movies.repository;

import com.challenge.itau.movies.entity.Enjoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnjoyRepository extends JpaRepository<Enjoy, Long> {
}
