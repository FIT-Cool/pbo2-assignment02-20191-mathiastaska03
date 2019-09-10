package p02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("modul1/view/modul1.fxml"));
        primaryStage.setTitle("P02");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
