package tap.ficha8.encomendas;

import java.io.Serializable;

public class EncomendaRecebida extends Encomenda implements Serializable
{
    private double preco;

    public EncomendaRecebida() { }
    public EncomendaRecebida(int codigo, String nome, String tipo, int quantidade, double preco, String fornecedor)
    {
        setCodigo(codigo);
        setNome(nome);
        setTipo(tipo);
        setQuantidade(quantidade);
        setPreco(preco);
        setFornecedor(fornecedor);
    }



    // PREÇO
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
    public double getPreco()
    {
        return preco;
    }
    public double getPrecoIva()
    {
        return preco * 1.23;
    }
    // PREÇO
}