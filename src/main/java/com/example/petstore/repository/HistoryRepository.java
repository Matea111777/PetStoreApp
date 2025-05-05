package com.example.petstore.repository;

import com.example.petstore.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<PurchaseHistory,Long > {
}
