package tap.ficha6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Aluno a1 = new Aluno("Lol", "12312", 3123, "2131231", "12313", 31231);

        Save save = new Save();
        save.guardarPessoa(a1);




        Aluno a2 = save.lerAlunos().get(0);

        System.out.println(a2.toString());
    }
}
