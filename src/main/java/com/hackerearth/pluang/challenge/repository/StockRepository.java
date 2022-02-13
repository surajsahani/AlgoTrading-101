package com.hackerearth.pluang.challenge.repository;

import com.hackerearth.pluang.challenge.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByDateIs(LocalDate date);
}
