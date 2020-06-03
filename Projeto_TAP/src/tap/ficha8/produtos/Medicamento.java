package tap.ficha8.produtos;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import static tap.ficha8.Main.fileProdutos;


public class Medicamento extends Produto implements Serializable
{
    private Boolean precisaReceita;
    private String tipo = "Medicamento";

    public Medicamento() { }
    public Medicamento(int codigo, String nome, Boolean precisaReceita, int stock, int reserva, double preco, String fornecedor)
    {
        setCodigo(codigo);
        setNome(nome);
        setPrecisaReceita(precisaReceita);
        setStock(stock);
        setReserva(reserva);
        setPreco(preco);
        setFornecedor(fornecedor);
    }

    // Formato: <código>\t<nome>\t<tipo>\t<nºUnidades>\t< nºUnidadesMínimo>\t<preço>\t<fornecedor>
    public void GuardarMedicamento() throws IOException
    {
        String receita;

        if (getPrecisaReceita())
        {
            receita = "MedicamentoComReceita";
        }
        else
        {
            receita = "MedicamentoSemReceita";
        }

        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileProdutos)));
        writer.println(getCodigo() + "\t" + getNome() + "\t" +  receita + "\t" + getStock() + "\t" + getReserva() + "\t" + getPreco() + "\t" + getFornecedor());
        writer.close();
    }





    // PRECISA RECEITA
    public void setPrecisaReceita(Boolean precisaReceita)
    {
        this.precisaReceita = precisaReceita;
    }
    public Boolean getPrecisaReceita()
    {
        return precisaReceita;
    }
    // PRECISA RECEITA
}
