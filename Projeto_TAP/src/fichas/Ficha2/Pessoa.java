package fichas.Ficha2;

import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String nif;
    private int anoDeNascimento;
    private String contacto;
    private double altura;

    public Pessoa(String nome, String nif, int anoDeNascimento, String contacto, double altura) {
        this.nome = nome;
        this.nif = nif;
        this.anoDeNascimento = anoDeNascimento;
        this.contacto = contacto;
        this.altura = altura;
    }

    public Pessoa(String nif){
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public String getNif() {
        return nif;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public String getContacto() {
        return contacto;
    }

    public double getAltura() {
        return altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }

    @Override
    public String toString(){
        return String.format("%s nome:%s, nif:%s", super.toString(), nome,nif);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    public int idade() {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        return ano- anoDeNascimento;
    }

    public double tamanho(){
        if(altura<1.50){
            System.out.println("Baixo");
        }else{
            System.out.println("Alto");
        }
        return altura;
    }
}