/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnt.controllers;

import com.vnt.pojo.Product;
import com.vnt.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService prodService;
    @GetMapping("/products")
    public String productView(Model model){
        model.addAttribute("product", new Product());
        return "products";
    }
    @PostMapping("/products")
    public String create(Model model, @ModelAttribute(value = "product") @Valid Product p, BindingResult rs){
        if(rs.hasErrors())
            return "products";
        this.prodService.addOrUpdate(p);
        return "redirect:/";
    }
    @GetMapping("/products/{productId}")
    public String productView(Model model, @PathVariable(value = "productId") int id){
        model.addAttribute("product", this.prodService.getProductById(id));
        return "products";
    }
}
