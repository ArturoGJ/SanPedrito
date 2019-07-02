/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.persistance;

import sanpedrito.businesslogic.MealItem;
import java.util.List;

/**
 *
 * @author Arturo
 */
public class MealsAdapter {
    
    private static final MealsDbRepository db = new MealsDbRepository();

    public static List<MealItem> readAllMealItems() {
        List<MealItem> tempListMealItems = db.retrieve();
        return tempListMealItems;
    }
    
    public static MealItem createMealItem(String name, float price) {
        List<MealItem> tempListMealItems = db.retrieve();
        int newID;
        newID = tempListMealItems.get(tempListMealItems.size()-1).getID() + 1;
        tempListMealItems.add(new MealItem(newID, name, price));
        db.persist(tempListMealItems);
        return tempListMealItems.get(tempListMealItems.size()-1);
    } 
    /*
    public static void createMealItem(MealItem f) {
        List<MealItem> tempListMealItems = db.retrieve();
        tempListMealItems.add(f);
        db.persist(tempListMealItems);
    }
    */
    
    public static MealItem createMealItem2(int ID, String name, float price) {
        List<MealItem> tempListMealItems = db.retrieve();
        tempListMealItems.add(new MealItem(ID, name, price));
        db.persist(tempListMealItems);
        return tempListMealItems.get(tempListMealItems.size()-1);
    } 
    
    
    public static MealItem readMealItem(int ID) {
        List<MealItem> tempListMealItems = db.retrieve();
        for (MealItem t : tempListMealItems) {
            if (t.getID() == ID) {
                return t;
            }
        }
        return null;
    }
    
    public static void updateMealItem(MealItem f) {
        List<MealItem> tempListMealItems = db.retrieve();
        for (int i = 0; i < tempListMealItems.size(); i++) {
           if (tempListMealItems.get(i).getID() == f.getID()) {
                tempListMealItems.set(i, f);
                db.persist(tempListMealItems);
                break;
            }
        }
    }
   
    public static void deleteMealItem(Integer i) {
        List<MealItem> tempListMealItems = db.retrieve();
        for (MealItem t : tempListMealItems) {
            if (t.getID() == i) {
                tempListMealItems.remove(t);
                db.persist(tempListMealItems);
                break;
            }
        }
    }    
}
