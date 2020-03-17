package tap.ficha4;

import java.util.Calendar;

public abstract class Pessoa {






    // NOME
    private String nome;

    public void setNome(String Name) {
        this.nome = Name;
    }
    public String getNome(){
        return this.nome;
    }
    // NOME


    // NIF
    private int nif;

    public void setNif(int nif){
        this.nif = nif;
    }
    public int getNif (){
        return this.nif;
    }
    // NIF


    // ANO NASCIMENTO
    private int anoNascimento;

    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int AnoNascimento) {
        this.anoNascimento = AnoNascimento;
    }

    public int getIdade(){
        return Calendar.getInstance().get(Calendar.YEAR) - this.anoNascimento;
    }
    // ANO NASCIMENTO


    // CONTACTO
    private String contacto;

    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    public String getContacto(){
        return this.contacto;
    }
    // CONTACTO





    public String QualTipoPessoa() {
        Class c = this.getClass();
        return c.getName();
    }
}