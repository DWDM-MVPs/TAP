package tap.ficha4;

public class Funcionarios extends Pessoa {
    public Funcionarios(String nome, int nif, int anoNascimento, String contacto) {
	super.setNome(nome);
	super.setNif(nif);
	super.setAnoNascimento(anoNascimento);
	super.setContacto(contacto);
    }




    // NUMERO FUNCIONARIO
    private int numeroFuncionario;

    public void setNumeroFuncionario(int numeroFuncionario){
        this.numeroFuncionario = numeroFuncionario;
    }
    public int getNumeroFuncionario(){
        return this.numeroFuncionario;
    }
    // NUMERO FUNCIONARIO


    // FUNCAO
    private String funcao;

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
    public String getFuncao(){
        return funcao;
    }
    // FUNCAO
}
