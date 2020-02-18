package fichas.Ficha1;

import java.util.Calendar;

public class Exercicio1_Pessoa {
    public Exercicio1_Pessoa(String nome, String nif, int anoNasc, String contacto, double creditos, double despesas) {
	this.nome = nome;
	this.nif = nif;
	this.anoNasc = anoNasc;
	this.contacto = contacto;
	this.creditos = creditos;
	this.despesas = despesas;
    }

    private String nome;
    private String nif;
    private int anoNasc;
    private String contacto;
    private String morada;
    private double creditos;
    private double despesas;

    public int getAnoNasc(){return anoNasc;}
    public String getContacto() {return contacto;}
    public String getNif() {return nif;}
    public String getNome() {return nome;}
    public String getMorada() {return morada;}
    public double getCreditos(){return creditos;}
    public double getDespesas(){return despesas;}

    public void setAnoNasc(int n) {this.anoNasc = n;}
    public void setContacto(String contacto){this.contacto = contacto;}
    public void setNif(String nif){this.nif = nif;}
    public void setNome(String nome) {this.nome = nome;}
    public void setMorada(String morada){this.morada = morada;}
    public void setCreditos(double creditos){this.creditos = creditos;}
    public void setDespesas(double despesas){this.despesas = despesas;}

    public int idade(){
	var year = Calendar.getInstance().get(Calendar.YEAR);
	return year - this.anoNasc;
    }
    public double dinheiro(){
        return creditos - despesas;
    }
}