package tb.controller.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persons")
public class ListaPessoa {

    private List<Pessoa> persons;

    @XmlElement(name = "person")
    public List<Pessoa> getPersons() {
        return persons;
    }

    public void setPersons(List<Pessoa> persons) {
        this.persons = persons;
    }
}