package com.banco.demo.repositories;

import java.sql.Date;
import java.util.ArrayList;

import com.banco.demo.models.ReportModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<ReportModel, Long> {
    @Query (
        value = "SELECT client._id, transaction._date,client._name,account._accountNumber,account._accountType,account._state,transaction._balance, transaction._value from ((transaction join account on ?1  = transaction.account__id) join client on client._id = account.client_id) where `transaction`._date >= ?2 and `transaction`._date < ?3 ",
        nativeQuery = true
    )
    ArrayList<ReportModel> generateReport(Long accoundId, Date dateStart,Date dateEnd);
}
