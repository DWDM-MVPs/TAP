package tap.ficha1;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    // # #################################### ALUNO
    private int numeroMecanografico;
    public String curso;
    private ArrayList<Disciplina> disciplinas;
    private int numeroDisciplina;

    public Aluno(int numero, int numeroDisciplina, String curso, String nif) {
	super(nif);
	this.numeroMecanografico = numero;
	this.curso = curso;
	this.numeroDisciplina = numeroDisciplina;
    }
    // # ####################################


    // # #################################### NUMERO MECANOGRAFICO
    public int getNumeroMecanografico() {
	return numeroMecanografico;
    }

    public void setNumeroMecanografico(int numeroMecanografico) {
	this.numeroMecanografico = numeroMecanografico;
    }
    // # ####################################


    // # #################################### CURSO
    public String getCurso() {
	return curso;
    }

    public void setCurso(String curso) {
	this.curso = curso;
    }
    // # ####################################


    // # #################################### DISCIPLINA
    public void addDisciplina(String nome, int nota) {
	Disciplina disciplina = new Disciplina();

	disciplina.setNome(nome);
	disciplina.setNota(nota);

	disciplinas.add(disciplina);
    }

    public int getNumeroDisciplina() {
	return numeroDisciplina;
    }

    public void preencherDisciplina(int notas[], String nomes[]) {
	for (int i = 0; i < notas.length; i++) {
	    addDisciplina(nomes[i], notas[i]);
	}
    }

    public ArrayList<Disciplina> getDisciplinas() {
	return disciplinas;
    }
    // # ####################################


    // # #################################### CURRICULO
    public String getCurriculo() {
	StringBuilder s = new StringBuilder(getNome());
	for (Disciplina d : disciplinas) {
	    s.append(d.getNome() + " " + d.getNota() + "\n");
	}
	return s.toString();
    }
    // # ####################################


    @Override
    public String toString() {
	return String.format("%s número:%s, curso:%s", super.toString(), numeroMecanografico, curso);
    }
}
