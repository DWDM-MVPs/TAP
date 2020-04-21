package tap.ficha6;

import tap.ficha4.UC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Docente extends Pessoa implements Serializable {
    private String departamento;
    private ArrayList<Curso> cursos;
    private ArrayList<Disciplina> UCs;
    int numDocente;
    public Docente(String nome,String contac,int ano, String nif, String dep,int num)
    {
        setAnoNasc(ano);
        setContacto(contac);
        setNome(nome);
        setNif(nif);
        this.departamento=dep;
        this.numDocente=num;
        cursos=new ArrayList<Curso>();
        UCs=new ArrayList<Disciplina>();
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getNumDocente() {
        return numDocente;
    }

    public void setNumDocente(int numDocente) {
        this.numDocente = numDocente;
    }

    public int horasPresenciais()
    {return 14;}

    public ArrayList<Curso> getCursos()
    {return cursos;}

    public ArrayList<Disciplina> getUCs() {
        return UCs;
    }

    public void addCurso(int n)
    {
        String nome;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++) {
            System.out.print("Qual o nome do curso? ");
            nome = sc.next();
            Curso c = new Curso(nome);
            cursos.add(c);
        }
    }

    public void addUCs(int n)
    {
        String nome;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++) {
            System.out.print("Qual o nome da UC? ");
            nome = sc.next();
            Disciplina c = new Disciplina(nome);
            UCs.add(c);
        }
    }

    @Override
    public String toString()
    {
        String stringCursos = "";
        for (Curso c : cursos)
        {
            stringCursos += c;
        }

        String stringUcs = "";
        for (Disciplina uc : UCs)
        {
            stringUcs += uc;
        }

        return "Nome: " + this.getNome() +
                "\nNif: " + this.getNif() +
                "\nAno de Nascimento: " +this.getanoNasc() +
                "\nContacto: " + this.getContacto() +
                "\nDepartamento: " + departamento +
                "\nCursos: " + stringCursos +
                "\nUCs: " + stringUcs;
    }
}
