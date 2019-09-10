package p02.modul1.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import p02.modul1.entity.Category;
import p02.modul1.entity.items;

import java.net.URL;
import java.util.ResourceBundle;

public class modul1controller implements Initializable {

    @FXML
    private TableColumn<Category,Category> colcate;
    @FXML
    private TableColumn<Category,Integer> colprice;
    @FXML
    private TableColumn<Category,String> colname;
    @FXML
    private TableView tabview;
    @FXML
    private TextField txtcatname;
    @FXML
    private ComboBox<Category> combocate;
    @FXML
    private TextField txtprice;
    @FXML
    private TextField txtname;

    private ObservableList<Category> categories;
    private ObservableList<items> items;


    @FXML
    private void menufielonaction(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    private void mnuaboutonaction(ActionEvent actionEvent) {
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        alertInfo.setContentText("Created by Mathias(1472054)");
        alertInfo.setTitle("Information");
        alertInfo.showAndWait();
    }

    @FXML
    private void savebotonaction(ActionEvent actionEvent) {
    }

    @FXML
    private void resetbotonaction(ActionEvent actionEvent) {
    }

    @FXML
    private void updateonaction(ActionEvent actionEvent) {
    }

    @FXML
    private void savecatebotonaction(ActionEvent actionEvent) {
    }

    @FXML
    private void tabclick(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categories = FXCollections.observableArrayList();
        items = FXCollections.observableArrayList();
        tabview.setItems(items);
        combocate.setItems(categories);






    }
}
