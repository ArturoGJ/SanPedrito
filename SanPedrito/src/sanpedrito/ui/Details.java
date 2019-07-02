/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.ui;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Arturo
 */
public class Details extends Stage {
    //Text
    Text accDetails = new Text();
    Text name = new Text();
    Text address = new Text();
    Text delivery = new Text();
    Text email = new Text();
    //Text to be filled 
    Text userName = new Text();
    Text userAddress = new Text();
    Text userDelivery = new Text();
    Text userEmail = new Text();    
    
    Details(){
        //Setting Texts
        accDetails.setText("Accout details");
        accDetails.setFill(Color.WHITE);
        name.setText("Name: Arturo Garrido Jauckens");
        name.setFill(Color.WHITE);
        address.setText("Address: Wilton Road");
        address.setFill(Color.WHITE);
        delivery.setText("Delivery: 3 times a week"); 
        delivery.setFill(Color.WHITE);
        email.setText("email: arturo@gmail.com"); 
        email.setFill(Color.WHITE);
        
        //Setting Style for texts and button. 
        
        accDetails.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));            
        name.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));   
        address.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));        
        delivery.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        email.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        
        
        //Boxes
        HBox top = new HBox();
        VBox mid = new VBox();
        HBox bot = new HBox();
        
        
        top.setMargin(accDetails, new Insets(20,2,2,2));
        top.setAlignment(Pos.CENTER);
        ObservableList topList = top.getChildren();
        topList.addAll(accDetails);
        
        mid.setMargin(name, new Insets(65,5,5,5));
        mid.setMargin(address, new Insets(5,5,5,5));
        mid.setMargin(email, new Insets(5,5,5,5));        
        mid.setMargin(delivery, new Insets(20,5,5,5));   
        mid.setAlignment(Pos.TOP_LEFT);
        ObservableList midList = mid.getChildren();
        midList.addAll(name, address, email);
        
        //Border Pane
        BorderPane border = new BorderPane();
        border.setTop(top);
        border.setCenter(mid);
        border.setBottom(bot);
        
        border.setStyle("-fx-background-color:#06c3ad");

        
        Scene scene = new Scene(border);
        
        this.setTitle("Details");
        this.setScene(scene);
        this.setWidth(400);
        this.setHeight(600);
        this.show();
    }
    
}
