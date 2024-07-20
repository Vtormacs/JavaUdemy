package Entidades;

import Entidades.enums.StatusPedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date data;
    private StatusPedido status;
    private List<ItemPedido> itens = new ArrayList<>();
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Date data, StatusPedido status, Cliente cliente) {
        this.data = data;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }
    
    public Double total(){
        double soma = 0.0;
        for(ItemPedido ip : itens){
            soma += ip.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do Pedido: ");
        sb.append(sdf.format(data) + "\n");
        sb.append("Status do Pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do Pedidos:\n");
        for(ItemPedido item : itens){
            sb.append(item + "\n");
        }
        sb.append("Preco Total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
    
}
