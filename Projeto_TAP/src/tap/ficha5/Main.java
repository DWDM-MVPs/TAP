package tap.ficha5;

import tap.ficha1.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        BufferedReader f=new BufferedReader(new FileReader())
    }
    public void guardaPessoasTxt(String nf) throws IOException
    {
        FileWriter fich = new FileWriter(new File(nf));
        BufferedWriter f = new BufferedWriter(fich);
        for(Pessoa p : listagem)
        {
            f.write(p.getNome() + ";"+p.idade()+";"+p.getNif()+";"+p.getContacto());
            f.newLine();
        }
        f.close();
    }

}
