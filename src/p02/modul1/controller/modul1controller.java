package p02.modul1.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import p02.modul1.entity.Category;
import p02.modul1.entity.items;

import java.net.URL;
import java.util.ResourceBundle;

public class modul1controller implements Initializable {

    public Button botsave;
    public Button botreset;
    public Button botupdate;
    @FXML
    private TableColumn<Category, Category> colcate;
    @FXML
    private TableColumn<Category, Integer> colprice;
    @FXML
    private TableColumn<Category, String> colname;
    @FXML
    private TableView<items> tabview;
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

    private items selecteditem;

    public ObservableList<Category> getCategories() {
        if (categories == null) {
            categories = FXCollections.observableArrayList();
            //categories.add(new Category("Food"));
        }
        return categories;
    }

    public ObservableList<items> getItems() {
        if (items == null) {
            items = FXCollections.observableArrayList();
            //items.add(new Item("Chocolate", 13250, new Category("Beverages")));
        }
        return items;
    }

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
        int count = (int) categories.stream().filter(p -> p.getName().equalsIgnoreCase(txtname.getText())).count();
        if (txtname.getText().isEmpty() || txtprice.getText().isEmpty()
                || combocate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill name/price/category");
            alert.showAndWait();
        } else if (count >= 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate data");
            alert.showAndWait();
        } else {
            items.add(new items(txtname.getText(), Integer.valueOf(txtprice.
                    getText()), combocate.getValue()));
        }
    }

    @FXML
    private void resetbotonaction(ActionEvent actionEvent) {
        txtname.clear();
        txtprice.clear();
        combocate.setValue(null);
    }

    @FXML
    private void updateonaction(ActionEvent actionEvent) {
        int count = (int) categories.stream().filter(p -> p.getName().
                equalsIgnoreCase(txtname.getText())).count();
        if (!txtname.getText().isEmpty() || !txtprice.getText().isEmpty()
                || combocate.getValue() != null) {
            selecteditem.setName(txtname.getText());
            selecteditem.setPrice(Integer.valueOf(txtprice.getText()));
            selecteditem.setCategory(combocate.getValue());
        } else if (txtname.getText().isEmpty() || txtprice.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill name/price/category");
            alert.showAndWait();
        } else if (count >= 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate name");
            alert.showAndWait();
        }
        botupdate.setDisable(true);
        botsave.setDisable(false);
        resetbotonaction(actionEvent);
        tabview.refresh();
    }

    @FXML
    private void savecatebotonaction(ActionEvent actionEvent) {
        int count = (int) categories.stream().filter(p -> p.getName().
                equalsIgnoreCase(txtcatname.getText())).count();
        if (txtcatname.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill category name");
            alert.showAndWait();
        } else if (count >= 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Duplicate category name");
            alert.showAndWait();
        } else {
            categories.add(new Category(txtcatname.getText()));
        }
        txtcatname.setText("");
    }

    @FXML
    private void tabclick(MouseEvent mouseEvent) {
        selecteditem = (p02.modul1.entity.items) tabview.getSelectionModel().getSelectedItem();
        if (selecteditem!=null){
            txtname.setText((tabview.getSelectionModel().getSelectedItem()).
                    getName());
            txtprice.setText(
                    (tabview.getSelectionModel().getSelectedItem()).
                            getPrice() + "");
            combocate.setValue(tabview.getSelectionModel().getSelectedItem().getCategory());
            botupdate.setDisable(false);
            botsave.setDisable(true);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categories = FXCollections.observableArrayList();
        items = FXCollections.observableArrayList();
        tabview.setItems(getItems());
        combocate.setItems(getCategories());
        colname.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        colprice.setCellValueFactory(new PropertyValueFactory<Category, Integer>("price"));
        colcate.setCellValueFactory(new PropertyValueFactory<Category, Category>("category"));
        combocate.getSelectionModel().getSelectedItem();
    }
}
