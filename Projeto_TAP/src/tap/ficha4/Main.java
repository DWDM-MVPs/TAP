package tap.ficha4;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Docente[] docentes;
        Aluno[] alunos;
        Funcionario[] funcionarios;

        while (true)
        {
            char op = '\0';

            SpamEnter();

            System.out.println("Clique [A] para criar um Aluno.");
            System.out.println("Clique [D] para criar um Docente.");
            System.out.println("Clique [F] para criar um Funcionário");
            System.out.println();
            System.out.println("Clique [R] para remover um Aluno, Docente ou Funcionário");
            System.out.println("Clique [B] para sair.");

            op = Character.toLowerCase(s.next().charAt(0));

            if (op == 'b'){
                break;
            }
            else if (op == 'a'){
                CriarNovoAluno();
            }
            else if (op == 'd'){
                CriarNovoDocente();
            }
            else if (op == 'f'){
                CriarNovoFuncionario();
            }
            else if (op == 'r'){
                RemoverPessoa();
            }
        }
    }

    private static void CriarNovoAluno() {
        Aluno aluno = new Aluno();

        System.out.println("< = [ NOVO ALUNO ] = >");
        System.out.println("Nome: "); aluno.setNome(s.next());
        System.out.println("NIF: "); aluno.setNif(s.nextInt());
        System.out.println("Ano de nascimento: "); aluno.setAnoNascimento(s.nextInt());
        System.out.println("Contacto: "); aluno.setContacto(s.next());
        System.out.println("Número mecanográfico: "); aluno.setNumeroMecanografico(s.nextInt());
        System.out.println("Curso: "); aluno.setCurso(s.next());

        System.out.println();
        System.out.println("Insira as UCs (b para parar)");
        System.out.println();

        int count = 0;
        while (true){
            SpamEnter();

            count++;
            System.out.println("UC " + count);
            UC uc = new UC();

            System.out.println("Insira o nome da UC: "); uc.setNome(s.next());
            System.out.println("UC finalizada? (true/false): "); uc.setFinalizada(s.nextBoolean());
            if (uc.getFinalizada()){
                System.out.println("Insira a nota final da UC:"); uc.setNotaFinal(s.nextInt());
            }

            // TODO
            // PEGAR NA LISTA DE UCS EXISTENTE E ADICIONAR A NOVA
            // TODO

            SpamEnter();
            char op = '\0';
            System.out.println("UC adicionada. Clique uma tecla qualquer para continuar a criar UCs ou 'b' para voltar ao menu?"); op = LerChar();

            if (op == 'b'){
                break;
            }
        }

        System.out.println("Aluno adicionado. ENTER para continuar..."); s.next();
    }

    private static void CriarNovoDocente() {
        Docente docente = new Docente();

        System.out.println("< = [ NOVO DOCENTE ] = >");
        System.out.println("Nome: "); docente.setNome(s.next());
        System.out.println("NIF: "); docente.setNif(s.nextInt());
        System.out.println("Ano de nascimento: "); docente.setAnoNascimento(s.nextInt());
        System.out.println("Contacto: "); docente.setContacto(s.next());
        System.out.println("Número de docente: "); docente.setNumeroDocente(s.nextInt());

        int count = 0;
        while (true){
            SpamEnter();

            count++;
            System.out.println("UC " + count);
            UC uc = new UC();

            System.out.println("Insira o nome da UC: "); uc.setNome(s.next());

            SpamEnter();
            char op = '\0';
            System.out.println("UC adicionada. Clique uma tecla qualquer para continuar a criar UCs ou 'b' para voltar ao menu?"); op = LerChar();

            if (op == 'b'){
                break;
            }
        }

        count = 0;
        while (true){
            SpamEnter();

            count++;
            System.out.println("UC " + count);
            UC uc = new UC();

            System.out.println("Insira o nome da UC: "); uc.setNome(s.next());
            System.out.println("UC finalizada? (true/false): "); uc.setFinalizada(s.nextBoolean());
            if (uc.getFinalizada()){
                System.out.println("Insira a nota final da UC:"); uc.setNotaFinal(s.nextInt());
            }

            SpamEnter();
            char op = '\0';
            System.out.println("UC adicionada. Clique uma tecla qualquer para continuar a criar UCs ou 'b' para voltar ao menu?"); op = LerChar();

            if (op == 'b'){
                break;
            }
        }
    }

    private static void CriarNovoFuncionario() {
    }

    private static void RemoverPessoa() {
        while (true){
            char op = '\0';

            SpamEnter();

            System.out.println("Clique [A] para remover um Aluno");
            System.out.println("Clique [D] para remover um Docente");
            System.out.println("Clique [F] para remover um Funcionário");
            System.out.println();
            System.out.println("Clique [B] para voltar para o menu");

            op = LerChar();

            if (op == 'b'){
                break;
            }
        }
    }

    private static char LerChar(){
        return Character.toLowerCase(s.next().charAt(0));
    }

    private static void SpamEnter(){
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }
}
