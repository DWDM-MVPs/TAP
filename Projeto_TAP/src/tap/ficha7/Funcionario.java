package tap.ficha7;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {
    private int numFunc;
    private String funcao;
    public Funcionario(String nome,String contac,int ano, String nif, String fun,int num)
    {
        setAnoNasc(ano);
        setContacto(contac);
        setNome(nome);
        setNif(nif);
        this.funcao=fun;
        this.numFunc=num;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getNumFunc() {
        return numFunc;
    }

    public void setNumFunc(int numFunc) {
        this.numFunc = numFunc;
    }
     public int horasPresenciais()
     {
         return 35;
     }



    @Override
    public String toString()
    {
        return "Nome: " + this.getNome() +
                "\nNif: " + this.getNif() +
                "\nAno de Nascimento: " +this.getanoNasc() +
                "\nContacto: " + this.getContacto() +
                "\nNúmero de Funcionário: " + numFunc +
                "\nFunção: " + funcao +
                "\nHoras presenciais: " + horasPresenciais();
    }
}
