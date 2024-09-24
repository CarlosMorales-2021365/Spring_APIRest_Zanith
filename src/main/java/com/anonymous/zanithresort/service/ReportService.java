package com.anonymous.zanithresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anonymous.zanithresort.model.Report;
import com.anonymous.zanithresort.repository.ReporteriaRepository;

@Service
public class ReportService implements IReportService{

    @Autowired
    private ReporteriaRepository reporteriaRepository;


    @Override
    public List<Report> listReport() {
        return reporteriaRepository.findAll();      
    }

    @Override
    public Report finReport(long idReport) {
        Report report = reporteriaRepository.findById(idReport).orElse(null);
        return report;     
    }

    @Override
    public Report saveReport(Report report) {
        return reporteriaRepository.save(report);
   
    }

    @Override
    public Report deleteReport(Report report) {
        reporteriaRepository.delete(report);
        return report;      
    }


}
