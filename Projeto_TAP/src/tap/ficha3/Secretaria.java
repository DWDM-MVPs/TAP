package tap.ficha3;

public class Secretaria extends Funcionario {

    public Secretaria(String Nome, String UltimoNome, int AnoNascimento) {
	super.setNome(Nome);
	super.setUltimoNome(UltimoNome);
	super.setAnoNascimento(AnoNascimento);
    }

    public double getBonus() {
	return getSalario() * 0.10;
    }
}
