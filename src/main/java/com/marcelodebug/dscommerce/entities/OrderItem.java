package com.marcelodebug.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(Product product, Order order, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        id.setOrder(order);
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }
    public Product getProduct(){
        return id.getProduct();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }
    public Order getOrder(){
        return id.getOrder();
    }

    public OrderItemPK getId() {
        return id;
    }
}
