package employee.view;

import employee.Main;
import employee.DataBase;
import java.io.IOException;
import javafx.fxml.FXML;

public class MainItemsController {
   private Main main;
    @FXML
    public void goElectrical() throws IOException{
        main.showElectricalScene();
}
    @FXML
    public void goMechanical() throws IOException{
        main.showMechanicalScene();
    }
 

}
