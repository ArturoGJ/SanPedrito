/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.businesslogic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Arturo
 */
public class Authentication {
    
    private final StringProperty userName = new SimpleStringProperty();

    public StringProperty userNameProperty() {
        return userName ;
    }

    public final String getUserName() {
        return userNameProperty().get();
    }
    
    public final void setUserName(String userName) {
        userNameProperty().set(userName);
    }    
}
