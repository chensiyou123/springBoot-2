package com.csy.springbootweb.entity;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "t_order")
public class Order {

    @Id
    private String id;
    @Column(name = "order_no", length = 50)

    @NotNull
    @Size(min = 10, max = 20)
    private String no;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date date;

    @Min(100)
    @NotNull
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
