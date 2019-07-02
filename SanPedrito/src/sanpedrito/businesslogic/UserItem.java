
package sanpedrito.businesslogic;

import java.io.Serializable;

/**
 *
 * @author Arturo
 */
/*

THIS CLASS IS NEVER USED IN THE PROGRAM, JUST KEEPING IN IN CASE
WE WANT TO USE IT IN THE FUTURE.

*/






public class UserItem implements Serializable {
    
    private int ID;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String delivery;

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        if (this.ID==0) {
            this.ID = ID;
        }
    }
    
    public int getID() {
        return ID;
    }
    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName){
        if(!lastName.equals("")){
            this.lastName = lastName;
        }
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        if(!email.equals("")){
            this.email = email;
        }
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        if(!password.equals("")){
            this.password = password;
        }
    }
    
    public String getDelivery() {
        return delivery;
    }
    
    public void setDelivery(String delivery){
        if(!delivery.equals("")){
            this.delivery = delivery;
        }
    }
    public UserItem() {
        name = "UNALLOCATED";
        //delivery = -1.F; //What is this?
    }

    public UserItem(int ID, String name, String lastName, String email, String password, String delivery) {
        
        //No blank items
        if (!name.equals("") && !lastName.equals("") && !email.equals("") && !password.equals("") && !delivery.equals("") ) {
            this.ID = ID;
            this.name = name;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.delivery = delivery;
        }
    }

    @Override
    public String toString() {
        return "UserItem{ ID=" + ID + ", name=" + name + ", last name=" + lastName + '}';
    }    
    
}
