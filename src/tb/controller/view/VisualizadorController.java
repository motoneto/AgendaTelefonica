package tb.controller.view;
import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import tb.controller.Main;
import tb.controller.modelo.Pessoa;

public class VisualizadorController {

	 @FXML
	    private TableView<Pessoa> personTable;
	    @FXML
	    private TableColumn<Pessoa, String> IdColumn;
	    @FXML
	    private TableColumn<Pessoa, String> NomeColumn;
	    @FXML
	    private TableColumn<Pessoa, String> TelefoneColumn;
	    @FXML
	    private Label IdLabel;
	    //@FXML
	    //private TextField IdTextField;
	    @FXML
	    private Label NomeLabel;
	    @FXML
	    private Label TelefoneLabel;
	    private Main main;
	    public VisualizadorController() {
	    }
	
	    @FXML
	    private void initialize() {
	        IdColumn.setCellValueFactory(cellData -> cellData.getValue().IdProperty());
	        NomeColumn.setCellValueFactory(cellData -> cellData.getValue().NomeProperty());
	        TelefoneColumn.setCellValueFactory(cellData -> cellData.getValue().TelefoneProperty());
	        
	        //IdColumn.setCellValueFactory(cellData -> cellData.getValue().IdProperty());
	        
	        showPersonDetails(null);

	        personTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showPersonDetails(newValue));
	        
	    }
	    public void setMain(Main main) {
	        this.main = main;
	        personTable.setItems(main.getPersonData());
	    }
	    private void showPersonDetails(Pessoa person) {
	        if (person != null) {
	            NomeLabel.setText(person.getNome());
	            IdLabel.setText(person.getId());
	            TelefoneLabel.setText(person.getTelefone());
	        } else {
	            NomeLabel.setText("");
	            IdLabel.setText("");
	            TelefoneLabel.setText("");
	        }
	    }
	    @FXML
	    private void handleDeletePerson() {
	        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            personTable.getItems().remove(selectedIndex);
	        } else {
	            Dialogs.create()
	                .title("Nenhuma seleção")
	                .masthead("Nenhuma Pessoa Selecionada")
	                .message("Por favor, selecione uma pessoa na tabela.")
	                .showWarning();
	        }
	    }
	    
}
