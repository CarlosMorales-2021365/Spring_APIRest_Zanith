package com.anonymous.zanithresort.service;

import java.util.List;

import com.anonymous.zanithresort.model.Bill;

public interface IBillService {
    
    public List <Bill> listBill();

    public Bill finBill(long idbill);

    public Bill saveBill(Bill bill);

    public Bill deleteBill(Bill bill);

    

}
