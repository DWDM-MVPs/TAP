package tap.ficha8.fileManagers;

import tap.ficha8.produtos.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileManager
{
    // READ EACH LINE OF THE FILE AND PUT IT IN AN ARRAY
    public static ArrayList<String> LerFicheiro(String filePath) throws IOException
    {
        FileReader fr = new FileReader(new File(filePath));
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> fileContent = new ArrayList<>();
        String readLine;

        while ((readLine = br.readLine()) != null)
        {
            fileContent.add(readLine);
        }

        return fileContent;
    }
}
