package tap.ficha7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Gestor g = new Gestor();
    static Scanner sc = new Scanner(System.in);
    static Save save = new Save();

    public static void main(String[] args) throws Exception {

        String op  = MostrarMenu();

        switch (op){
            case "1":
                System.out.println("Criar aluno (1), docente (2) ou funcionário (3) ?");
                g.addPessoa(sc.nextInt());
                break;
            case "2":
                System.out.println("Insira o NIF da pessoa a apagar: ");
                g.removerPessoa(sc.next());
                break;
            case "3":
                System.out.println("Listar alunos (1), docentes (2) ou funcionários (3) ?");
                g.verListagens(sc.nextInt(), null);
            case "4":
                System.out.println("Idade mínima dos alunos (1), docentes (2) ou funcionários (3) ?");
                g.idadeMinima(sc.nextInt());
            case "5":
                System.out.println("Idade média dos alunos (1), docentes (2) ou funcionários (3) ?");
                g.idadeMedia(sc.nextInt());
            case "6":
                System.out.println("Idade máxima dos alunos (1), docentes (2) ou funcionários (3) ?");
                g.idadeMaxima(sc.nextInt());
            case "7":
                System.out.println("Insira o nome do curso:");
                g.qtosCurso(sc.next());
            case "8":
                System.out.println("Número médio de UCs dos docentes: " + g.mediaUcs());
            case "9":
                for (Pessoa p : g.getListagem()) {
                    save.guardarPessoa(p);
                }
                break;
            case "11":
                System.out.println("Ler ficheiro dos alunos (1), docentes (2) ou funcionários (3) ?");
                ArrayList<Pessoa> pessoas = new ArrayList<>();
                int escolha = sc.nextInt();
                switch(escolha){
                    case 1:
                        for (Pessoa p : save.lerAlunos())
                        {
                            pessoas.add(p);
                        }
                        break;
                    case 2:
                        for (Pessoa p : save.lerDocentes())
                        {
                            pessoas.add(p);
                        }
                        break;
                    case 3:
                        for (Pessoa p : save.lerFuncionarios())
                        {
                            pessoas.add(p);
                        }
                        break;
                }
                g.verListagens(escolha, pessoas);
                break;
            case "12":
                System.out.println("Guardar alunos (1), docentes (2) ou funcionários (3) ?");
                for (Pessoa p : g.listagens(sc.nextInt()))
                {
                    save.guardarPessoa(p);
                }
                break;
            case "0":
                System.exit(0);
        }
    }

    public static String MostrarMenu(){
        System.out.println("\nEscolha opção\n");
        System.out.println("1 - Introduzir pessoas na listagem");
        System.out.println("2 - Eliminar pessoa");
        System.out.println("3 - Ver listagens");
        System.out.println("4 - Idade mínimia por tipo de pessoas");
        System.out.println("5 - Idade média por tipo de pessoas");
        System.out.println("6 - Idade máxima por tipo de pessoas");
        System.out.println("7 - Número de alunos num curso");
        System.out.println("8 - Número médio de UCs dos docentes");
        System.out.println("9 - Guardar informações gerais das pessoas em ficheiro TXT");
        System.out.println("10 - Guardar pessoas em ficheiro de objectos");
        System.out.println("11 - Ler pessoas de ficheiro");
        System.out.println("12 - Guardar informações de um determinado tipo de pessoas em ficheiro TXT");
        System.out.println("0 - Sair.");

        return sc.next();
    }
}
