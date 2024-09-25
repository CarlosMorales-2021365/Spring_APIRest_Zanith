package com.anonymous.zanithresort.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import com.anonymous.zanithresort.DTOs.HotelRegisterDTO;
import com.anonymous.zanithresort.exception.HotelsException;
import com.anonymous.zanithresort.service.CloudinaryService;
import com.anonymous.zanithresort.service.HotelService;
import com.anonymous.zanithresort.service.IHotelService;
import jakarta.validation.Valid;
import com.anonymous.zanithresort.model.Hotels;
@RestController // http://localhost:8085/Zanith
@RequestMapping("/Zanith/v1")
public class HotelsController {
    private static final Logger logger = LoggerFactory.getLogger(HotelsController.class);
    @Autowired
    private IHotelService iHotelService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    CloudinaryService cloudinaryService;
    @GetMapping("/ListHotels")
    public List<Hotels> listHotels() {
        var hotel2 = iHotelService.listHotels();
        hotel2.forEach(hotels -> logger.info(hotels.toString()));
        return hotel2;
    }
    @PostMapping("/AddHotel")
    public ResponseEntity<?> addHotel(
            @RequestPart("photo") MultipartFile profilePicture,
            @Valid @ModelAttribute HotelRegisterDTO addhoteldto,
            BindingResult result) {
        Map<String, Object> res = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
            .map(error -> error.getDefaultMessage())
            .collect(Collectors.toList());
            res.put("Errores", errors);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        try{
            logger.info("Enviano el archivo a cloudinary");
            Map<String, Object> uploadRersut = cloudinaryService.uploadImg(profilePicture, "perfiles");
            String profilePhoto =uploadRersut.get("url").toString();
            String img = profilePhoto.substring(profilePhoto.indexOf("perfiles/"));
            Hotels hotels = new Hotels(addhoteldto, img);
            hotels.setHotel_id(UUID.randomUUID().toString());
            hotelService.saveHotel(hotels);
            logger.info("Hotel agregado exitosamente");
            res.put("Mensaje", "Hotel agregado exitosamente");
            res.put("Hotel", hotels);
            return new ResponseEntity<>(res,HttpStatus.CREATED);
        }catch(IOException e){
            logger.error("Error en entrada de archivo");
            res.put("Mensaje", "Error al subir la imagen");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(CannotCreateTransactionException e){
            logger.error("Error al procesar la transaccion");
            res.put("Mensaje", "Error al crear la transaccion");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE); 
        }catch(DataAccessException e ){
            logger.error("Error al conectar a la base de datos");
            res.put("Mensaje", "Error al conectar a la base de datos");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping("/FindHotel/{hotel_id}")
    public ResponseEntity<Hotels> findHotel(@PathVariable Integer hotel_id) {
        Hotels hotels = iHotelService.findHotel(hotel_id);
        if (hotel_id == null)
            throw new HotelsException("No se encuentra empleado");
        return ResponseEntity.ok(hotels);
    }
    @DeleteMapping("/DeleteHotel/{hotel_id}")
    public ResponseEntity<Map<String, Boolean>> deleteHotel(@PathVariable Integer hotel_id) {
        Hotels hotel = iHotelService.findHotel(hotel_id);
        if (hotel == null)
            throw new HotelsException("el empleado no existe");
        iHotelService.deleteHotel(hotel);
        // JSON {eliminad: true}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);
    }
    @PutMapping("/UpdateHotel/{hotel_id}")
    public ResponseEntity<Hotels> editarEmpleados(@PathVariable Integer hotel_id, @RequestBody Hotels hotelsCheck) {
        Hotels hotels = iHotelService.findHotel(hotel_id);
        if (hotels == null)
            throw new HotelsException("El id recibido no existe");
        {
            hotels.setName(hotelsCheck.getName());
            hotels.setDirection(hotelsCheck.getDirection());
            hotels.setCategory(hotelsCheck.getCategory());
            hotels.setDescription(hotelsCheck.getDescription());
            hotels.setAverage_price(hotelsCheck.getAverage_price());
            hotels.setPhoto(hotelsCheck.getPhoto());
            iHotelService.saveHotel(hotels);
            return ResponseEntity.ok(hotels);
        }
    }
}