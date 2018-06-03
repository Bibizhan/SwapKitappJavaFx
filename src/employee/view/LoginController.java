
package employee.view;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import employee.DataBase;
import employee.Main;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
     private Main main;
    static DataBase connect;
    @FXML
    private Text invalid_label;
    @FXML
    private Button login; 
 @FXML
 private TextField nameField;
  @FXML
 private PasswordField passwordField;
    private Object primaryStage;
  
  @FXML
  private void okBtn(ActionEvent event) throws IOException, SQLException{
      System.out.println("You clicked login");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("MainItems.fxml"));
        
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        if(isValidCredentials()){
            app_stage.hide();//optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else{
            passwordField.clear();
            invalid_label.setText("Sorry, try again");
        }
     }
   private boolean isValidCredentials()
    {
        boolean let_in=false;
        System.out.println( "SELECT * FROM users WHERE Name= " + "'" + nameField.getText()+"'"
                + " AND Password= " + "'" + passwordField.getText() + "'");
        
        Connection con=null;
        java.sql.Statement st=null;
        try{
            
                   
  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base", "root", ""); 
  st =   (Statement) con.createStatement(); 
            
            con.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            st=con.createStatement();
            
            ResultSet rs=st.executeQuery( "SELECT * FROM users WHERE Name= " + "'" + nameField.getText()+"'"
                + " AND Password= " + "'" + passwordField.getText() + "'");
            
            while( rs.next() ) {
                if(rs.getString("Name") != null && rs.getString("Password") != null) {
                  String username = rs.getString("Name");
                  System.out.println( "Username = " + username );
                  String password = rs.getString("Password");
                  System.out.println("PASSWORD = " + password);
                  let_in = true;
                }
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            
        }
        System.out.println("isValidCredentials operation done succesfully");
        return let_in;
    } 
  
  
  }

