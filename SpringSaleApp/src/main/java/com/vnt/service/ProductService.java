/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnt.service;

import com.vnt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params);
    void addOrUpdate(Product p);
    Product getProductById(int id);
    void deleteProduct(int id);
}
