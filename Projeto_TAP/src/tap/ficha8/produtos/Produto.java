package tap.ficha8.produtos;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Produto implements Serializable
{
    private int codigo;
    private String nome;
    private int stock;
    private int reserva;
    private double preco;
    private String fornecedor;

    public Boolean VerificarReserva()
    {
        return this.getStock() < this.getReserva();
    }





    // CÓDIGO
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public int getCodigo()
    {
        return codigo;
    }
    // CÓDIGO


    // NOME
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getNome()
    {
        return nome;
    }
    // NOME


    // STOCK
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    public int getStock()
    {
        return stock;
    }
    // STOCK


    // RESERVA
    public void setReserva(int reserva)
    {
        this.reserva = reserva;
    }
    public int getReserva()
    {
        return reserva;
    }
    // RESERVA


    // PREÇO
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
    public double getPreco()
    {
        return preco;
    }
    // PREÇO


    // FORNECEDOR
    public void setFornecedor(String fornecedor)
    {
        this.fornecedor = fornecedor;
    }
    public String getFornecedor()
    {
        return fornecedor;
    }
    // FORNECEDOR
}
