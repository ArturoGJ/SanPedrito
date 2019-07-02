/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.persistance;

import java.util.List;
import sanpedrito.businesslogic.UserItem;

/**
 *
 * @author Arturo
 */
public class UserAdapter {
    
    private static final UserDbRepository db = new UserDbRepository();

    public static List<UserItem> readAllUserItems() {
        List<UserItem> tempListUserItems = db.retrieve();
        return tempListUserItems;
    }
    
    public static UserItem createMealItem(String name, String lastName, String email, String password, String delivery) {
        List<UserItem> tempListUserItems = db.retrieve();
        int newID = tempListUserItems.get(tempListUserItems.size()-1).getID() + 1;
        tempListUserItems.add(new UserItem(newID, name, lastName, email, password, delivery));
        db.persist(tempListUserItems);
        return tempListUserItems.get(tempListUserItems.size()-1);
    } 
    public static void createUserItem(UserItem f) {
        List<UserItem> tempListUserItems = db.retrieve();
        tempListUserItems.add(f);
        db.persist(tempListUserItems);
    }
    
    public static UserItem readMealItem(int ID) {
        List<UserItem> tempListUserItems = db.retrieve();
        for (UserItem t : tempListUserItems) {
            if (t.getID() == ID) {
                return t;
            }
        }
        return null;
    }
    
}
