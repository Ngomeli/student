package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    @FXML
    private Label statusCheck;

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


    public void onBtnSearchAction(ActionEvent actionEvent) {
        /*
    SELECT * FROM tablename = WHERE ADMNO=?
    ResultSet rs = search.updateQuery();
    while(rs.next()){

   */
        myConnection connection = new myConnection();
        Connection con;
        {
            try {
                con = connection.getConnection();
                PreparedStatement search = con.prepareStatement("SELECT * FROM student WHERE admno=?");
                search.setString(1, txtAdmno.getText());
                ResultSet rs = search.executeQuery();
                while (rs.next()) {
                    search.setString(2, txtName.getText());
                    search.setString(3, spGender.getValue());
                    search.setString(4, String.valueOf(calDOB.getValue()));
                    search.setString(5, spMajor.getValue());
                    search.setString(6, txtAddress.getText());
                    search.setString(7, txtPhone.getText());
                }

            } catch (Exception d) {
                System.out.println("Error " + d.getMessage());
            }
        }
    }

    public void onBtnAddAction(ActionEvent actionEvent) {
        myConnection connection = new myConnection();
        Connection con;
        {
            try {
                con = connection.getConnection();
                try (PreparedStatement add = con.prepareStatement("insert into student(sname,gender,admno,dob,major,address,phoneno) values(sname=?,gender=?,admno=?,dob=?,major=?,address=?,phoneno=?)")) {
                    add.setString(1, txtName.getText());
                    add.setString(2, spGender.getValue());
                    add.setString(3, txtAdmno.getText());
                    add.setString(4, String.valueOf(calDOB.getValue()));
                    add.setString(5, spMajor.getValue());
                    add.setString(6, txtAddress.getText());
                    add.setString(7, txtPhone.getText());
                    add.executeUpdate();
                    if (add.executeUpdate() == 0) {
                        statusCheck.setText("Error");
                    } else {
                        statusCheck.setText("Success");
                    }
                }
            } catch (Exception d) {
                System.out.println("Error " + d.getMessage());
            }
        }
    }

    public void onBtnUpdateAction(ActionEvent actionEvent) {
        myConnection connection = new myConnection();
        Connection con;

        {
            try {
                con = connection.getConnection();
                PreparedStatement update = con.prepareStatement("update student set sname=?,gender=?,address=?,dob=?,major=?,phoneno=? where admno=?");
                update.setString(1, txtName.getText());
                update.setString(2, spGender.getValue());
                update.setString(3, txtAddress.getText());
                update.setString(4, String.valueOf(calDOB.getValue()));
                update.setString(5, spMajor.getValue());
                update.setString(6, txtPhone.getText());
                update.setString(7, txtAdmno.getText());
                update.executeUpdate();
                if (update.executeUpdate() == 0) {
                    statusCheck.setText("Error");
                } else {
                    statusCheck.setText("Success");
                }
            } catch (Exception d) {
                System.out.println("Error " + d.getMessage());
            }
        }
    }

    public void onBtnDeleteAction(ActionEvent actionEvent) throws SQLException {
        myConnection connection = new myConnection();
        Connection con;

        {
            try {
                con = connection.getConnection();
                PreparedStatement delete = con.prepareStatement("delete from student where admno=?");
                delete.setString(1, txtAdmno.getText());
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
