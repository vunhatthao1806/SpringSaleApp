/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnt.repository.impl;

import com.vnt.pojo.Cart;
import com.vnt.pojo.OrderDetail;
import com.vnt.pojo.SaleOrder;
import com.vnt.repository.ProductRepository;
import com.vnt.repository.ReceiptRepository;
import com.vnt.repository.UserRepository;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            Session s = this.factory.getObject().getCurrentSession();
                SaleOrder order = new SaleOrder();
                order.setUserId(userRepo.getUserByUsername("dhthanh"));
                order.setCreatedDate(new Date());
                s.save(order);
                
                for (Cart c:carts){
                    OrderDetail d = new OrderDetail();
                    d.setUnitPrice(c.getUnitPrice());
                    d.setQuantity(c.getQuantity());
                    d.setProductId(productRepo.getProductById(c.getId()));
                    d.setOrderId(order);
                    s.save(d);
                }
            }
        }
}
