package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtName;
    @FXML
    private Spinner<String> spGender;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtAdmno;
    @FXML
    private DatePicker calDOB;
    @FXML
    private Spinner<String> spMajor;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnExit;

    public void onBtnSearchAction(ActionEvent actionEvent) {
    }

    public void onBtnAddAction(ActionEvent actionEvent) {
    }

    public void onBtnUpdateAction(ActionEvent actionEvent) {
    }

    public void onBtnDeleteAction(ActionEvent actionEvent) {
    }

    public void onBtnClearAction(ActionEvent actionEvent) {
        txtName.setText("");
        txtSearch.setText("");
        txtAddress.setText("");
        txtAdmno.setText("");
        txtPhone.setText("");
        majorFactory.setValue("Specify Major");
        genderFactory.setValue("Specify Gender");
    }

    public void onBtnExitAction(ActionEvent actionEvent) {
        System.exit(0);
    }
    ObservableList<String> majorList = FXCollections.observableArrayList("ACS", "MIS", "LAW");
    SpinnerValueFactory<String> majorFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(majorList);

    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female", "Other");
    SpinnerValueFactory<String> genderFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(genderList);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        spMajor.setValueFactory(majorFactory);
        majorFactory.setValue("Specify Major");


        spGender.setValueFactory(genderFactory);
        genderFactory.setValue("Specify Gender");
    }
}
