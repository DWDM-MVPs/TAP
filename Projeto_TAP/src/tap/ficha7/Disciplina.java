package tap.ficha7;

import java.io.Serializable;

public class Disciplina implements Serializable {
    private String nome;

    public Disciplina(String nome){this.nome=nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString()
    {
        return "Disciplina: " + nome;
    }
}
