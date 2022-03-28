package com.banco.demo.models;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class ClientModel extends PersonModel{
    

    private String _password;
    private String _state;

    
    @OneToMany(mappedBy = "client")
    private List<AccountModel> accounts;
    
    public Long getId() {
        return super.get_id();
    }

    /**
     * @return String return the _password
     */
    public String get_password() {
        return _password;
    }

    /**
     * @param _password the _password to set
     */
    public void set_password(String _password) {
        this._password = _password;
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

}
