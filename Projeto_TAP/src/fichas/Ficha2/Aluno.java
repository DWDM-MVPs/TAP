package fichas.Ficha2;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int numeroMecanico;
    public String curso;
    private ArrayList<Disciplina> disciplinas;
    private int numeroDeDisciplinas;

    public Aluno(int numero, int quantidade, String curso, String nif){
        super(nif);
        this.numeroMecanico=numero;
        this.curso=curso;
        disciplinas= new ArrayList<Disciplina>();
        numeroDeDisciplinas =quantidade;
    }

    public void setNumeroMecanico(int numeroMecanico) {
        this.numeroMecanico = numeroMecanico;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getNumeroMecanico() {
        return numeroMecanico;
    }

    public String getCurso() {
        return curso;
    }

    public int getNumeroDeDisciplinas() {
        return numeroDeDisciplinas;
    }

    public void adicionarDisciplina(String nome, int nota){
        Disciplina d=new Disciplina();
        d.setNome(nome);
        d.setNota(nota);
        disciplinas.add(d);
    }
    public void preencherDisciplina(int notas[], String nomes[]){
        for (int i=0; i<notas.length;i++){
            adicionarDisciplina(nomes[i],notas[i]);
        }
    }

    @Override
    public String toString() {
        return String.format("%s número:%s, curso:%s", super.toString(), numeroMecanico, curso);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
