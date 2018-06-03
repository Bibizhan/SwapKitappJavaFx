package employee;
import employee.Main;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class DataBase {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public String usName, usPassword;
    public TextField nField, sNameField, userNField, userPField;
    
    public DataBase() throws SQLException{
        try{
            Class.forName("com.mysql.jdbe.Driver");
                   
  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base", "root", ""); 
  st =   (Statement) con.createStatement(); 

}
        catch(ClassNotFoundException ex){ 
        System.out.println("Error: "+ex); 
 } 
} 

   public boolean getData(String userName, String pass){ 
   try{ 
   String query1 = " select Name,Password from users;"; 
   rs = st.executeQuery(query1); 

   while(rs.next()){ 
   usName = rs.getString("Name"); 
   usPassword = rs.getString("Password"); 
   if(userName.equals(usName) && pass.equals(usPassword)) 
   return true; 

 } 
}
   catch(SQLException ex){ 
   System.out.println(ex); 
} 
   return false; 
} 
  /* public void newInsert(String unName,String snName, String usersN, String passN ) throws SQLException{ 
   try{ 
   PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO `moneym`(`Name`, `Surname`, `Username`, `Password`) VALUES (?,?,?,?)"); 

   if(unName.equals("")){ 
   pst.setString(1, "set Stroke"); 
   pst.setString(2, "set Stroke"); 
   pst.setString(3, "set Stroke"); 
   pst.setString(4, "set Stroke"); 

} 
   else{ 

   pst.setString(1, unName); 
   pst.setString(2,snName); 
   pst.setString(3,usersN); 
   pst.setString(4, passN); 
} 
   Alert alert = new Alert(AlertType.INFORMATION); 
   alert.setTitle("Information Dialog"); 
   alert.setHeaderText(null); 
   alert.setContentText("User has been created"); 
   alert.showAndWait(); 

    pst.execute(); 
    pst.close(); 

} 
    catch(SQLException e){ 
} 
}*/ 
}

        
    

