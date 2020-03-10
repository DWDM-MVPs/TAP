package fichas.Ficha2;

public class Escola {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Pessoa1","123456789",2000,"987654321",2);
        Aluno aluno = new Aluno(19029,1,"DWDM","123456789");

        System.out.println("Pessoa: " + pessoa.toString() + "\nAluno: " + aluno.toString());
    }
}