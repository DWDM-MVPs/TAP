package tap.ficha8.fileManagers;

import tap.ficha8.Codigo;
import tap.ficha8.Encomendas;
import tap.ficha8.encomendas.EncomendaRecebida;
import tap.ficha8.produtos.Cosmetico;
import tap.ficha8.produtos.Medicamento;
import tap.ficha8.produtos.Outro;
import tap.ficha8.produtos.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tap.ficha8.Main.*;
import static tap.ficha8.fileManagers.FileManager.LerFicheiro;

public class FileManagerEncomendaRecebida
{
    // LOOP EACH LINE IN THE ARRAY AND EXTRACT DATA
    public Map<Integer, EncomendaRecebida> RetirarEncomendaRecebidaDoConteudo() throws IOException
    {
        ArrayList<String> fileContent = LerFicheiro(fileEncomendasRecebidas);

        // Formato: <código>\t<nome>\t<tipo>\t<nºUnidadesRecebidas>\t<preço>\t<fornecedor>
        Map<Integer, EncomendaRecebida> map = new HashMap<>();

        int codigo;
        String nome;
        String tipo;
        int quantidade;
        double preco;
        String fornecedor;

        String line;
        BufferedReader f = new BufferedReader(new FileReader(fileEncomendasRecebidas));
        while ((line = f.readLine()) != null)
        {
            String[] splitLine = line.split("\t");

            try
            {
                codigo = Integer.parseInt(splitLine[0]);
                nome = splitLine[1];
                tipo = splitLine[2];
                quantidade = Integer.parseInt(splitLine[3]);
                preco = Double.parseDouble(splitLine[4]);
                fornecedor = splitLine[5];



                EncomendaRecebida e = new EncomendaRecebida(codigo, nome, tipo, quantidade, preco, fornecedor);

                map.put(codigo, e);
            }
            catch (Exception ignored) { }


        }

        return map;
    }

    public void GuardarEncomendaRecebida() throws IOException
    {
        Map<Integer, EncomendaRecebida> map = new HashMap<>();

        FileManagerEncomendaRecebida fmr = new FileManagerEncomendaRecebida();
        map = fmr.RetirarEncomendaRecebidaDoConteudo();

        for (Map.Entry<Integer, EncomendaRecebida> entry : map.entrySet())
        {
            EncomendaRecebida e = entry.getValue();

            if (mapProdutos.containsKey(entry.getKey()))
            {
                Produto p = mapProdutos.get(entry.getKey());

                p.setStock(p.getStock() + e.getQuantidade());

                mapProdutos.put(entry.getKey(), p);
            }
            else
            {
                Produto p;

                if (e.getTipo().equals("MedicamentoComReceita"))
                {
                    p = new Medicamento(e.getCodigo(), e.getNome(), true, e.getQuantidade(), 5, (e.getPreco() / e.getQuantidade()), e.getFornecedor());
                }
                else if (e.getTipo().equals("MedicamentoSemReceita"))
                {
                    p = new Medicamento(e.getCodigo(), e.getNome(), false, e.getQuantidade(), 5, (e.getPreco() / e.getQuantidade()), e.getFornecedor());
                }
                else if (e.getTipo().equals("cosmetico"))
                {
                    p = new Cosmetico(e.getCodigo(), e.getNome(), e.getQuantidade(), 5, (e.getPreco() / e.getQuantidade()), e.getFornecedor());
                }
                else
                {
                    p = new Outro(e.getCodigo(), e.getNome(), e.getQuantidade(), 5, (e.getPreco() / e.getQuantidade()), e.getFornecedor());
                }

                mapProdutos.put(entry.getKey(), p);
            }
        }

        new Codigo().ClearFile(fileEncomendasRecebidas);
    }
}
