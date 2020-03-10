package tap.ficha3;

public abstract class Funcionario {
    private double salario;
    private String nome;
    private String ultimoNome;
    private int anoNascimento;

    public abstract double getBonus();

    public void setSalario(double salario) {
	this.salario = salario;
    }

    public void setNome(String Name) {
	this.nome = Name;
    }

    public void setUltimoNome(String ultimoNome) {
	this.ultimoNome = ultimoNome;
    }

    public void setAnoNascimento(int AnoNascimento) {
	this.anoNascimento = AnoNascimento;
    }


    public String getNome() {
	return nome;
    }

    public String getUltimoNome() {
	return ultimoNome;
    }

    public int getAnoNascimento() {
	return anoNascimento;
    }

    public double getSalario() {
	return salario;
    }

    public String getNomeCompleto() {
	return this.nome + " " + this.ultimoNome;
    }

    public String QualTipoFuncionario() {
	Class c = this.getClass();
	return c.getName();
    }
}
