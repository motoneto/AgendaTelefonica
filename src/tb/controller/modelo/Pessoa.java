package tb.controller.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

	 private final StringProperty Nome;
	 private final StringProperty Telefone;
	 private final StringProperty Id;

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

	    public StringProperty IdProperty() {
	        return Id;
	    }
	        public String getTelefone() {
	            return Telefone.get();
	        }

	        public void setTelefone(String Telefone) {
	            this.Telefone.set(Telefone);
	        }

	        public StringProperty TelefoneProperty() {
	            return Telefone;
	        }
}
