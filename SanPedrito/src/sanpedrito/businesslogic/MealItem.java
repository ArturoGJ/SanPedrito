/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.businesslogic;

import java.io.Serializable;

/**
 *
 * @author Arturo
 */
public class MealItem implements Serializable {
    
    private int ID;
    private String name;
    private float price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public MealItem() {
        name = "UNALLOCATED";
        price = -1.0F; //What is this?
    }

    public MealItem(int ID, String name, float price) {
        
        //No blank items
        if (price > 0.0 && !name.equals("")) {
            this.ID = ID;
            this.name = name;
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "MealItem{ ID=" + ID + ", name=" + name + ", price=" + price + '}';
    }    
}