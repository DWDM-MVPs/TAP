package tap.ficha3;

public class IT extends Funcionario {

    public IT(String Nome, String UltimoNome, int AnoNascimento) {
	super.setNome(Nome);
	super.setUltimoNome(UltimoNome);
	super.setAnoNascimento(AnoNascimento);
    }

    public double getBonus() {
	return getSalario() * 0.15;
    }
}
