package com.csy.springbootweb.repository;

import com.csy.springbootweb.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository  extends JpaRepository<Order, String> {
    /**
     * like查询
     *
     * @param no
     * @return
     */
    List<Order> findAllByNoLike(String no);

    /**
     * between查询
     *
     * @param startDate
     * @param endDate
     * @return
     */
    List<Order> findAllByDateBetween(Date startDate, Date endDate);

    /**
     * 小于查询
     *
     * @param quantity
     * @return
     */
    List<Order> findAllByQuantityLessThan(int quantity);
}
