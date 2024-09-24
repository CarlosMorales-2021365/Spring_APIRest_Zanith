package com.anonymous.zanithresort.service;

import java.util.List;

import com.anonymous.zanithresort.model.Report;

public interface IReportService {

    public List <Report> listReport();

    public Report finReport(long idReport);

    public Report saveReport(Report report);

    public Report deleteReport(Report report);    

}
