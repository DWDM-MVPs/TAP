package tap.ficha7;

import java.io.*;
import java.util.ArrayList;

public class Save {
    public void guardarPessoa(Object pessoa) throws Exception {
        FileOutputStream f;

        if (pessoa instanceof Aluno)
        {
            f = new FileOutputStream(new File("alunos.txt"));
        }
        else if (pessoa instanceof Docente)
        {
            f = new FileOutputStream(new File("docentes.txt"));
        }
        else if (pessoa instanceof Funcionario)
        {
            f = new FileOutputStream(new File("funcionarios.txt"));
        }
        else
        {
            throw new Exception("Wrong type");
        }

        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(pessoa);

        o.close();
        f.close();
    }

    private String fAlunos = "alunos.txt";
    private String fDocentes = "docentes.txt";
    private String fFuncionarios = "funcionarios.txt";

    public ArrayList<Aluno> lerAlunos() throws IOException, ClassNotFoundException
    {
        FileInputStream fi = new FileInputStream(new File(fAlunos));

        ArrayList<Aluno> listAlunos = new ArrayList<>();
        boolean cont = true;
        while (cont) {
            try (ObjectInputStream input = new ObjectInputStream(fi)) {
                Object aluno = input.readObject();
                if (aluno != null) {
                    listAlunos.add((Aluno)aluno);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = false;
            }
        }

        fi.close();

        return listAlunos;
    }

    public ArrayList<Docente> lerDocentes() throws IOException, ClassNotFoundException
    {
        FileInputStream fi = new FileInputStream(new File(fDocentes));

        ArrayList<Docente> listDocentes = new ArrayList<>();
        boolean cont = true;
        while (cont) {
            try (ObjectInputStream input = new ObjectInputStream(fi)) {
                Object docente = input.readObject();
                if (docente != null) {
                    listDocentes.add((Docente)docente);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = false;
            }
        }

        fi.close();

        return listDocentes;
    }

    public ArrayList<Funcionario> lerFuncionarios() throws IOException, ClassNotFoundException
    {
        FileInputStream fi = new FileInputStream(new File(fFuncionarios));

        ArrayList<Funcionario> listFuncionarios = new ArrayList<>();
        boolean cont = true;
        while (cont) {
            try (ObjectInputStream input = new ObjectInputStream(fi)) {
                Object funcionario = input.readObject();
                if (funcionario != null) {
                    listFuncionarios.add((Funcionario) funcionario);
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = false;
            }
        }

        fi.close();

        return listFuncionarios;
    }
}
