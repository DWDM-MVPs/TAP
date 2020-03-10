package tap.ficha3;

public class Main {
    public static void main(String[] args) {
	Funcionario[] funcionarios = new Funcionario[3];
	double mediaBonus = 0, somaBonus = 0, somaSalarios = 0, mediaSalarios = 0;
	funcionarios[0] = new Direcao("Diretor", "IPV", 1967);
	funcionarios[1] = new Secretaria("Secretária", "Fátima", 1942);
	funcionarios[2] = new IT("Tech", "Crazy", 200);
	funcionarios[0].setSalario(10000);
	funcionarios[1].setSalario(800);
	funcionarios[2].setSalario(2500);
	for (int i = 0; i < funcionarios.length; i++) {
	    System.out.printf("Dados do %s:\nNome: %s\nApelido: %s\nData de Nascimento: %s\nSalário: %.2f\nBónus: %.2f\n\n", funcionarios[i].getNomeCompleto(), funcionarios[i].getNome(), funcionarios[i].getUltimoNome(), funcionarios[i].getAnoNascimento(), funcionarios[i].getSalario(), funcionarios[i].getBonus());
	    somaSalarios += funcionarios[i].getSalario();
	    somaBonus += funcionarios[i].getBonus();
	}
	mediaSalarios = somaSalarios / funcionarios.length;
	mediaBonus = somaBonus / funcionarios.length;
	System.out.println();
	System.out.printf("A média de todos os salários é %.2f€ e a média de todos os bónus é %.2f.", mediaSalarios, mediaBonus);
    }
}
