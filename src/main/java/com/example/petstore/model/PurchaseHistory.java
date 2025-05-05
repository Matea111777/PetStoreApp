package com.example.petstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime executionTime;

    private int successfulPurchases;

    private int failedPurchases;

    public PurchaseHistory(LocalDateTime executionTime, int successfulPurchases, int failedPurchases) {
        this.executionTime = executionTime;
        this.successfulPurchases = successfulPurchases;
        this.failedPurchases = failedPurchases;
    }
}
