package fichas.Ficha1;

public class Exercicio1 {
    public static void main(String[] args) {
	Exercicio1_Pessoa persona, p1, pessoaX;

	persona = new Exercicio1_Pessoa("persona", "123456789", 2002, "persona@gmail.com");
	p1 = new Exercicio1_Pessoa("p1", "123456789", 2003, "p1@gmail.com");
	pessoaX = new Exercicio1_Pessoa("abc", "abc", 000, "abc");

	pessoaX.setNome("pessoaX");
	pessoaX.setNif("123456789");
	pessoaX.setAnoNasc(2004);
	pessoaX.setContacto("pessoaX@gmail.com");

	System.out.println("Nome: " + persona.getNome() + "\nNIF: " + persona.getNif() + "\nAno de Nascimento: " + persona.getAnoNasc()+" (" + persona.idade() + " anos)\nContacto: " + persona.getContacto());
	System.out.println("Nome: " + p1.getNome() + "\nNIF: " + p1.getNif() + "\nAno de Nascimento: " + p1.getAnoNasc()+" (" + p1.idade() + " anos)\nContacto: " + p1.getContacto());
	System.out.println("Nome: " + pessoaX.getNome() + "\nNIF: " + pessoaX.getNif() + "\nAno de Nascimento: " + pessoaX.getAnoNasc()+" (" + pessoaX.idade() + " anos)\nContacto: " + pessoaX.getContacto());
    }
}