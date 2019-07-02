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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import javafx.util.Callback;


/**
 *
 * @author Arturo
 */
public class CustomerForm extends Stage {

    CustomerForm() {
        //Creating Text 
        Text name = new Text();
        Text order = new Text();
        Text deliveryTxt = new Text();
        Text orderStatus = new Text();
        float priceT = 0;
        
        String text = "Arturo Garrido Jauckens";
        //Style for text
        name.setText(text);
        name.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        name.setFill(Color.WHITE);

        deliveryTxt.setText("Delivery");
        deliveryTxt.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,17 ));
        deliveryTxt.setFill(Color.WHITE);        
        
        order.setText("Order");
        order.setFont(Font.font("Century Gothic", FontWeight.SEMI_BOLD,20));
        order.setFill(Color.WHITE);

        
        //Creating Buttons
        Button detailsBtn = new Button("Details");
        Button logOutBtn = new Button("Log Out");
        Button completeOrder = new Button("Complete Order");
        //Creating comboBox
        ComboBox comboBox = new ComboBox();
        
        //Style of buttons

        detailsBtn.setMinWidth(100);
        detailsBtn.setStyle("-fx-font-family:'Century Gothic'");

        logOutBtn.setMinWidth(100);
        logOutBtn.setStyle("-fx-font-family:'Century Gothic'");
        
        completeOrder.setMinWidth(250);
        completeOrder.setMinHeight(100);
        completeOrder.setStyle("-fx-font-family:'Century Gothic'");
       
        //Set up list for meals
        List<MealItem> myMeals = MealsAdapter.readAllMealItems();
        
        //Options for comboBox
        ObservableList<String> options = 
        FXCollections.observableArrayList(
        "2 times a week",
        "3 times a week",
        "4 times a week");
        
        //population of comboBox
        comboBox.setItems(options);
        
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
        //mealsCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("ID"));
        mealsCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("price"));
        actionCol.setCellValueFactory(new PropertyValueFactory<MealItem,String>("DUMMY"));
        
        //empieza
        //Adding button to table
        Callback<TableColumn<MealItem, String>, TableCell<MealItem, String>> cellFactory
                = 
                new Callback<TableColumn<MealItem, String>, TableCell<MealItem, String>>() {
            @Override
            public TableCell call(final TableColumn<MealItem, String> param) {
                final TableCell<MealItem, String> cell = new TableCell<MealItem, String>() {

                    final Button btn = new Button("Add");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                MealItem info = getTableView().getItems().get(getIndex());
                                names.addAll(info.getName()+"  "+info.getPrice());
                                //para sumar al final si hay tiempo 
                                priceTotal.addAll(info.getPrice()); 
                                
                                //System.out.println(info.getName()
                                  //      + "   " + info.getPrice());
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        
        actionCol.setCellFactory(cellFactory);
        
        table.getColumns().addAll(mealsCol, priceCol, actionCol);
        table.setItems(data);
        
        //Oder list view
        final ListView listView = new ListView(names);
        listView.setPrefSize(200,250);
        listView.setEditable(true);
        
        //Adding Image
        Image logo = new Image("file:logo.jpg");
        ImageView iv1 = new ImageView();
        iv1.setFitHeight(100);
        iv1.setFitWidth(250);
        iv1.setImage(logo);
       
        //Instantiating Boxes
        HBox dBox = new HBox();//dbox = details box
        HBox bottom = new HBox();
        VBox vOrder = new VBox();
        HBox delivery = new HBox();
        
        //Setting the space between the nodes of a HBox pane 
        dBox.setSpacing(10); 
        
        //Setting the margings Box's nodes
        dBox.setMargin(name, new Insets(20,2,30,2)); 
        dBox.setMargin(detailsBtn, new Insets(20,2,2,2)); 
        dBox.setMargin(logOutBtn, new Insets(20,10,2,2)); 
        
        Region region1 = new Region();
        dBox.setHgrow(region1, Priority.ALWAYS);
        
        dBox.setAlignment(Pos.TOP_RIGHT);
        ObservableList list = dBox.getChildren();
        list.addAll(iv1,region1,name, detailsBtn, logOutBtn);
        
        delivery.setMargin(comboBox, new Insets(10,2,2,2));
        delivery.setMargin(deliveryTxt, new Insets(10,2,2,2));
        
        delivery.setAlignment(Pos.TOP_RIGHT);
        ObservableList deliverList = delivery.getChildren();
        deliverList.addAll(deliveryTxt, comboBox);
        
        vOrder.setMargin(order, new Insets(0,2,0,2));
        vOrder.setMargin(listView, new Insets(0,2,2,2));

        vOrder.setAlignment(Pos.TOP_CENTER);
        ObservableList list1 = vOrder.getChildren();
        list1.addAll(order, listView, delivery,orderStatus);
        
        bottom.setAlignment(Pos.CENTER_RIGHT);
        ObservableList list2 = bottom.getChildren();
        list2.addAll(completeOrder);
        
        //settings for listview table
        vOrder.setSpacing(5); 
        vOrder.setPadding(new Insets(0, 10, 10, 10));
        vOrder.setPrefSize(325, 600);
        //vOrder.getChildren().addAll(table);
        
        
        bottom.setPadding(new Insets(20, 70, 20, 20));
        
        //Event handlers for buttons
        
        //Event handler for Complete Order button
        completeOrder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (names.isEmpty()) {
                    orderStatus.setText("No items selected"); 
                    orderStatus.setFill(Color.rgb(210, 39, 30));
                    }else if(comboBox.getSelectionModel().isEmpty()){
                        orderStatus.setText("Select delivery");
                        orderStatus.setFill(Color.rgb(210, 39, 30));                         
                    }else { 
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
        
        //Event handler for Log out button
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
        border.setBottom(bottom);
        border.setStyle("-fx-background-color:#06c3ad");
        
        Scene scene = new Scene(border);
        
        this.setTitle("Customer Form");
        this.setScene(scene);
        this.setHeight(700);
        this.setWidth(1000);
        this.show();       
    }        
}
