package employee.view;

import employee.Main;
import java.io.IOException;
import javafx.fxml.FXML;

public class MainViewController {
    private Main main;
    
   /* @FXML
    private void goHome() throws IOException{
        main.showMainView();
    }*/
    
    @FXML
    private void addBtn() throws IOException{
        main.showRegistrStage();
    }
     @FXML
     private void aboutB() throws IOException{
        main.showAbout();
} 
     @FXML
     private void loginL() throws IOException{
        main.showLoginStage();
}
  
   
}
