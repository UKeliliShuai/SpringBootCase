package com.wangshuai.springboot.controller;

import com.wangshuai.springboot.dao.DepartmentDao;
import com.wangshuai.springboot.dao.EmployeeDao;
import com.wangshuai.springboot.entities.Department;
import com.wangshuai.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    /**
     * @Autowired
     * EmployeeDao employeeDao;
     * 其中@Autowired不适用于局部变量
     * @return 查询所有员工列表页面
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }
    /**
     * 转到添加页面
     */
    @GetMapping("/emp")
    public String addPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }

    /**
     * 1.问题是：重定向默认是使用Get请求方式吗？
     * 如何令重定向为POST？
     *
     * 2.知识点：SpringMVC自动将请求参数（html）和入参对象（employee）的属性一一绑定
     *          要求请求参数名<name="请求参数名">与javaBean入参的属性名一致
     * @return 来到员工列表页面
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的员工信息"+employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    /**
     * 批量URL实现修改请求
     * 知识点：获取路径参数@PathParam("id")
     * 知识点：重用add页面"1.请求路径都是emp  2.但是请求方式分别是post和put"
     * @return 重用添加页面为修改页面
     */
    @GetMapping("/emp/{id}")
    public String editPage(@PathVariable("id") Integer id,
                           Model model){
        /**
         * 目的是：来到编辑页面，并将员工信息查出放在emp和depts中
         * 通过：return "emps/add";
         * 其中：depts已经自动回显（添加页面的配置）
         * 接下来：需要在add.html中会先emp的值
         */
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";
    }

    @PutMapping("/emp")
    public String editEmp(Employee employee){
        System.out.println("修改的员工数据"+employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
