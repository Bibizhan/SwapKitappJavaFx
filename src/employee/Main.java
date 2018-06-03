/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
    private static Stage primaryStage;
    private static BorderPane mainLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("SwapKitapp");
        showMainView();
        //showMainItems();
       
  
    }
   public void showMainView() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout=loader.load();
        Scene scene=new Scene(mainLayout,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    
   }
    
   
   public static void showMainItems() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
        BorderPane mainItems=loader.load();
        mainLayout.setCenter(mainItems);
    }
      public static void showAbout() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/About.fxml"));
        AnchorPane about=loader.load();
        mainLayout.setCenter(about);
      }
   public static void showElectricalScene() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("electrical/ElectricalDep.fxml"));
        BorderPane electricalDep = loader.load();
        mainLayout.setCenter(electricalDep); 
   }
   public static void showMechanicalScene() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("mechanical/MechanicalDep.fxml"));
        BorderPane mechanicalDep = loader.load();
        mainLayout.setCenter(mechanicalDep); 
    }
   public static void showRegistrStage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Registration.fxml"));
        BorderPane registr=loader.load();
      
        Stage addDialogStage=new Stage();
        addDialogStage.setTitle("Registration");
        addDialogStage.initModality(Modality.WINDOW_MODAL); //you can not press other scenes
        addDialogStage.initOwner(primaryStage);
        Scene scene=new Scene(registr);
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();
    }
   public static void showLoginStage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Login.fxml"));
        AnchorPane login =loader.load();
        mainLayout.setCenter(login);
      
     /*   Stage addDialogStage1=new Stage();
        addDialogStage1.setTitle("Log in");
        addDialogStage1.initModality(Modality.WINDOW_MODAL); //you can not press other scenes
        addDialogStage1.initOwner(primaryStage);
        Scene scene=new Scene(login);
        addDialogStage1.setScene(scene);
        addDialogStage1.showAndWait();
        */
    }
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
