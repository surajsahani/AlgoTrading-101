package com.example.algotrading.repository;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

import com.example.algotrading.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByDateIs(LocalDate date);
}
