package com.banco.demo.services;

import java.sql.Date;
import java.util.ArrayList;

import com.banco.demo.models.AccountModel;
import com.banco.demo.models.ReportModel;
import com.banco.demo.repositories.AccountRepository;
import com.banco.demo.repositories.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    ReportRepository generateReport;
    @Autowired
    AccountRepository accountRepository;
    
    public ArrayList<ReportModel> generateReport(Long id, Date dateStart, Date dateEnd){
        AccountModel account;
        account=accountRepository.findBy_accountNumber(id);

        return (ArrayList<ReportModel>) generateReport.generateReport(account.get_id(),dateStart,dateEnd);
    }
}
