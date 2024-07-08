/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vnt.repository.impl;

import com.vnt.hibernatedemo.HibernateUtils;
import com.vnt.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class CategoryReposityImpl {
    public List<Category> getCates(){
        try(Session s = HibernateUtils.getFactory().openSession()){
            Query q = s.createQuery("From Category");
            return q.getResultList();
        }
        
    }
}
