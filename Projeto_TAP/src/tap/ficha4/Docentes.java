package tap.ficha4;

public class Docentes extends Pessoa {
    public Docentes(String nome, int nif, int anoNascimento, String contacto) {
        super.setNome(nome);
        super.setNif(nif);
        super.setAnoNascimento(anoNascimento);
        super.setContacto(contacto);
    }



    // NUMERO DOCENTE
    public int numeroDocente;

    public void setNumeroDocente(int numeroDocente){
        this.numeroDocente = numeroDocente;
    }
    public int getNumeroDocente(){
        return this.numeroDocente;
    }
    // NUMERO DOCENTE


    // DEPARTAMENTO
    public String departamento;

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    public String getDepartamento(){
        return this.departamento;
    }
    // DEPARTAMENTO


    // CURSOS
    public String[] cursos;

    public void setCursos(String[] cursos){
        this.cursos = cursos;
    }
    public String[] getCursos(){
        return this.cursos;
    }
    // CURSOS


    // UCs
    public UCs ucs;

    public void setUcs(UCs ucs){
        this.ucs = ucs;
    }
    public UCs getUcs(){
        return this.ucs;
    }
    // UCs
}