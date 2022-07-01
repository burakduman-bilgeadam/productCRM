package com.example.productCRM.service;

import com.example.productCRM.model.SaleDTO;

import java.util.List;

public interface SaleService {

    void addSale(Long customerId, Long productId,Long saleId);
    void deleteSale(Long id);
    void updateSale(Long customerId, Long productId,Long saleId);
    List<SaleDTO> getSales();
}
