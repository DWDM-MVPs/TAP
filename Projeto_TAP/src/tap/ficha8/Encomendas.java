package tap.ficha8;

import tap.ficha8.produtos.Cosmetico;
import tap.ficha8.produtos.Medicamento;
import tap.ficha8.produtos.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static tap.ficha8.Main.*;

public class Encomendas
{
    // Formato: <código>\t<nome>\t<tipo>\t<nºUnidadesEncomendadas>\t<fornecedor>
    public void EfetuarEncomenda(Map<Integer, Produto> produtos) throws IOException
    {
        ArrayList<String> encomendas = new ArrayList<>();

        Medicamento med = new Medicamento();
        Cosmetico cos = new Cosmetico();

        String tipo;

        for (Produto p : produtos.values())
        {
            if (p.VerificarReserva())
            {
                if (p.getClass() == med.getClass())
                {
                    med = (Medicamento)p;

                    if (med.getPrecisaReceita())
                    {
                        tipo = "MedicamentoComReceita";
                    }
                    else
                    {
                        tipo = "MedicamentoSemReceita";
                    }
                }
                else if (p.getClass() == cos.getClass())
                {
                    tipo = "cosmetico";
                }
                else
                {
                    tipo = "outro";
                }

                encomendas.add(p.getCodigo() + "\t" + p.getNome() + "\t" + tipo + "\t" + (p.getReserva() * 10) + "\t" + p.getFornecedor());
            }
        }

        SaveEncomenda(encomendas);
    }

    public void SaveEncomenda(ArrayList<String> encomendas) throws IOException
    {
        new Codigo().ClearFile(fileEncomendas);

        for (String e : encomendas)
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileEncomendas)));
            writer.println(e);
            writer.close();
        }
    }
}
