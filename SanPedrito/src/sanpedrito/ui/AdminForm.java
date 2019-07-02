/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanpedrito.ui;

import sanpedrito.businesslogic.MealItem;
import sanpedrito.persistance.MealsAdapter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
public class AdminForm extends Stage {
    
    AdminForm(){
        //Creating Text 
        Text name = new Text();
        Text order = new Text();
        Text orderStatus = new Text();
        float priceT = 0;
        
        //Creating TextFields
        TextField mealName = new TextField();
        TextField mealPrice = new TextField();
        
        TextField editId = new TextField();
        TextField editName = new TextField();
        TextField editPrice = new TextField();
        
        TextField mealId = new TextField();        
                
        String text = "Administrator";
        
        //Style of text
        name.setText(text);
        name.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        name.setFill(Color.WHITE);        
        
        //Style of Textfield
        mealName.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));
        mealPrice.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));
        mealId.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));
        editId.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));
        editPrice.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));
        editName.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,16));        
        
        mealName.setMaxWidth(150);
        mealPrice.setMaxWidth(150);
        mealId.setMaxWidth(150);
        editId.setMaxWidth(50);
        editName.setMaxWidth(150);
        editPrice.setMaxWidth(150);        
        
        mealName.setPromptText("New Meal");
        mealPrice.setPromptText("Meal Price");
        mealId.setPromptText("Meal ID");
        editId.setPromptText(" ID");
        editName.setPromptText("Edit Name");
        editPrice.setPromptText("Edit Price");
        
        //Creating Buttons
        Button detailsBtn = new Button("Details");
        Button logOutBtn = new Button("Log Out");
        Button completeOrder = new Button("Complete Order");
        Button addMealBtn = new Button("Add Meal");
        Button removeMealBtn = new Button("Delete Meal");
        Button editBtn = new Button("Edit");
        
        //Style of buttons
        detailsBtn.setMinWidth(100);
        detailsBtn.setStyle("-fx-font-family:'Century Gothic'");

        logOutBtn.setMinWidth(100);
        logOutBtn.setStyle("-fx-font-family:'Century Gothic'");

        addMealBtn.setMinWidth(100);
        addMealBtn.setStyle("-fx-font-family:'Century Gothic'");

        removeMealBtn.setMinWidth(100);
        removeMealBtn.setStyle("-fx-font-family:'Century Gothic'");
        
        editBtn.setMinWidth(100);
        editBtn.setStyle("-fx-font-family:'Century Gothic'");
        
        completeOrder.setMinWidth(250);
        completeOrder.setMinHeight(100);
        completeOrder.setStyle("-fx-font-family:'Century Gothic'");
       
        //Set up list for meals
        List<MealItem> myMeals = MealsAdapter.readAllMealItems();
        
        //Set up list for Order
        final ObservableList names = FXCollections.observableArrayList();
        final ObservableList priceTotal = FXCollections.observableArrayList();
        
        //Table set up and population
        TableView<MealItem> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final ObservableList<MealItem> data = FXCollections.observableArrayList();
        
        for (MealItem f : myMeals) {
            data.add(f);
        }     
        
        
        //Create Table
        TableColumn id = new TableColumn("ID");
        TableColumn mealsCol = new TableColumn("Meals");
        TableColumn priceCol = new TableColumn("Price");
        TableColumn actionCol = new TableColumn("");
        id.setCellValueFactory(new PropertyValueFactory<MealItem,String>("ID"));
        mealsCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("price"));
        
  
        table.getColumns().addAll(id, mealsCol, priceCol);
        table.setItems(data);
       
        //Instantiating Boxes
        HBox dBox = new HBox();//dbox = details box
        HBox bottom = new HBox();
        HBox editField = new HBox();
        HBox addField = new HBox();
        HBox removeField = new HBox();
        VBox vOrder = new VBox();
        
        //Adding Image
        Image logo = new Image("file:logo.jpg");
        ImageView iv1 = new ImageView();
        iv1.setFitHeight(100);
        iv1.setFitWidth(250);
        iv1.setImage(logo);
        
        
        //Setting the space between the nodes of a HBox pane 
        dBox.setSpacing(10); 
        
        //Setting the margings Box's nodes
        dBox.setMargin(name, new Insets(20,2,2,2)); 
        //dBox.setMargin(detailsBtn, new Insets(2,2,2,2)); 
        dBox.setMargin(logOutBtn, new Insets(20,10,2,2)); 
        
        Region region1 = new Region();
        dBox.setHgrow(region1, Priority.ALWAYS);
        
        dBox.setAlignment(Pos.TOP_RIGHT);
        ObservableList list = dBox.getChildren();
        list.addAll(iv1, region1,name, logOutBtn);
        
        addField.setMargin(mealName, new Insets(5,15,15,5));
        addField.setMargin(mealPrice, new Insets(5,15,15,5));
        addField.setMargin(addMealBtn, new Insets(5,15,15,5));
        
        addField.setAlignment(Pos.TOP_RIGHT);
        ObservableList addList = addField.getChildren();
        addList.addAll(mealName, mealPrice, addMealBtn);
        
        editField.setMargin(editId, new Insets(5,15,15,5));
        editField.setMargin(editName, new Insets(5,15,15,5));        
        editField.setMargin(editPrice, new Insets(5,15,15,5));
        editField.setMargin(editBtn, new Insets(5,15,15,5));
        
        addField.setAlignment(Pos.TOP_RIGHT);
        ObservableList editList = editField.getChildren();
        editList.addAll(editId, editName, editPrice, editBtn);        
        
        removeField.setMargin(mealId, new Insets(5,15,15,5));
        removeField.setMargin(removeMealBtn, new Insets(5,15,15,5));
        Region region2 = new Region();
        removeField.setHgrow(region2, Priority.ALWAYS);
        
        ObservableList removeList = removeField.getChildren();
        removeList.addAll(region2, mealId, removeMealBtn);
        
        vOrder.setAlignment(Pos.CENTER_RIGHT);
        ObservableList orderList = vOrder.getChildren();
        orderList.addAll(editField, addField, removeField);              
  
        //Event handlers for buttons        
        //Event handler for Complete Order button
        completeOrder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (names.isEmpty()) {
                    orderStatus.setText("No items selected"); 
                    orderStatus.setFill(Color.rgb(210, 39, 30));
                    } else { 
                    orderStatus.setText("Order has been placed and will be deliverd");
                    orderStatus.setFill(Color.rgb(210, 39, 30)); 
                }
              }
            });  
        //Event handler for Details button
        detailsBtn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                new Details();                
            }
        });
        
        //Button Action to add Meal
        addMealBtn.setOnAction(event -> {
            String newMealName = mealName.getText();
            float price = Float.parseFloat(mealPrice.getText());
            MealItem f = MealsAdapter.createMealItem(newMealName, price);
            myMeals.add(f);
            data.add(f);
            mealName.setText("");
            mealPrice.setText("");
        });   
        
        //Button Action to edit Meal
        editBtn.setOnAction(event -> {
            Integer ID = Integer.parseInt(editId.getText());
            String newMealName = editName.getText();
            float price = Float.parseFloat(editPrice.getText());
            MealsAdapter.deleteMealItem(ID);
            MealItem f = MealsAdapter.createMealItem2(ID, newMealName,price);

            myMeals.add(f);
            data.add(f);
            editId.setText("");
            editName.setText("");
            editPrice.setText("");
            this.close();
            new AdminForm();
        });
        
        //Button Action to remove Meal
        removeMealBtn.setOnAction(event -> {
            Integer ID = Integer.parseInt(mealId.getText());
            MealsAdapter.deleteMealItem(ID);
            MealItem f = MealsAdapter.readMealItem(ID);

            //Cheap and awful way of doing this but couldn't find any other way :)
            this.close();
            new AdminForm();
            mealId.setText("");
        });
        
        //Log Out button action
        logOutBtn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                new Login();
                ((Node)(event.getSource())).getScene().getWindow().hide();                            
            }
        }); 
                          
        //Border Pane
        BorderPane border = new BorderPane();
        border.setTop(dBox);
        border.setCenter(table);
        border.setRight(vOrder);
        
        //border.setBottom(bottom);        
        border.setStyle("-fx-background-color:#06c3ad");

        
        Scene scene = new Scene(border);
        
        this.setTitle("Admin Form");
        this.setScene(scene);
        this.setWidth(1000);
        this.show();                   
    }        
}
