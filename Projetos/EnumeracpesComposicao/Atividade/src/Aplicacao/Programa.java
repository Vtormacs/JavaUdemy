package Aplicacao;

import Entidades.Cliente;
import Entidades.ItemPedido;
import Entidades.Pedido;
import Entidades.Produto;
import Entidades.enums.StatusPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        Produto produto = new Produto("TV", 1000.00);//Criei um produto
//        System.out.println(produto);//Imprimi o produto
//        ItemPedido ip1 = new ItemPedido(2, 1000.00, produto);//Criei um item que tem no pedido que nela vai ter associação ao produto
//        System.out.println(ip1.getPreco());//Imprimi o preco do produto
//        System.out.println(ip1.getQuantidade());//Quantidade
//        System.out.println(ip1.getProduto().getNome());//Imprimi o nome do produto que esta associado a esse item pedidos e pode ter mais produtos
//        System.out.println(ip1.subTotal());// chamei a funcao que mutiplica o proco do produto com a quantidade desejada
//        System.out.println(ip1);
//        Cliente cliente = new Cliente("Vitor", "vitor@gmail.com", sdf.parse("08/08/2002"));
//        System.out.println(cliente);
        System.out.println("Digite os dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de aniversario (DD/MM/AAAA): ");
        Date dataAniversario = sdf.parse(sc.nextLine());

        Cliente cliente = new Cliente(nome, email, dataAniversario);

        System.out.println("Dados do pedido:");
        System.out.print("STATUS: ");
        StatusPedido status = StatusPedido.valueOf(sc.nextLine());

        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.print("Quantos itens o pedido vai ter? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consome a nova linha após nextInt()

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do item #" + (i+1));
            System.out.print("Nome: ");
            String nomeProduto = sc.nextLine();
            System.out.print("Preco: ");
            Double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine(); // Consome a nova linha após nextInt()

            Produto produto = new Produto(nomeProduto, preco);

            ItemPedido itemPedigo = new ItemPedido(quantidade, preco, produto);

            pedido.addItem(itemPedigo);
        }

        System.out.println();
        System.out.print(pedido);

        sc.close();
    }
}
