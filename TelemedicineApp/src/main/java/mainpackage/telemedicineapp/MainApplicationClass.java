package mainpackage.telemedicineapp;

import Poran.Doctor.DummyObjectCreator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("/mainpackage.telemedicineapp/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Telemedicine App");
        stage.setScene(scene);
        stage.show();
        DummyObjectCreator a = new DummyObjectCreator();
        //a.createDummyObjects();
    }

    public static void main(String[] args) {launch();
    }
}