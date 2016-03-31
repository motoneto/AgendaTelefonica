package tb.controller.view;
import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;

import tb.controller.Main;

public class MenuController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    private void handleNovo() {
        main.getPersonData().clear();
        main.setPersonFilePath(null);
    }
    @FXML
    private void handleAbrir() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

        if (file != null) {
           // main.loadPersonDataFromFile(file);
        }
    }
    @FXML
    private void handleSalvar() {
        File personFile = main.getPersonFilePath();
        if (personFile != null) {
            //main.savePersonDataToFile(personFile);
        } else {
            handleSalvarComo();
        }
    }
    @FXML
    private void handleSalvarComo() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(main.getPrimaryStage());

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            //main.savePersonDataToFile(file);
        }
    }

    @FXML
    private void handleAbout() {
        Dialogs.create()
            .title("AgendaTelefonica")
            .masthead("Sobre")
            .showInformation();
    }

    @FXML
    private void handleSair() {
        System.exit(0);
    }
}
