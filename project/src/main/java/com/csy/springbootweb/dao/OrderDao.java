package com.csy.springbootweb.dao;

import com.csy.springbootweb.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        String sql = " select * from t_order ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, new Object[] {});
        while (rows.next()) {
            Order order = new Order();
            list.add(order);
            order.setId(rows.getString("order_id"));
            order.setNo(rows.getString("order_no"));
            order.setDate(rows.getDate("order_date")); ;
           // order.setQuantity(rows.getInt("quantity"));
        }
        return list;
    }

    public Order get(String id) {
        Order order = null;
        String sql = " select * from t_order where order_id = ? ";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, new Object[] { id });
        while (rows.next()) {
            order = new Order();
            order.setId(rows.getString("order_id"));
            order.setNo(rows.getString("order_no"));
            order.setDate(rows.getDate("order_date")); ;
            //order.setQuantity(rows.getInt("quantity"));
        }
        return order;
    }

    public String insert(Order order) {
        String id = UUID.randomUUID().toString();
        String sql = " insert into t_order ( order_id , order_no , order_date  ) values (?,?,?) ";
        jdbcTemplate.update(sql, new Object[] { id, order.getNo(), new java.sql.Date(order.getDate().getTime())});
        return id;
    }

    public void update(Order order) {
        String sql = " update t_order set order_no = ? , order_date = ?  where order_id = ? ";
        jdbcTemplate.update(sql,
                new Object[] { order.getNo(), new java.sql.Date(order.getDate().getTime()), order.getId() });
    }

    public void delete(String id) {
        String sql = " delete from t_order where order_id = ? ";
        jdbcTemplate.update(sql, new Object[] { id });
    }
}
