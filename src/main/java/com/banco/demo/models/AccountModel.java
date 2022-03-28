package com.banco.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = true)
    private Long _id;
    @Column(name="_accountNumber")
    private Long _accountNumber;
    @Column(name="_accountType")
    private String _accountType;
    @Column(name="_initialBalance")
    private Double _initialBalance;
    private String _state;
    @Column(name="_clientId")
    private Long _clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;


    /**
     * @return String return the _accountNumber
     */
    public Long get_accountNumber() {
        return _accountNumber;
    }

    /**
     * @param _accountNumber the _accountNumber to set
     */
    public void set_accountNumber(Long _accountNumber) {
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
     * @return String return the _initialBalance
     */
    public Double get_initialBalance() {
        return _initialBalance;
    }

    /**
     * @param _initialBalance the _initialBalance to set
     */
    public void set_initialBalance(Double _initialBalance) {
        this._initialBalance = _initialBalance;
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
     * @return ClientModel return the client
     */
    public ClientModel getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientModel client) {
        this.client = client;
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
     * @return Long return the _clientId
     */
    public Long get_clientId() {
        return _clientId;
    }

    /**
     * @param _clientId the _clientId to set
     */
    public void set_clientId(Long _clientId) {
        this._clientId = _clientId;
    }

}
