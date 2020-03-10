package tap.ficha1;

import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String nif;
    private int anoNasc;
    private String contacto;
    private double altura;

    public Pessoa(String nome, String nif, int anoNasc, String contacto, double altura) {
	this.nome = nome;
	this.nif = nif;
	this.anoNasc = anoNasc;
	this.contacto = contacto;
	this.altura = altura;
    }

    public Pessoa(String nif) {
	this("", nif, 1900, "", 1.80);
    }


    public String getNome() {
	return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // # NIF
    public String getNif() {
	return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    // # ANO NASCIMENTO
    public int getAnoNascimento() {
	return anoNasc;
    }
    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    // # CONTACTO
    public String getContacto() {
	return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    // # ALTURA
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAltura() {
	return altura;
    }






    public int idade() {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        return ano - anoNasc;
    }

    public double tamanho() {
        if (altura < 1.50) {
            System.out.println("Baixo");
        } else {
            System.out.println("Alto");
        }
        return altura;
    }







    @Override
    public boolean equals(Object obj) {
	return super.equals(obj);
    }

    @Override
    public String toString() {
	return String.format("%s nome:%s, nif:%s", super.toString(), nome, nif);
    }

    @Override
    public int hashCode() {
	return super.hashCode();
    }
}