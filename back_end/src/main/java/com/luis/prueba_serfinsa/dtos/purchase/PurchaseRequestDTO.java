package com.luis.prueba_serfinsa.dtos.purchase;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PurchaseRequestDTO {

    private Long merchantId;
    private Long customerId;
    private LocalDate purchaseDate;
    private String paymentMethod;
    private String location;
    private BigDecimal totalAmount;
}