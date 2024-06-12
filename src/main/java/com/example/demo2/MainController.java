package com.example.demo2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.util.Callback;
import java.util.Hashtable;
import java.util.List;
public class MainController {



    @FXML
    private TableView<Employee> tblEmployee;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> nicColumn;
    @FXML
    private TableColumn<Employee, String> genderColumn;
    @FXML
    private TextField txtFld;
    @FXML
    private ComboBox<Gender> gndCmb;

    private ObservableList<Employee> employees;

    @FXML
    public void initialize() {
        // Initialize the table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nicColumn.setCellValueFactory(new PropertyValueFactory<>("nic"));

        genderColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Employee, String> tcd) {
                Employee employee = tcd.getValue();
                return new SimpleStringProperty(employee.getGender().getName());
            }
        });

        // Load initial data
        loadView();
    }

    public void loadView() {
        List<Employee> empList = EmployeeController.get(null);
        fillTable(empList);

        List<Gender> gendList = GenderController.get();
        ObservableList<Gender> genders = FXCollections.observableArrayList(gendList);

        Gender dummyGender = new Gender();
        dummyGender.setName("Select a Gender");
        genders.add(0, dummyGender);

        gndCmb.setItems(genders);
        gndCmb.getSelectionModel().select(0);
    }

    public void fillTable(List<Employee> emplist) {
        employees = FXCollections.observableArrayList(emplist);
        tblEmployee.setItems(employees);
    }

    @FXML
    public void searchBtnAp(ActionEvent actionEvent) {
        Gender gender = null;

        String name = txtFld.getText();
        Gender selectItem = gndCmb.getSelectionModel().getSelectedItem();

        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("name", name);

        if (!selectItem.getName().equals("Select a Gender")) {
            gender = selectItem;
        }

        if (gender != null) {
            ht.put("gender", gender);
        }

        List<Employee> employees = EmployeeController.get(ht);
        fillTable(employees);
    }

    @FXML
    public void clearBtnAp(ActionEvent actionEvent) {
        loadView();
        txtFld.clear();
        gndCmb.getSelectionModel().select(0);
    }
}

