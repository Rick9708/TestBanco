package com.banco.demo.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.banco.demo.models.AccountModel;
import com.banco.demo.models.ReportModel;
import com.banco.demo.repositories.AccountRepository;
import com.banco.demo.repositories.ReportRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ReportServiceTest {
    @Mock
    private ReportRepository reportRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private ReportService reportService;

    private ArrayList<ReportModel> rep;

    private Date  dateStart = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    private Date  dateEnd = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    private long accountNumber = 55;

    private Iterable<AccountModel> acc;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);   
        ReportModel rep = new ReportModel();

        rep.set_accountNumber("121222");
        rep.set_accountType("Ahorro");
        rep.set_name("Test");
        rep.set_value("1000");
        
    }


    @Test
    void findBy_accountNumberHappyPath() throws Exception{

        AccountModel acc = new AccountModel();

        acc.set_accountNumber(new Long(12222));
        acc.set_accountType("Ahorros");
        acc.set_initialBalance(1000.0);
        acc.set_state("True");
        acc.set_id(new Long(12222));

        when(reportRepository.generateReport(accountNumber,dateStart,dateEnd)).thenReturn(rep);
        when(accountRepository.findBy_accountNumber(accountNumber)).thenReturn((AccountModel) acc);


        assertNotNull(reportService.generateReport(accountNumber,dateStart,dateEnd));
    }
}
