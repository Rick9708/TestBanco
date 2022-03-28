package com.banco.demo.models;

import javax.persistence.*;

@MappedSuperclass
public class PersonModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long _id;
    
    private String _name;
    private String _gender;
    private Integer _age;
    private String _identification;
    private String _address;
    private String _phone;

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
     * @return String return the _gender
     */
    public String get_gender() {
        return _gender;
    }

    /**
     * @param _gender the _gender to set
     */
    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    /**
     * @return Integer return the _age
     */
    public Integer get_age() {
        return _age;
    }

    /**
     * @param _age the _age to set
     */
    public void set_age(Integer _age) {
        this._age = _age;
    }

    /**
     * @return String return the _identification
     */
    public String get_identification() {
        return _identification;
    }

    /**
     * @param _identification the _identification to set
     */
    public void set_identification(String _identification) {
        this._identification = _identification;
    }

    /**
     * @return String return the _address
     */
    public String get_address() {
        return _address;
    }

    /**
     * @param _address the _address to set
     */
    public void set_address(String _address) {
        this._address = _address;
    }

    /**
     * @return String return the _phone
     */
    public String get_phone() {
        return _phone;
    }

    /**
     * @param _phone the _phone to set
     */
    public void set_phone(String _phone) {
        this._phone = _phone;
    }

}