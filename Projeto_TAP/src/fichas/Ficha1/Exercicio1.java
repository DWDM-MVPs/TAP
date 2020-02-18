package fichas.Ficha1;

import java.util.Calendar;

public class Exercicio1 {
    public static class Pessoa{
	public Pessoa(String nome, String nif, int anoNasc, String contacto) {
	    this.nome = nome;
	    this.nif = nif;
	    this.anoNasc = anoNasc;
	    this.contacto = contacto;
	}

        private String nome;
        private String nif;
        private int anoNasc;
        private String contacto;

	public int getAnoNasc(){return anoNasc;}
        public String getContacto() {return contacto;}
        public String getNif() {return nif;}
        public String getNome() {return nome;}
        public void setAnoNasc(int n) {this.anoNasc = n;}
        public void setContacto(String contacto){this.contacto = contacto;}
        public void setNif(String nif){this.nif = nif;}
        public void setNome(String nome) {this.nome = nome;}
        public int idade(){
	    var year = Calendar.getInstance().get(Calendar.YEAR);
	    return year - this.anoNasc;
	}
    }

    public static void main(String[] args) {
	Pessoa persona, p1, pessoaX;

	persona = new Pessoa("persona", "123456789", 2002, "persona@gmail.com");
	p1 = new Pessoa("p1", "123456789", 2003, "p1@gmail.com");
	pessoaX = new Pessoa("pessoaX", "123456789", 2004, "pessoaX@gmail.com");

	System.out.println("Nome: " + persona.getNome() + "\nNIF: " + persona.getNif() + "\nAno de Nascimento: " + persona.getAnoNasc()+" (" + persona.idade() + " anos)\nContacto: " + persona.getContacto());
	System.out.println("Nome: " + p1.getNome() + "\nNIF: " + p1.getNif() + "\nAno de Nascimento: " + p1.getAnoNasc()+" (" + p1.idade() + " anos)\nContacto: " + p1.getContacto());
	System.out.println("Nome: " + pessoaX.getNome() + "\nNIF: " + pessoaX.getNif() + "\nAno de Nascimento: " + pessoaX.getAnoNasc()+" (" + pessoaX.idade() + " anos)\nContacto: " + pessoaX.getContacto());
    }
}