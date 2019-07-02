/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import sanpedrito.businesslogic.UserItem;

/**
 *
 * @author Arturo
 */
public class UserDbRepository {
    
    
    
    private Connection dataPersistanceLayer = null;
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/meals"; //Name of the connection
    private Properties connectionProperties = new Properties();
    
    public UserDbRepository(){
    connectionProperties.put("user", "adminuser");
    connectionProperties.put("password", "adminuser");
}
    public List<UserItem> retrieve(){
        List<UserItem> userItems = new ArrayList<>();
        UserItem userItem = null;
        try{
            //Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            this.dataPersistanceLayer = DriverManager.getConnection(DB_CONNECTION, "adminuser", "adminuser");
            
            Statement sql = this.dataPersistanceLayer.createStatement();
            ResultSet records = sql.executeQuery("SELECT * FROM APP.USERINFO");
            while (records.next()){
                userItem = new UserItem();
                userItem.setID(records.getInt("ID"));
                userItem.setName(records.getString("NAME"));
                userItem.setLastName(records.getString("LASTNAME"));
                userItem.setEmail(records.getString("EMAIL"));
                userItem.setPassword(records.getString("PASSWORD"));
                userItem.setDelivery(records.getString("DELIVERY"));
                userItems.add(userItem);                
            }           
        } catch (SQLException sqlex){
            System.out.println("Database read error :'( No sirve... dios");
            System.out.println(sqlex);
        }
        return userItems;
    }
    
    public void persist(List<UserItem> userItems){
        UserItem userItem = null;
        try {
            this.dataPersistanceLayer = DriverManager.getConnection(DB_CONNECTION, connectionProperties);
            Statement sql = this.dataPersistanceLayer.createStatement();
            sql.execute("TRUNCATE TABLE APP.USERINFO");
            for (int i = 0; i<userItems.size(); i++){
                userItem = userItems.get(i);
                sql.executeUpdate("INSERT INTO APP.MEALS (ID, NAME, LASTNAME, EMAIL, PASSWORD, DELIVERY) VALUES ("
                        + userItem.getID() + ", '"
                        + userItem.getName() + "', "
                        + userItem.getLastName() + ", '"
                        + userItem.getEmail() + "', "
                        + userItem.getPassword() + ", '"                        
                        + userItem.getDelivery() + ")");
            }
        } catch (SQLException sqlex){
            System.out.println("Database write error");
            System.out.println(sqlex);
        }
    }    
}
