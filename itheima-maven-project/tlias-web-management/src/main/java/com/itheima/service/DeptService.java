package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    //查詢所有數據
    List<Dept> list();

    //刪除部門
    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    //修改部門先要查詢ID
    Dept getById(Integer id);

}
