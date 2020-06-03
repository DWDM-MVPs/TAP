package tap.ficha8;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Codigo
{
    public void ClearFile(String filePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("");
        writer.close();
    }
}
