package tap.ficha7;

import java.io.Serializable;

public class Curso implements Serializable {
    String nome;
    public Curso(String nome){this.nome=nome;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString()
    {
        return "Curso: " + nome;
    }
}
