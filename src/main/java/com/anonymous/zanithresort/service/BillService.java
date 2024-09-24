package com.anonymous.zanithresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.model.Bill;
import com.anonymous.zanithresort.repository.BillRepository;

@Service
public class BillService implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> listBill() {
        return billRepository.findAll();
    }

    @Override
    public Bill finBill(long idbill) {
        Bill bill = billRepository.findById(idbill).orElse(null);
        return bill;        
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    
    }

    @Override
    public Bill deleteBill(Bill bill) {
        billRepository.delete(bill);
        return bill;
    }


}
