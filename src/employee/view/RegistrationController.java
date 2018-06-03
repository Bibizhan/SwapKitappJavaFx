package employee.view;

import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegistrationController {
    ObservableList<String> maritalStatusList = FXCollections.observableArrayList("Student", "Teacher");
   // ObservableList<String> mainDepartmentList = FXCollections.observableArrayList("Engineering", "Filology");
    //Contact Inf
    
 @FXML
 private TextField nameField;
 @FXML
 private TextField adressField;
 @FXML
 private TextField cityField;
 @FXML
 private TextField phoneField;
 @FXML
 private TextField emailField;
 
 //personal inf
 @FXML
 private DatePicker dateofBirth;
 @FXML
 private TextField ageField;
 @FXML
 private ChoiceBox maritalStatusBox;
 @FXML
 private RadioButton maleBtn;
 @FXML
 private RadioButton femalebtn;
 
 
 @FXML
 private void initialize(){
     maritalStatusBox.setValue("Student");
     maritalStatusBox.setItems(maritalStatusList);
 
 }
 
 @FXML
 private void showAge(){
     Calendar now = Calendar.getInstance();
     int year = now.get(Calendar.YEAR);
     int birthYear = (dateofBirth.getValue().getYear());
     int age = year -  birthYear;
     ageField.setText(Integer.toString(age)+ " Years");
 }
}
