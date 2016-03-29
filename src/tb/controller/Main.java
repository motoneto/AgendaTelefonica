package tb.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tb.controller.modelo.Pessoa;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane menu;
    private ObservableList<Pessoa> personData = FXCollections.observableArrayList();

    public Main() {
        // Add some sample data
        personData.add(new Pessoa(1, "Mauricio", 99023808));
        personData.add(new Pessoa(1, "Mauricio", 99023808));
        personData.add(new Pessoa(1, "Mauricio", 99023808));
        personData.add(new Pessoa(1, "Mauricio", 99023808));
        personData.add(new Pessoa(1, "Mauricio", 99023808));
        
        }
    public ObservableList<Pessoa> getPersonData() {
        return personData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/menu.fxml"));
            menu = (BorderPane) loader.load();
            
            Scene scene = new Scene(menu);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Visualizador.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            menu.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}