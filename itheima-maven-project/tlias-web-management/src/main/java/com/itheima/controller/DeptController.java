package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
//前端發送請求會請求到Controller中的方法,拿到數據並返回給前端
@Slf4j //生成日誌記錄
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //@RequestMapping("/depts")
    @GetMapping
    public Result list() {
        log.info("查詢ALL數據");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根據ID刪除部門" + id);
        //調用service刪除部門方法
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    //json對象封裝到dept對象要用@RequestBody
    public Result add(@RequestBody Dept dept) {
        log.info("新增部門", dept);
        deptService.add(dept);
        return Result.success();
    }

    //修改按鈕綁定Get方法,根據ID找到要更新的那行數據再返回給update的put請求用
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根據ID查詢" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部門" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
