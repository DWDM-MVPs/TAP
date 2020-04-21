package tap.ficha6;

import tap.ficha6.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Pessoa implements Serializable {
    private int numMec;
    private Curso curso;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(String nome,String contac,int ano, String nif,String cursoN,int num)
    {
        setAnoNasc(ano);
        setContacto(contac);
        setNome(nome);
        setNif(nif);
        this.numMec=num;
        disciplinas=new ArrayList<Disciplina>();
        curso=new Curso(cursoN);
    }

    public void setNumMec(int n){numMec=n;}

    public void setCurso(Curso c){curso=c;}

    public int getNumMec(){return numMec;}

    public Curso getCurso(){return curso;}

    public ArrayList<Disciplina> getDisciplinas(){
        return disciplinas;}

    public void addDiscipinaFinal(int n)
    {
        String nome;
        int nota;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++) {
            System.out.print("Qual o nome da UC? ");
            nome = sc.next();
            System.out.print("Qual a nota? ");
            nota=sc.nextInt();
            DisciplinaFin d = new DisciplinaFin(nome, nota);
            disciplinas.add(d);
        }
    }

    public void addDiscipina(int n)
    {
        String nome, resp;
        int nota;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++) {
            System.out.print("Qual o nome da UC? ");
            nome=sc.next();
            System.out.print("A disciplina já está concluída (s/n)? ");
            resp=sc.next();
            if(resp.toUpperCase().equals("S"))
            {
                System.out.print("Qual a nota? ");
                nota=sc.nextInt();
                DisciplinaFin d = new DisciplinaFin(nome, nota);
                disciplinas.add(d);
            }
            else {
                Disciplina d = new Disciplina(nome);
                disciplinas.add(d);
            }
        }
    }


       public int horasPresenciais()
        {
            int cont=0;//contador de disciplinas (não finalizadas)
            for (Disciplina d: disciplinas) {
                if(d != null)
                    cont++;
            }
            return cont*5;
        }



    @Override
    public String toString()
    {
        String stringDisciplinas = "";

        for (Disciplina d : disciplinas)
        {
            stringDisciplinas += d;
        }

        return "Nome: " + this.getNome() +
                "\nNif: " + this.getNif() +
                "\nAno de Nascimento: " +this.getanoNasc() +
                "\nContacto: " + this.getContacto() +
                "\nNúmero: " + numMec +
                "\nCurso: " + curso +
                "\nDisciplinas: " + disciplinas +
                "\nHoras presenciais: " + horasPresenciais();
    }
}
