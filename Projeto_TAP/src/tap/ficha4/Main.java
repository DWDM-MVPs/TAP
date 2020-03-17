package tap.ficha4;

public class Main {
	public static void main(String[] args) {
		Pessoa[] pessoa = new Pessoa[1];
		pessoa[0].setNome("Pessoa 0");
		pessoa[0].setNif(123456789);
		pessoa[0].setAnoNascimento(2001);
		pessoa[0].setContacto("pessoa0@purediamond.tk");



		Docentes[] docente = new Docentes[1];
		docente[0].setNome("Docente 0");
		docente[0].setNif(123456789);
		docente[0].setAnoNascimento(2001);
		docente[0].setContacto("docente0@purediamond.tk");
		docente[0].setDepartamento("Informatica");
		docente[0].setNumeroDocente(19000);
	}
}
