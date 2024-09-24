package com.anonymous.zanithresort.service;

import com.anonymous.zanithresort.model.Service;
import com.anonymous.zanithresort.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    // Obtener todos los servicios
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    // Obtener un servicio por ID
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    // Crear un nuevo servicio
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    // Actualizar un servicio existente
    public Optional<Service> updateService(Long id, Service serviceDetails) {
        return serviceRepository.findById(id).map(service -> {
            service.setName(serviceDetails.getName());
            service.setCost(serviceDetails.getCost());
            service.setDescription(serviceDetails.getDescription());
            return serviceRepository.save(service);
        });
    }

    // Eliminar un servicio
    public boolean deleteService(Long id) {
        return serviceRepository.findById(id).map(service -> {
            serviceRepository.delete(service);
            return true;
        }).orElse(false);
    }
}