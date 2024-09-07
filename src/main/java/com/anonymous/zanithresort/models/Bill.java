package com.anonymous.zanithresort.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;
    private Long idReservacion;
    private Double montoTotal;
    private String descripcion;
    private Date fechaEmision;


    public Bill(Long idReservacion, Double montoTotal, String descripcion, Date fechaEmision) {
        this.idReservacion = idReservacion;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.fechaEmision = fechaEmision;
    }    


}