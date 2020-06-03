package tap.ficha8.produtos;

import java.io.*;
import java.util.ArrayList;

import static tap.ficha8.Main.fileProdutos;


public class Outro extends Produto implements Serializable
{
    public Outro() { }
    public Outro(int codigo, String nome, int stock, int reserva, double preco, String fornecedor)
    {
        setCodigo(codigo);
        setNome(nome);
        setStock(stock);
        setReserva(reserva);
        setPreco(preco);
        setFornecedor(fornecedor);
    }

    // Formato: <código>\t<nome>\t<tipo>\t<nºUnidades>\t< nºUnidadesMínimo>\t<preço>\t<fornecedor>
    public void GuardarOutro() throws IOException
    {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileProdutos)));
        writer.println(getCodigo() + "\t" + getNome() + "\t" + "outro" + "\t" + getStock() + "\t" + getReserva() + "\t" + getPreco() + "\t" + getFornecedor());
        writer.close();
    }
}