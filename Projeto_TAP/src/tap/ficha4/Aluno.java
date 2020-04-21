package tap.ficha4;

public class Aluno extends Pessoa {
    public Aluno(String nome, int nif, int anoNascimento, String contacto) {
        super.setNome(nome);
        super.setNif(nif);
        super.setAnoNascimento(anoNascimento);
        super.setContacto(contacto);
    }

    public Aluno() {}



    // NUMERO MECANOGRAFICO
    private int numeroMecanografico;

    public void setNumeroMecanografico(int numeroMecanografico){
        this.numeroMecanografico = numeroMecanografico;
    }
    public int getNumeroMecanografico(){
        return this.numeroMecanografico;
    }
    // NUMERO MECANOGRAFICO


    // UCs
    private UC[] ucs;

    public void setUcs(UC[] ucs){
        this.ucs = ucs;
    }
    public UC[] getUcs(){
        return this.ucs;
    }
    // UCs


    // CURSO
    private String curso;

    public void setCurso(String curso){
        this.curso = curso;
    }
    public String getCurso(){
        return this.curso;
    }
    // CURSO
}
