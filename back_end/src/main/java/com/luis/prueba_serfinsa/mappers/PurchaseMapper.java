package com.luis.prueba_serfinsa.mappers;


import com.luis.prueba_serfinsa.dtos.purchase.PurchaseRequestDTO;
import com.luis.prueba_serfinsa.dtos.purchase.PurchaseResponseDTO;
import com.luis.prueba_serfinsa.entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    @Mapping(source = "merchant.name", target = "merchantName")
    @Mapping(source = "customer.name", target = "customerName")
    PurchaseResponseDTO toResponseDTO(Purchase purchase);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "merchant", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Purchase toEntity(PurchaseRequestDTO dto);
}