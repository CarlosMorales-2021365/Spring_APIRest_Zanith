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

import com.anonymous.zanithresort.exception.ReporteException;
import com.anonymous.zanithresort.model.Report;
import com.anonymous.zanithresort.service.IReportService;


@RestController // http://localhost:8085/Zanith
@RequestMapping("/Zanith/v1")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private IReportService  iReportService;


    @GetMapping("/listReport")
    public List <Report> listReport(){
        var reportt = iReportService.listReport();
        reportt.forEach((report -> logger.info(report.toString())));
        return reportt;
    }

    @PostMapping("/AddReport")
    public Report saveReport(@RequestBody Report report) {
        logger.info("Reporte agregado");
        return iReportService.saveReport(report);
        
    }
    
    @GetMapping("/FinReport/{idReport}")
    public ResponseEntity<Report> finReport(@PathVariable Long idReport){
        Report repoort =iReportService.finReport(idReport);
        if(repoort==null)
        throw new ReporteException("No se encontro la reporte");
        return ResponseEntity.ok(repoort);
    }

    @DeleteMapping("/DeleteReport/{idReport}")
    public ResponseEntity<Map<String, Boolean>> deleteReport(@PathVariable Long idReport) {
        Report report =iReportService.finReport((idReport));
        if (report== null)
            throw new ReporteException("El reporte no existe");
            iReportService.deleteReport(report);

            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", true);
            return ResponseEntity.ok(respuesta);
    }        

    @PatchMapping("/UpdateReport/{idReport}")
    public ResponseEntity <Report> editReport(@PathVariable Long idReport, @RequestBody Report ReportReceived){
        Report report = iReportService.finReport(idReport);
        if (report == null)
        throw new ReporteException("El id no existe ");
        report.setIdHotels(ReportReceived.getIdHotels());
        report.setTipo(ReportReceived.getTipo());
        report.setFechaGeneracion(ReportReceived.getFechaGeneracion());
        report.setDescription(ReportReceived.getDescription());
        iReportService.saveReport(report);
        return ResponseEntity.ok(report);

    }

}


