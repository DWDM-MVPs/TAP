package tap.ficha8.encomendas;

public class Encomenda {
    private int codigo;
    private String nome;
    private String tipo;
    private int quantidade;
    private String fornecedor;

    // Formato: <código>\t<nome>\t<tipo>\t<nºUnidadesEncomendadas>\t<fornecedor>
    public Encomenda() { }
    public Encomenda(int codigo, String nome, String tipo, int quantidade, String fornecedor)
    {
        setCodigo(codigo);
        setNome(nome);
        setTipo(tipo);
        setQuantidade(quantidade);
        setFornecedor(fornecedor);
    }


    // CODIGO
    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    public int getCodigo()
    {
        return codigo;
    }
    // CODIGO


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


    // TIPO
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public String getTipo()
    {
        return tipo;
    }
    // TIPO


    // QUANTIDADE
    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
    public int getQuantidade()
    {
        return quantidade;
    }
    // QUANTIDADE


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
