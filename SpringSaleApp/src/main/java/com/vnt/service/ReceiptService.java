/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnt.service;

import com.vnt.pojo.Cart;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ReceiptService {
    void addReceipt(List<Cart> carts);
}
