package tap.ficha7;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    private ArrayList<Pessoa> listagem;
    public Gestor()
    {
        listagem=new ArrayList<Pessoa>();
    }
    public void addPessoa(int tipo)//1-aluno; 2-docente; 3-funcionário
    {
        String nome,nif, contacto;
        int ano,num,n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Qual o nome da pessoa? ");
        nome=sc.nextLine();
        System.out.print("Qual o nif da pessoa? ");
        nif=sc.nextLine();
        System.out.print("Qual o contacto da pessoa? ");
        contacto=sc.nextLine();
        System.out.print("Qual o ano de nascimento da pessoa? ");
        ano=sc.nextInt();
        switch (tipo)
        {
            case 1:
                System.out.print("Qual o curso do aluno? ");
                String curso=sc.next();
                System.out.print("Qual o número do aluno? ");
                num=sc.nextInt();
                Aluno A=new Aluno(nome,contacto,ano,nif,curso,num);
                System.out.print("Quantas disciplinas tem finalizadas? ");
                n=sc.nextInt();
                A.addDiscipinaFinal(n);
                System.out.print("A quantas disciplinas está inscrito? ");
                n=sc.nextInt();
                A.addDiscipina(n);
                listagem.add(A);
                break;
            case 2:
                System.out.print("Qual o departamento do docente? ");
                String dep=sc.next();
                System.out.print("Qual o número do docente? ");
                num=sc.nextInt();
                Docente d=new Docente(nome,contacto,ano,nif,dep,num);
                System.out.print("A quantos cursos dá aulas? ");
                n=sc.nextInt();
                d.addCurso(n);
                System.out.print("Quantas UCs leciona? ");
                n=sc.nextInt();
                d.addUCs(n);
                listagem.add(d);
                break;
            case 3:
                System.out.print("Qual a função do funcionário? ");
                String fun=sc.next();
                System.out.print("Qual o número do funcionário? ");
                num=sc.nextInt();
                Funcionario f=new Funcionario(nome,contacto,ano,nif,fun,num);
                listagem.add(f);
                break;
            default:System.out.println("Tipo de pessoa inválido");
                break;
        }
    }

    public void removerPessoa(String nif)
    {
        for (Pessoa p:listagem) {
            if(p.getNif().equals(nif))
            {
                listagem.remove(p);
                break;
            }

        }
    }

    public ArrayList<Pessoa> getListagem(){
        return listagem;
    }

    public ArrayList<Pessoa> listagens(int tipo)//1-aluno; 2-docente; 3-funcionário
    {
        ArrayList<Pessoa> lista=new ArrayList<Pessoa>();
        switch (tipo)
        {
            case 1:
                for (Pessoa p:listagem) {
                    if(p instanceof Aluno)
                        lista.add(p);
                }
                break;
            case 2:
                for (Pessoa p:listagem) {
                    if(p instanceof Docente)
                        lista.add(p);
                }
                break;
            case 3:
                for (Pessoa p:listagem) {
                    if(p instanceof Funcionario)
                        lista.add(p);
                }
                break;
        }
        return lista;
    }
    public void verListagens(int tipo, ArrayList<Pessoa> lista)//1-aluno; 2-docente; 3-funcionário
    {
        if (lista.size() == 0 || lista == null)
        {
            lista=listagens(tipo);
        }
        Aluno A;
        Docente D;
        Funcionario F;
        switch (tipo)
        {
            case 1:
                System.out.println("Lista de Alunos");
                for (Pessoa p:lista) {
                    A=(Aluno)p;
                    System.out.println("Nome: "+A.getNome()+"; Curso: "+A.getCurso().getNome()+"; Número Aluno: "+A.getNumMec());
                }
                break;
            case 2:
                System.out.println("Lista de Docentes");
                for (Pessoa p:lista) {
                    D=(Docente)p;
                    System.out.println("Nome: "+D.getNome()+"; Departamento: "+D.getDepartamento()+"; Número Docente: "+D.getNumDocente());
                }
                break;
            case 3:
                System.out.println("Lista de Funcionários");
                for (Pessoa p:lista) {
                    F=(Funcionario) p;
                    System.out.println("Nome: "+F.getNome()+"; Função: "+F.getFuncao()+"; Número Func: "+F.getNumFunc());
                }
                break;
        }
    }
    public int idadeMinima(int tipo)//1-aluno; 2-docente; 3-funcionário
    {
        ArrayList<Pessoa> lista=listagens(tipo);
        int min=lista.get(0).idade();
        for (Pessoa p:lista) {
            if(p.idade()<min)
                min=p.idade();
        }
        return min;
    }
    public int idadeMaxima(int tipo)//1-aluno; 2-docente; 3-funcionário
    {
        ArrayList<Pessoa> lista=listagens(tipo);
        int max=lista.get(0).idade();
        for (Pessoa p:lista) {
            if(p.idade()>max    )
                max=p.idade();
        }
        return max;
    }
    public Double idadeMedia(int tipo)//1-aluno; 2-docente; 3-funcionário
    {
        ArrayList<Pessoa> lista=listagens(tipo);
        Double soma=0.0;
        for (Pessoa p:lista) {
            soma=soma+p.idade();
        }
        if (lista.size()>0)
            return soma/lista.size();
        else
            return 0.0;
    }

    public int qtosCurso(String curso)
    {
        int cont=0;
        ArrayList<Pessoa> lista=listagens(1);
        Aluno A;
        for (Pessoa p:lista) {
            A=(Aluno)p;
            if(A.getCurso().equals(curso))
                cont++;
        }
        return cont;
    }

    public Double mediaUcs()
    {
        Double soma=0.0;
        ArrayList<Pessoa> lista=listagens(2);
        Docente D;
        for (Pessoa p:lista) {
            D=(Docente) p;
            soma=soma+D.getUCs().size();
        }
        if (lista.size()>0)
            return soma/lista.size();
        else
            return 0.0;
    }
}
