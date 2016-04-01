package tb.controller.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

	 private final SimpleStringProperty Nome;
	 private final SimpleStringProperty Telefone;
	 private final SimpleStringProperty Id;

	 public Pessoa() {
		    this(null, null, null);
		}

	public Pessoa(String Id, String Nome, String telefone) {
		 this.Id = new SimpleStringProperty(Id);
		 this.Nome = new SimpleStringProperty(Nome);
		 this.Telefone = new SimpleStringProperty(telefone);
		 
	}
		public String getNome() {
	        return Nome.get();
	    }
	    public void setNome(String Nome) {
	        this.Nome.set(Nome);
	    }
	    public StringProperty NomeProperty() {
	        return Nome;
	    }
	    
	    public String getId() {
	        return Id.get();
	    }

	    public void setId(String Id) {
	        this.Id.set(Id);
	    }

	    public SimpleStringProperty IdProperty() {
	        return Id;
	    }
	        public String getTelefone() {
	            return Telefone.get();
	        }

	        public void setTelefone(String Telefone) {
	            this.Telefone.set(Telefone);
	        }

	        public SimpleStringProperty TelefoneProperty() {
	            return Telefone;
	        }
}
