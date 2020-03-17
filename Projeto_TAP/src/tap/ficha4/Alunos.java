package tap.ficha4;

public class Alunos extends Pessoa {
    public Alunos(String nome, int nif, int anoNascimento, String contacto) {
        super.setNome(nome);
        super.setNif(nif);
        super.setAnoNascimento(anoNascimento);
        super.setContacto(contacto);
    }



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
    public UCs ucs;

    public void setUcs(UCs ucs){
        this.ucs = ucs;
    }
    public UCs getUcs(){
        return this.ucs;
    }
    // UCs


    // CURSOS
    public String[] cursos;

    public void setCursos(String[] cursos){
        this.cursos = cursos;
    }
    public String[] getCursos(){
        return this.cursos;
    }
    // CURSOS
}
