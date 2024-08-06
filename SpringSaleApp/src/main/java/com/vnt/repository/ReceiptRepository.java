/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnt.repository;

import com.vnt.pojo.Cart;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReceiptRepository {
    public void addReceipt(List<Cart> carts);
}
