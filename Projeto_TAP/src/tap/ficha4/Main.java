package tap.ficha4;

public class Main {
	public static void main(String[] args) {
		var docente = new Docentes("nome", 123456789, 2001, "987654321");

		docente.setNome("Docente 0");
		docente.setNif(123456789);
		docente.setAnoNascimento(2001);
		docente.setContacto("docente0@purediamond.tk");
		docente.setDepartamento("Informatica");
		docente.setCursos(new String[] { "Curso 1", "Curso 2" });
		docente.setNumeroDocente(19000);




		String cursos = "";
		for (String curso : docente.getCursos()) {
			if (cursos == "")
			{
				cursos = curso;
			}
			else
			{
				cursos = cursos + ", " + curso;
			}
		}


		System.out.println("Nome: " + docente.getNome());
		System.out.println("NIF: " + docente.getNif());
		System.out.println("Ano de Nascimento: " + docente.getAnoNascimento() + " (" + docente.getIdade() + " anos)");
		System.out.println("Contacto: " + docente.getContacto());
		System.out.println("Departamento: " + docente.getDepartamento());
		System.out.println("Cursos: " + cursos);
		System.out.println("Número de Docente: " + docente.getNumeroDocente());
	}
}
