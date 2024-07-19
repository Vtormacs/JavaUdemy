package javaapplication5;

import entidades.Pedidos;
import entidades.enums.OrderStatus;
import java.util.Date;

public class JavaApplication5 {

    public static void main(String[] args) {
        Pedidos pedido = new Pedidos(180, new Date(), OrderStatus.AGUARDANDO_PAGAMENTO);
        System.out.println(pedido);
        
        OrderStatus os1 = OrderStatus.PROCESSANDO;
        OrderStatus os2 = OrderStatus.valueOf("PROCESSANDO");
        System.out.println(os1);
        System.out.println(os2);
    }
   
}
