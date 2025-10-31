package com.luis.prueba_serfinsa.controllers;

import com.luis.prueba_serfinsa.dtos.purchase.PurchaseRequestDTO;
import com.luis.prueba_serfinsa.dtos.purchase.PurchaseResponseDTO;
import com.luis.prueba_serfinsa.services.interfaces.PurchaseServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/purchases")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PurchaseRestController {

    private final PurchaseServiceInterface purchaseService;

    @PostMapping(value = "/")
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody PurchaseRequestDTO dto) {
        PurchaseResponseDTO response = purchaseService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponseDTO>> getPurchasesByFilters(
            @RequestParam Long merchantId,
            @RequestParam(required = false) String paymentMethod,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate
    ) {

        List<PurchaseResponseDTO> purchases = purchaseService.findByFilters(merchantId, paymentMethod, fromDate, toDate);
        return ResponseEntity.ok(purchases);
    }

}