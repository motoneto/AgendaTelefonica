package tb.controller.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import tb.controller.modelo.Pessoa;

public class EditarPessoaController {

    @FXML
    private TextField IdField;
    @FXML
    private TextField NomeField;
    @FXML
    private TextField TelefoneField;


    private Stage dialogStage;
    private Pessoa pessoa;
    private boolean okClicked = false;
    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Pessoa person) {
        this.pessoa = person;

        NomeField.setText(person.getNome());
        IdField.setText(Integer.toString(person.getId()));
        TelefoneField.setText(Integer.toString(person.getTelefone()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            pessoa.setNome(NomeField.getText());
            pessoa.setId(IdField.getText()));
            pessoa.setTelefone(TelefoneField.getText());
          
            okClicked = true;
            dialogStage.close();
        }
    }
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (NomeField.getText() == null || NomeField.getText().length() == 0) {
            errorMessage += "Nome inválido!\n"; 
        }
        if (IdField.getText() == null || IdField.getText().length() == 0) {
            errorMessage += "Id inválido!\n"; 
        }
        if (TelefoneField.getText() == null || TelefoneField.getText().length() == 0) {
            errorMessage += "Telefone inválida!\n";              
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Dialogs.create()
                .title("Campos Inválidos")
                .masthead("Por favor, corrija os campos inválidos")
                .message(errorMessage)
                .showError();
            return false;
        }
    }
}