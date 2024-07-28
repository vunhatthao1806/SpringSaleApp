/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vnt.repository;

import com.vnt.pojo.User;

/**
 *
 * @author Admin
 */
public interface UserRepository {
    User getUserByUsername(String username);
}
