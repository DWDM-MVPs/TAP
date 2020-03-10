package fichas.Ficha1;

public class Exercicio1 {
    public static void main(String[] args) {
	Exercicio1_Pessoa pessoa;

	pessoa = new Exercicio1_Pessoa("abc", "abc", 2000, "abc",0,0);

	pessoa.setNome("pessoaX");
	pessoa.setNif("123456789");
	pessoa.setAnoNasc(2004);
	pessoa.setContacto("pessoaX@gmail.com");
	pessoa.setCreditos(20);
	pessoa.setDespesas(10);

	System.out.println("Nome: " + pessoa.getNome() + "\nNIF: " + pessoa.getNif() + "\nAno de Nascimento: " + pessoa.getAnoNasc()+" (" + pessoa.idade() + " anos)\nContacto: " + pessoa.getContacto() + "\nDinheiro: " + pessoa.dinheiro()+"€");
    }
}