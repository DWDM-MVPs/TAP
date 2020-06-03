package tap.ficha8.fileManagers;

import tap.ficha8.Codigo;
import tap.ficha8.Encomendas;
import tap.ficha8.produtos.Cosmetico;
import tap.ficha8.produtos.Medicamento;
import tap.ficha8.produtos.Outro;
import tap.ficha8.produtos.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tap.ficha8.Main.*;

public class FileManagerProduto
{
    // LOOP EACH LINE IN THE ARRAY AND EXTRACT DATA
    public Map<Integer, Produto> RetirarProdutosDoConteudo() throws IOException
    {
        // Formato: <código>\t<nome>\t<tipo>\t<nºUnidades>\t<nºUnidadesMínimo>\t<preço>\t<fornecedor>
        Map<Integer, Produto> map = new HashMap<>();

        int codigo;
        String nome;
        String tipo;
        int stock;
        int reserva;
        double preco;
        String fornecedor;

        String line;
        BufferedReader f = new BufferedReader(new FileReader(fileProdutos));
        while ((line = f.readLine()) != null)
        {
            String[] splitLine = line.split("\t");

            try
            {
                codigo = Integer.parseInt(splitLine[0]);
                nome = splitLine[1];
                tipo = splitLine[2];
                stock = Integer.parseInt(splitLine[3]);
                reserva = Integer.parseInt(splitLine[4]);
                preco = Double.parseDouble(splitLine[5]);
                fornecedor = splitLine[6];

                Produto p;

                switch (tipo)
                {
                    case "MedicamentoSemReceita":
                        p = new Medicamento(codigo, nome, false, stock, reserva, preco, fornecedor);
                        break;
                    case "MedicamentoComReceita":
                        p = new Medicamento(codigo, nome, true, stock, reserva, preco, fornecedor);
                        break;
                    case "cosmetico":
                        p = new Cosmetico(codigo, nome, stock, reserva, preco, fornecedor);
                        break;
                    default:
                        p = new Outro(codigo, nome, stock, reserva, preco, fornecedor);
                        break;
                }

                map.put(codigo, p);
            }
            catch (Exception ignored) { }
        }

        return map;
    }

    public void GuardarTodosProdutos(ArrayList<Produto> produtos) throws IOException {
        // Clear file contents, otherwise there would be repeated products
        new Codigo().ClearFile(fileProdutos);

        // Define product classes
        Medicamento med = new Medicamento();
        Cosmetico cos = new Cosmetico();
        Outro ou = new Outro();

        // Loop each product and write it to the file
        for (Produto p : produtos)
        {
            if (p.getClass() == med.getClass())
            {
                ((Medicamento)p).GuardarMedicamento();
            }
            else if (p.getClass() == cos.getClass())
            {
                ((Cosmetico)p).GuardarCosmetico();
            }
            else if (p.getClass() == ou.getClass())
            {
                ((Outro)p).GuardarOutro();
            }
        }
    }

    public InfoVenda VenderProduto(int codigoProduto, int quantidade)
    {
        InfoVenda iv = new InfoVenda();

        if (quantidade <= 0)
        {
            iv.sucesso = false;
            iv.erro = "A quantidade de produtos inserida para venda é menor que 1";
        }
        else
        {
            if (mapProdutos.containsKey(codigoProduto))
            {
                Produto p = mapProdutos.get(codigoProduto);

                if (p.getStock() - quantidade >= 0)
                {
                    iv.sucesso = true;
                    iv.preco = (p.getPreco() * quantidade) * 1.23;
                    iv.stock = p.getStock() - quantidade;

                    p.setStock(iv.stock);

                    mapProdutos.put(codigoProduto, p);
                }
                else
                {
                    iv.sucesso = false;
                    iv.erro = "Stock insuficiente";
                }
            }
            else
            {
                iv.sucesso = false;
                iv.erro = "Produto com código '" + codigoProduto + "' não existe";
            }
        }

        return iv;
    }

    public class InfoVenda
    {
        public boolean sucesso;
        public String erro;
        public double preco;
        public int stock;
    }

    public Map<Integer, Produto> LerProdutos() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(new File("data\\produtos.bin"));
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Map<Integer, Produto>)ois.readObject();
    }

    public void GuardarProdutos(Map<Integer, Produto> produtos) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(new File("data\\produtos.bin"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(produtos); // ez
    }
}