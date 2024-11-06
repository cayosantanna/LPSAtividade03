/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;

/**
 *
 * @author cayo
 */
public interface IDAO {

    public void save(Object obj);
    public void update(Object obj);
    public boolean delete(Object obj);
    public Object find(Object obj);
    public List<Object> findAll();

}
