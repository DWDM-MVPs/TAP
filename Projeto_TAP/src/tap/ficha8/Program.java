package tap.ficha8;

import tap.ficha8.fileManagers.FileManagerEncomenda;
import tap.ficha8.fileManagers.FileManagerEncomendaRecebida;
import tap.ficha8.fileManagers.FileManagerProduto;

import java.io.IOException;
import java.util.Scanner;

public class Program extends Main
{
    void LerFicheiroInicial() throws IOException, InterruptedException
    {
        System.out.println("################################ LER FICHEIRO INICIAL > START");
        mapProdutos = new FileManagerProduto().RetirarProdutosDoConteudo();
        System.out.println("################################ LER FICHEIRO INICIAL > END");
    }

    void GravarInformacaoEmFicheiroDeObjectos() throws IOException
    {
        System.out.println("################################ GRAVAR INFORMAÇÃO EM FICHEIRO DE OBJETOS > START");
        new FileManagerProduto().GuardarProdutos(mapProdutos);
        System.out.println("################################ GRAVAR INFORMAÇÃO EM FICHEIRO DE OBJETOS > END");
    }

    void LerInformacaoDeFicheiroDeObjetos() throws IOException, ClassNotFoundException
    {
        System.out.println("################################ LER INFORMAÇÃO DE FICHEIRO DE OBJETOS > START");
        mapProdutos = new FileManagerProduto().LerProdutos();
        System.out.println("################################ LER INFORMAÇÃO DE FICHEIRO DE OBJETOS > END");
    }

    void EfetuarVenda() throws IOException
    {
        System.out.println("################################ EFETUAR VENDA > START");
        Scanner sc = new Scanner(System.in);
        System.out.println("Código do produto:");
        int codigoProduto = sc.nextInt();
        System.out.println("Quanidade de produtos a vender:");
        int quantidade = sc.nextInt();

        FileManagerProduto.InfoVenda result = new FileManagerProduto().VenderProduto(codigoProduto, quantidade);

        if (result.sucesso)
        {
            System.out.println("O produto foi vendido com sucesso!\nPreço de venda: " + result.preco + " | Stock restante: " + result.stock);
        }
        else
        {
            System.out.println("Ocorreu um erro ao fazer a venda...\nErro: " + result.erro);
        }
        System.in.read();
        System.out.println("################################ EFETUAR VENDA > END");
    }

    void GerarEncomenda() throws IOException {
        System.out.println("################################ GERAR ENCOMENDA > START");
        new Encomendas().EfetuarEncomenda(mapProdutos);
        System.out.println("################################ GERAR ENCOMENDA > END");
    }

    void CarregarEncomenda() throws IOException
    {
        System.out.println("################################ CARREGAR ENCOMENDA > START");
        new FileManagerEncomendaRecebida().GuardarEncomendaRecebida();
        System.out.println("################################ CARREGAR ENCOMENDA > END");
    }

    void PrintProdutos()
    {
        System.out.println("################################ PRINT PRODUTOS > START");
        mapProdutos.forEach((key, value) -> System.out.println("\nCódigo: " + value.getCodigo() + "\nNome: " + value.getNome() + "\nStock: " + value.getStock() + "\nReserva: " + value.getReserva() + "\nPreço: " + value.getPreco() + "\nFornecedor: " + value.getFornecedor() + "\n"));
        System.out.println("################################ PRINT PRODUTOS > END");
    }
}
