package com.csy.springbootweb.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    @Column(name = "order_no", length = 50)
    private String no;
     @Temporal(TemporalType.DATE)
     @Column(name = "order_date")
    private Date date;
     @Column(name = "quantity")
    private Integer quantity;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
