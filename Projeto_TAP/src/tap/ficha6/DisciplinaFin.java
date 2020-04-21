package tap.ficha6;

import java.io.Serializable;

public class DisciplinaFin extends Disciplina implements Serializable {
    private int nota;

    public  DisciplinaFin(String nome, int nota)
    {
        super(nome);
        this.nota=nota;
    }
    public void setNota(int nota){this.nota=nota;}

    public int getNota() {
        return nota;
    }

    @Override
    public String toString()
    {
        return "Disciplina: " + this.getNome() +
                "\nNota: " + nota;
    }
}
