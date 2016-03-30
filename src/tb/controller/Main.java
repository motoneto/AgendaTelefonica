package tb.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tb.controller.modelo.Pessoa;
import tb.controller.view.EditarPessoaController;
import tb.controller.view.VisualizadorController;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane menu;
    private ObservableList<Pessoa> personData = FXCollections.observableArrayList();
    

    public Main() {
        personData.add(new Pessoa("1", "Mauricio", "99023808"));
        personData.add(new Pessoa("1", "Mauricio", "99023808"));
        personData.add(new Pessoa("1", "Mauricio", "99023808"));
        personData.add(new Pessoa("1", "Mauricio", "99023808"));
        personData.add(new Pessoa("1", "Mauricio", "99023808"));
        
        }
    public void showVisualizador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Visualizador.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            menu.setCenter(personOverview);

            VisualizadorController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Pessoa> getPersonData() {
        return personData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AgendaTelefonica");
        this.primaryStage.getIcons().add(new Image("file:resources/images/icone.png"));
        initRootLayout();

        showVisualizador();
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
    public boolean showPersonEditDialog(Pessoa person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EditarPessoa.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Pessoa");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditarPessoaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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