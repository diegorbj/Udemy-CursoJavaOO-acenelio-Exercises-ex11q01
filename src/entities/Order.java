package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment = new Date();
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(){
    }

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public Double total(){
        Double sum = 0.0;
        for (OrderItem oi : orderItems){
            sum += oi.subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMARY:\n");
        sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
        sb.append("Order status: " + getStatus() + "\n");
        sb.append("Client: " + getClient() + "\n");
        sb.append("Order items:\n");
        for (OrderItem oi : orderItems){
            sb.append(oi + "\n");
        }
        sb.append("Total price: $" + total() + "\n");

        return sb.toString();
    }
}
