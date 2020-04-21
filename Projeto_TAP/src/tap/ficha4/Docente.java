package tap.ficha4;

public class Docente extends Pessoa {
    public Docente(String nome, int nif, int anoNascimento, String contacto) {
        super.setNome(nome);
        super.setNif(nif);
        super.setAnoNascimento(anoNascimento);
        super.setContacto(contacto);
    }

    public Docente() {}



    // NUMERO DOCENTE
    private int numeroDocente;

    public void setNumeroDocente(int numeroDocente){
        this.numeroDocente = numeroDocente;
    }
    public int getNumeroDocente(){
        return this.numeroDocente;
    }
    // NUMERO DOCENTE


    // DEPARTAMENTO
    private String departamento;

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return this.departamento;
    }
    // DEPARTAMENTO


    // CURSOS
    private String[] cursos;

    public void setCursos(String[] cursos){
        this.cursos = cursos;
    }
    public String[] getCursos(){
        return this.cursos;
    }
    // CURSOS


    // UCs
    private UC[] ucs;

    public void setUcs(UC[] ucs){
        this.ucs = ucs;
    }
    public UC[] getUcs(){
        return this.ucs;
    }
    // UCs
}