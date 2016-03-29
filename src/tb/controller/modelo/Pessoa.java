package tb.controller.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {

	 private final StringProperty Nome;
	 private final SimpleIntegerProperty Telefone;
	 private final IntegerProperty Id;

	 public Pessoa() {
		    this(null, null, null);
		}

	public Pessoa(Integer Id, String Nome, Integer telefone) {
		 this.Id = new SimpleIntegerProperty(Id);
		 this.Nome = new SimpleStringProperty(Nome);
		 this.Telefone = new SimpleIntegerProperty(telefone);
		 
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
	    
	    public int getId() {
	        return Id.get();
	    }

	    public void setId(int Id) {
	        this.Id.set(Id);
	    }

	    public IntegerProperty IdProperty() {
	        return Id;
	    }
	        public int getTelefone() {
	            return Telefone.get();
	        }

	        public void setTelefone(int Telefone) {
	            this.Telefone.set(Telefone);
	        }

	        public IntegerProperty TelefoneProperty() {
	            return Telefone;
	        }    
}
