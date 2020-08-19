package estudo.individual.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity

public class Evento implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String Endereco;
    @NotNull
    private String cidade;
    @NotNull
    private String datae;
    @NotNull
    private String horario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    private Usuario usuario;

    public List<Convidado> getConvidado() {
        return convidado;
    }

    public void setConvidado(List<Convidado> convidado) {
        this.convidado = convidado;
    }

    @OneToMany
    private List<Convidado> convidado;

    public Evento() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatae(){ return datae;}

    public void setDatae(String datae){this.datae = datae;}

    public String getHorario(){return horario;}

    public void setHorario(String horario){this.horario =horario;}

    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


}
