package com.banco.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class ReportModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private Date _date;
    private String _name;
    private String _accountNumber;
    private String _accountType;
    private String _state;
    private String _balance;
    private String _value;


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
     * @return String return the _name
     */
    public String get_name() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void set_name(String _name) {
        this._name = _name;
    }

    /**
     * @return String return the _accountNumber
     */
    public String get_accountNumber() {
        return _accountNumber;
    }

    /**
     * @param _accountNumber the _accountNumber to set
     */
    public void set_accountNumber(String _accountNumber) {
        this._accountNumber = _accountNumber;
    }

    /**
     * @return String return the _accountType
     */
    public String get_accountType() {
        return _accountType;
    }

    /**
     * @param _accountType the _accountType to set
     */
    public void set_accountType(String _accountType) {
        this._accountType = _accountType;
    }

    /**
     * @return String return the _state
     */
    public String get_state() {
        return _state;
    }

    /**
     * @param _state the _state to set
     */
    public void set_state(String _state) {
        this._state = _state;
    }

    /**
     * @return String return the _balance
     */
    public String get_balance() {
        return _balance;
    }

    /**
     * @param _balance the _balance to set
     */
    public void set_balance(String _balance) {
        this._balance = _balance;
    }

    /**
     * @return String return the _value
     */
    public String get_value() {
        return _value;
    }

    /**
     * @param _value the _value to set
     */
    public void set_value(String _value) {
        this._value = _value;
    }

}
