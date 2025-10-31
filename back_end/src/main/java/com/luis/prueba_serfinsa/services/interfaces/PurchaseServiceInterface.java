package com.luis.prueba_serfinsa.services.interfaces;

import com.luis.prueba_serfinsa.dtos.purchase.PurchaseRequestDTO;
import com.luis.prueba_serfinsa.dtos.purchase.PurchaseResponseDTO;
import java.time.LocalDate;
import java.util.List;

public interface PurchaseServiceInterface {

    PurchaseResponseDTO save(PurchaseRequestDTO dto);
    List<PurchaseResponseDTO> findByFilters(Long merchantId, String paymentMethod, LocalDate from, LocalDate to);

}