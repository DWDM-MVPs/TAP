package tap.ficha4;

public class UC {
    public UC(String nome, int notaFinal, Boolean finalizada){
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.finalizada = finalizada;
    }

    public UC() {}



    // NOME
    private String nome;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    // NOME


    // NOTA FINAL
    private int notaFinal;

    public void setNotaFinal(int notaFinal){
        this.notaFinal = notaFinal;
    }
    public int getNotaFinal(){
        return this.notaFinal;
    }
    // NOTA FINAL


    // FINALIZADA
    private Boolean finalizada;

    public void setFinalizada(Boolean finalizada){
        this.finalizada= finalizada;
    }
    public Boolean getFinalizada(){
        return this.finalizada;
    }
    // FINALIZADA
}
