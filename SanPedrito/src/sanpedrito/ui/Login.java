/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Callum
 */
public class Login extends Stage {
    
    GridPane grid = new GridPane();
    Text scenetitle = new Text("Login");
    Label username = new Label("Username:");
    TextField usernameTextField = new TextField();
    Label pw = new Label("Password:");
    PasswordField pwBox = new PasswordField();
    Button btnGo = new Button("Go");
    Hyperlink registerLink = new Hyperlink();
    Text actiontarget = new Text();
    
    Login(){
        
        this.setTitle("San Pedrito");
        //Grid panel starts
        //Allignment property changes the default position of the grid from the top
        grid.setAlignment(Pos.CENTER);
         grid.setStyle("-fx-background-color:#06c3ad; -fx-opacity:1; -fx-font-family: 'Century Gothic'");
                
        //Gap property manages spacing between rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        //Gap property manages space around edges of grid pane
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        //Creates text objects that cannot be edited
        //sets the text to welcome and assigns it to a variable named scenetitle
        
        //uses the setFont() method to set the font family, weight and size
        username.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD, 14));
        username.setTextFill(Color.WHITE);
        
        pw.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD, 14));
        pw.setTextFill(Color.WHITE);
        
        
        
        //Logo Insertion
        Image logo = new Image("file:logo.jpg");
        
        ImageView iv1 = new ImageView();
        iv1.setFitHeight(140);
        iv1.setFitWidth(250);
        iv1.setImage(logo);
        
        grid.add(iv1, 1, 0);
        
        //the grid.add() method adds the scenetitle variable to the layout grid
        
   
        //name label
        
        grid.add(username, 0, 3);
        
        //name textfield
        
        grid.add(usernameTextField, 1, 3);
        
        
        grid.add(pw, 0, 4);

        
        grid.add(pwBox, 1, 4);
       
        grid.setGridLinesVisible(false);
        
        
        
        grid.add(btnGo, 1, 6);
        btnGo.setMinWidth(250);
        ;
        btnGo.setStyle("-fx-font-family: 'Century Gothic'");
        
        
        registerLink.setText("Register");
        registerLink.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD, 15));
        registerLink.setTextFill(Color.WHITE);
        registerLink.setOnAction((ActionEvent event) -> {
            new ComingSoon();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        });
        grid.add(registerLink, 1, 8);
        grid.add(actiontarget, 1, 9);
        
        //Zooms in and out of regiser link
        registerLink.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
        registerLink.setScaleX(1.5);
        registerLink.setScaleY(1.5);
        registerLink.setFont(Font.font("Century Gothic", FontWeight.BOLD, FontPosture.ITALIC, 15));
        }
        });
        
        registerLink.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
        registerLink.setScaleX(1);
        registerLink.setScaleY(1);
        registerLink.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD, 15));
        }
        });
        
        
        btnGo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (pwBox.getText().equals("admin")&&(usernameTextField.getText().equals("admin"))) {
                    new AdminForm(); 
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    } else if(pwBox.getText().equals("arturogj")&&(pwBox.getText().equals("arturogj"))){
                    new CustomerForm();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    } else { 
                    actiontarget.setText("Your password is incorrect!");
                    actiontarget.setFill(Color.rgb(210, 39, 30)); 
                    } 
                }
            }); 
        
        
        
        this.setScene(new Scene(grid, 500, 500));
    
        this.show();
        
    }

}