package com.banco.demo.controllers;

import java.sql.Date;
import java.util.ArrayList;

import com.banco.demo.models.ReportModel;
import com.banco.demo.services.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping(path = "/{id}/{dateStart}/{dateEnd}")
    public ArrayList<ReportModel> generateReport(@PathVariable("id") Long id, @PathVariable("dateStart") Date dateStart,
            @PathVariable("dateEnd") Date dateEnd) {
        return reportService.generateReport(id, dateStart, dateEnd);
    }

}
