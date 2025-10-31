package com.luis.prueba_serfinsa.services;

import com.luis.prueba_serfinsa.dtos.purchase.PurchaseRequestDTO;
import com.luis.prueba_serfinsa.dtos.purchase.PurchaseResponseDTO;
import com.luis.prueba_serfinsa.entity.Purchase;
import com.luis.prueba_serfinsa.enums.PaymentMethod;
import com.luis.prueba_serfinsa.mappers.PurchaseMapper;
import com.luis.prueba_serfinsa.repository.CustomerRepository;
import com.luis.prueba_serfinsa.repository.MerchantRepository;
import com.luis.prueba_serfinsa.repository.PurchaseRepository;
import com.luis.prueba_serfinsa.services.interfaces.PurchaseServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService implements PurchaseServiceInterface {

    private final PurchaseRepository repository;
    private final MerchantRepository merchantRepo;
    private final CustomerRepository customerRepo;
    private final PurchaseMapper mapper;

    public PurchaseResponseDTO save(PurchaseRequestDTO dto) {
        Purchase purchase = mapper.toEntity(dto);
        purchase.setMerchant(merchantRepo.findById(dto.getMerchantId()).orElseThrow());
        purchase.setCustomer(customerRepo.findById(dto.getCustomerId()).orElseThrow());
        Purchase saved = repository.save(purchase);
        return mapper.toResponseDTO(saved);
    }

    public List<PurchaseResponseDTO> findByFilters(Long merchantId, String paymentMethod, LocalDate from, LocalDate to) {
        List<Purchase> purchases = repository.findByFilters(merchantId, PaymentMethod.valueOf(paymentMethod), from, to);
        return purchases.stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}
