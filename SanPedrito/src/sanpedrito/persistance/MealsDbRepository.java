/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.persistance;

import sanpedrito.businesslogic.MealItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Arturo
 */
public class MealsDbRepository {
    
    private Connection dataPersistanceLayer = null;
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/meals"; //Name of the connection
    private Properties connectionProperties = new Properties();
    
    public MealsDbRepository(){
    connectionProperties.put("user", "adminuser");
    connectionProperties.put("password", "adminuser");
}
    public List<MealItem> retrieve(){
        List<MealItem> mealItems = new ArrayList<>();
        MealItem mealItem = null;
        try{
            //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            this.dataPersistanceLayer = DriverManager.getConnection(DB_CONNECTION, "adminuser", "adminuser");
            
            Statement sql = this.dataPersistanceLayer.createStatement();
            ResultSet records = sql.executeQuery("SELECT * FROM APP.MEALS");
            while (records.next()){
                mealItem = new MealItem();
                mealItem.setID(records.getInt("ID"));
                mealItem.setName(records.getString("name"));
                mealItem.setPrice(records.getFloat("price"));
                mealItems.add(mealItem);                
            }           
        } catch (SQLException sqlex){
            System.out.println("Database read error :'(");
            System.out.println(sqlex);
        }
        return mealItems;
    }
    
    public void persist(List<MealItem> mealItems){
        MealItem mealItem = null;
        try {
            this.dataPersistanceLayer = DriverManager.getConnection(DB_CONNECTION, connectionProperties);
            Statement sql = this.dataPersistanceLayer.createStatement();
            sql.execute("TRUNCATE TABLE APP.MEALS");
            for (int i = 0; i<mealItems.size(); i++){
                mealItem = mealItems.get(i);
                sql.executeUpdate("INSERT INTO APP.MEALS (ID, NAME, PRICE) VALUES ("
                        + mealItem.getID() + ", '"
                        + mealItem.getName() + "', "
                        + mealItem.getPrice() + ")");
            }
        } catch (SQLException sqlex){
            System.out.println("Database write error");
            System.out.println(sqlex);
        }
    }

}
