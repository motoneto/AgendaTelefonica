package tb.controller.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	    }
}
