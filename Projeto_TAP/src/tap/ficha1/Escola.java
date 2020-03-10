package tap.ficha1;

public class Escola {
    public static void main(String[] args) {
	Pessoa pessoa = new Pessoa("Mike", "123456789", 2001, "987654321", 1.85);
	pessoa.setAltura(1.90);

	System.out.println("Aluno matriculado no curso " + ((Aluno) pessoa).getCurso());
    }
}