package estudo.individual.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Convidado implements Serializable {
    private static final long serialVersionUID=1L;
    @ManyToOne
    private Evento evento;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    @Id
    @Size(max = 11)
    private String rg;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
