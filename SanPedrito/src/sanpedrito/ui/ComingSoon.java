/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.ui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class ComingSoon extends Stage{
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
    
   // Button edit = new Button("Edit");
    
    ComingSoon(){
        //Setting Texts
        accDetails.setText("Coming Soon :^ ) ");
        accDetails.setFill(Color.WHITE);
        name.setText("For admin log in use:");
        name.setFill(Color.WHITE);
        address.setText("user: admin   password: admin");
        address.setFill(Color.WHITE);
        delivery.setText("For user example log in use: "); 
        delivery.setFill(Color.WHITE);
        email.setText("user: arturogj   password: arturogj"); 
        email.setFill(Color.WHITE);
        
        //Setting Style for texts and button. 
        
        accDetails.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,25));   
        name.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));   
        address.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));        
        delivery.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        email.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        
        Image logo = new Image("file:logo.jpg");
        ImageView iv1 = new ImageView();
        iv1.setFitHeight(140);
        iv1.setFitWidth(250);
        iv1.setImage(logo);
        
        Button logOutBtn = new Button("Go Back");
        logOutBtn.setMinWidth(100);
        logOutBtn.setStyle("-fx-font-family:'Century Gothic'");        
        
        logOutBtn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                new Login();
                ((Node)(event.getSource())).getScene().getWindow().hide();                            
            }
        });         

        
        
        //Boxes
        HBox top = new HBox();
        VBox mid = new VBox();
        VBox bot = new VBox();
        
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
        midList.addAll(name, address, delivery, email);
        
        bot.setMargin(iv1, new Insets(65,5,5,5));
        bot.setMargin(logOutBtn, new Insets(5,5,5,5));
        bot.setAlignment(Pos.CENTER);
        ObservableList botList = bot.getChildren();
        botList.addAll(iv1, logOutBtn);

        
        //Border Pane
        BorderPane border = new BorderPane();
        border.setTop(top);
        border.setCenter(mid);
        border.setBottom(bot);
        
        border.setStyle("-fx-background-color:#06c3ad");
        
        Scene scene = new Scene(border);
        
        this.setTitle("Register");
        this.setScene(scene);
        this.setWidth(400);
        this.setHeight(600);
        this.show();
    }   
}
    

