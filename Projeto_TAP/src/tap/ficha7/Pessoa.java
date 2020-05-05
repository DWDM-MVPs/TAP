package tap.ficha7;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Pessoa implements Serializable {
    //Variáveis de instância/atributos/características
    private String nome;
    private String nif;
    private int anoNasc;
    private String contacto;

    public abstract int horasPresenciais();

    public int getanoNasc() {
        return anoNasc;
    }

    public String getContacto() {
        return contacto;
    }

    public String getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public void setAnoNasc(int n) {
        this.anoNasc = n;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int idade()
    {
        Calendar cal=Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return  year-anoNasc;
    }
}
