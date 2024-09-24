package com.anonymous.zanithresort.controller;

import com.anonymous.zanithresort.DTOs.ServiceDTO;
import com.anonymous.zanithresort.model.Service;
import com.anonymous.zanithresort.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zanith/v1/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Obtener todos los servicios
    @GetMapping
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        List<ServiceDTO> serviceDTOs = services.stream().map(service -> new ServiceDTO(service.getId(), service.getName(), service.getCost(), service.getDescription())).collect(Collectors.toList());
        return ResponseEntity.ok(serviceDTOs);
    }

    // Obtener un servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable Long id) {
        Optional<Service> serviceOptional = serviceService.getServiceById(id);
        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            ServiceDTO serviceDTO = new ServiceDTO(service.getId(), service.getName(), service.getCost(), service.getDescription());
            return ResponseEntity.ok(serviceDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo servicio
    @PostMapping
    public ResponseEntity<ServiceDTO> createService(@RequestBody ServiceDTO serviceDTO) {
        Service service = new Service(serviceDTO);
        Service createdService = serviceService.createService(service);
        ServiceDTO createdServiceDTO = new ServiceDTO(createdService.getId(), createdService.getName(), createdService.getCost(), createdService.getDescription());
        return ResponseEntity.ok(createdServiceDTO);
    }

    // Actualizar un servicio existente
    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> updateService(@PathVariable Long id, @RequestBody ServiceDTO serviceDTO) {
        Optional<Service> updatedServiceOptional = serviceService.updateService(id, new Service(serviceDTO));
        if (updatedServiceOptional.isPresent()) {
            Service updatedService = updatedServiceOptional.get();
            ServiceDTO updatedServiceDTO = new ServiceDTO(updatedService.getId(), updatedService.getName(), updatedService.getCost(), updatedService.getDescription());
            return ResponseEntity.ok(updatedServiceDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un servicio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        boolean isDeleted = serviceService.deleteService(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}