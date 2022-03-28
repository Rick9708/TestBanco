package com.banco.demo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long _id;
    private Date _date;
    private String _transactionType;
    private Double _value;
    private Double _balance;
    @Column(name="_accountID")
    private Long _accountID;

    @ManyToOne
    private AccountModel account;

    /**
     * @return Date return the _date
     */
    public Date get_date() {
        return _date;
    }

    /**
     * @param _date the _date to set
     */
    public void set_date(Date _date) {
        this._date = _date;
    }

    /**
     * @return String return the _transactionType
     */
    public String get_transactionType() {
        return _transactionType;
    }

    /**
     * @param _transactionType the _transactionType to set
     */
    public void set_transactionType(String _transactionType) {
        this._transactionType = _transactionType;
    }

    /**
     * @return Double return the _value
     */
    public Double get_value() {
        return _value;
    }

    /**
     * @param _value the _value to set
     */
    public void set_value(Double _value) {
        this._value = _value;
    }

    /**
     * @return Double return the _balance
     */
    public Double get_balance() {
        return _balance;
    }

    /**
     * @param _balance the _balance to set
     */
    public void set_balance(Double _balance) {
        this._balance = _balance;
    }


    /**
     * @return Long return the _id
     */
    public Long get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(Long _id) {
        this._id = _id;
    }


    /**
     * @return AccountModel return the account
     */
    public AccountModel getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(AccountModel account) {
        this.account = account;
    }


    /**
     * @return Long return the _accountID
     */
    public Long get_accountID() {
        return _accountID;
    }

    /**
     * @param _accountID the _accountID to set
     */
    public void set_accountID(Long _accountID) {
        this._accountID = _accountID;
    }

}
