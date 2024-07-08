/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vnt.hibernatedemo;

import com.vnt.pojo.Cart;
import com.vnt.repository.impl.CategoryReposityImpl;
import com.vnt.repository.impl.ProductRepositoryImpl;
import com.vnt.repository.impl.ReceiptRepositoryImpl;
import com.vnt.repository.impl.StatsRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
          StatsRepositoryImpl s = new StatsRepositoryImpl();
          s.statsRevenueByPeroid(2020, "QUARTER").forEach(o -> {
              System.out.printf("%s: %d\n", o[0], o[1]);
          });
//        List<Cart> carts = new ArrayList<>();
//        carts.add(new Cart(1,"A",2, 100l) );
//        ReceiptRepositoryImpl r = new ReceiptRepositoryImpl();
//        r.addReceipt(carts);
//        CategoryReposityImpl s = new CategoryReposityImpl();
//        s.getCates().forEach(c-> System.out.println(c.getName()));
        //Map<String, String> params = new HashMap<>();
        //params.put("q","iPhone");
        //params.put("fromPrice", "28000000");
//        params.put("page", "2");
//        ProductRepositoryImpl s = new ProductRepositoryImpl();
//        s.getProducts(params).forEach(p-> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));
    }
}
