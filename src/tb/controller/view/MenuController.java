package tb.controller.view;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;

import tb.controller.Main;

public class MenuController {

	private Main mainApp;
	private Connection con;

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleNew() {
		mainApp.getPersonData().clear();
		// mainApp.setPersonFilePath(null);
	}

	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// mainApp.loadPersonDataFromFile(file);
		}
	}

	@FXML
	private void handleSaveAs() throws SQLException {

		abrirConexao();

		update();
		
		read();

		fecharConexao();
	}

	@FXML
	private void handleAbout() {
		Dialogs.create().title("AddressApp").masthead("Sobre")
				.message("Autor: Marco Jakob\nWebsite: http://code.makery.ch").showInformation();
	}

	@FXML
	private void handleExit() {
		System.exit(0);
	}

	private void abrirConexao() throws SQLException {

		String url = "jdbc:h2:~/BancoMauricio";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);

	}

	private void read() {

		try (Statement st = con.createStatement(); ResultSet result = st.executeQuery("SELECT * FROM PESSOA");) {
			while (result.next()) {
				int id = result.getInt(1);
				String nome = result.getString("nome");
				int telefone = result.getInt("telefone");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private void update() {

		String sql = "UPDATE PESSOA SET ID = ?, NOME = ?, TELEFONE = ? WHERE ID = ?";
	}
	private void fecharConexao() throws SQLException {
		con.close();
	}

}
