package com.luis.prueba_serfinsa.repository;

import com.luis.prueba_serfinsa.entity.Purchase;
import com.luis.prueba_serfinsa.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("""
        SELECT p FROM Purchase p
        WHERE p.merchant.id = :merchantId
          AND (:paymentMethod IS NULL OR p.paymentMethod = :paymentMethod)
          AND (:from IS NULL OR p.purchaseDate >= :from)
          AND (:to IS NULL OR p.purchaseDate <= :to)
    """)
    List<Purchase> findByFilters(
            @Param("merchantId") Long merchantId,
            @Param("paymentMethod") PaymentMethod paymentMethod,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );

}