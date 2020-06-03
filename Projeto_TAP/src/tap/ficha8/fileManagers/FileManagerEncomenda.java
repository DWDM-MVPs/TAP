package tap.ficha8.fileManagers;

import tap.ficha8.encomendas.Encomenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tap.ficha8.Main.*;

public class FileManagerEncomenda extends FileManager
{
    // LOOP EACH LINE IN THE ARRAY AND EXTRACT DATA
    public Map<Integer, Encomenda> RetirarEncomendaDoConteudo() throws IOException
    {
        ArrayList<String> fileContent = LerFicheiro(fileEncomendas);

        // Formato: <código>\t<nome>\t<tipo>\t<nºUnidadesEncomendadas>\t<fornecedor>
        Map<Integer, Encomenda> map = new HashMap<>();

        int codigo;
        String nome;
        String tipo;
        int quantidade;
        String fornecedor;

        String line;
        BufferedReader f = new BufferedReader(new FileReader(fileEncomendas));
        while ((line = f.readLine()) != null)
        {
            String[] splitLine = line.split("\t");

            try
            {
                codigo = Integer.parseInt(splitLine[0]);
                nome = splitLine[1];
                tipo = splitLine[2];
                quantidade = Integer.parseInt(splitLine[3]);
                fornecedor = splitLine[4];


                Encomenda e = new Encomenda(codigo, nome, tipo, quantidade, fornecedor);

                map.put(codigo, e);
            }
            catch (Exception ignored) { }
        }

        return map;
    }
}
