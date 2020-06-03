package tap.ficha8;

import tap.ficha8.encomendas.Encomenda;
import tap.ficha8.encomendas.EncomendaRecebida;
import tap.ficha8.fileManagers.FileManagerEncomenda;
import tap.ficha8.fileManagers.FileManagerEncomendaRecebida;
import tap.ficha8.fileManagers.FileManagerProduto;
import tap.ficha8.produtos.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static String delimiter = "\\s*\t\\s*";

    public static String fileProdutos = "data\\produtos.txt";
    public static String fileEncomendas = "data\\encomendas.txt";
    public static String fileEncomendasRecebidas = "data\\encomendas_recebidas.txt";



    public static Map<Integer, Produto> mapProdutos = new HashMap<>();
    static Map<Integer, EncomendaRecebida> mapEncomendasRecebidas = new HashMap<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
    {
        Program program = new Program();

        program.LerFicheiroInicial();
        program.GravarInformacaoEmFicheiroDeObjectos();
        program.LerInformacaoDeFicheiroDeObjetos();
        program.EfetuarVenda();
        program.GerarEncomenda();
        program.CarregarEncomenda();
        program.PrintProdutos();
    }
}