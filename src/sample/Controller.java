package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public Controller() throws SQLException {
    }

    public void onBtnSearchAction(ActionEvent actionEvent) {
    }

    public void onBtnAddAction(ActionEvent actionEvent) {
    }

    public void onBtnUpdateAction(ActionEvent actionEvent) {
    }

    public void onBtnDeleteAction(ActionEvent actionEvent) throws SQLException {
        myConnection connection = new myConnection();
        Connection con;

        {
            try {
                con = connection.getConnection();
                PreparedStatement delete = con.prepareStatement("delete from student where admno=?");
                delete.setString(1, "18-1112");
                delete.execute();
            } catch (Exception d) {
                System.out.println("Error " + d.getMessage());
            }
        }

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
}
