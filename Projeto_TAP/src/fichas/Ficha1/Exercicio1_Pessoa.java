package fichas.Ficha1;

import java.util.Calendar;

public class Exercicio1_Pessoa {
    public Exercicio1_Pessoa(String nome, String nif, int anoNasc, String contacto) {
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