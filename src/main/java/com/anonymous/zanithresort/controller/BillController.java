package com.anonymous.zanithresort.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anonymous.zanithresort.exception.BillException;
import com.anonymous.zanithresort.model.Bill;
import com.anonymous.zanithresort.service.IBillService;


@RestController // http://localhost:8085/Zanith

@RequestMapping("/Zanith/v1")
public class BillController {

    private final Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private IBillService iBillService;

    @GetMapping("/listBill")
    public List <Bill> listBill(){
        var billl = iBillService.listBill();
        billl.forEach((bill -> logger.info(bill.toString())));
        return billl;
    }

    @PostMapping("/AddFactura")
    public Bill saveBill(@RequestBody Bill bill) {
        logger.info("Factura agregada");
        return iBillService.saveBill(bill);
        
    }
    
    @GetMapping("/FinFactura/{idbill}")
    public ResponseEntity<Bill> finBill(@PathVariable Long idbill){
        Bill biill =iBillService.finBill(idbill);
        if(biill==null)
        throw new BillException("No se encontro la factura");
        return ResponseEntity.ok(biill);
    }

    @DeleteMapping("/DeleteFactura/{idbill}")
    public ResponseEntity<Map<String, Boolean>> deleteBill(@PathVariable Long idbill) {
        Bill bill =iBillService.finBill((idbill));
        if (bill== null)
            throw new BillException("La factura no existe");
            iBillService.deleteBill(bill);

            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", true);
            return ResponseEntity.ok(respuesta);
    }        

    @PatchMapping("/UpdateFactura/{idbill}")
    public ResponseEntity <Bill> editBill(@PathVariable Long idbill, @RequestBody Bill billReceived){
        Bill bill = iBillService.finBill(idbill);
        if (bill == null)
        throw new BillException("El id no existe ");
        bill.setIdreservation(billReceived.getIdreservation());
        bill.setAmountTotal(billReceived.getAmountTotal());
        bill.setDescription(billReceived.getDescription());
        bill.setDateEmission(billReceived.getDateEmission());
        iBillService.saveBill(bill);
        return ResponseEntity.ok(bill);

    }

}
