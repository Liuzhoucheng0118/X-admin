package com.lzc.emp.controller;

import com.lzc.common.vo.Result;
import com.lzc.emp.pojo.Dept;
import com.lzc.emp.vo.EmpQuery;
import com.lzc.emp.service.EmpService;
import com.lzc.emp.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {


    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    public String toEmp(){
        return "emp/empList";
    }

    @GetMapping("/emplist")
    @ResponseBody
    public Result<Object> getEmpList(EmpQuery empQuery) {
        List<Emp> empList = empService.getEmpList(empQuery);
        Long empCount = empService.getEmpCount(empQuery);
        return Result.success(empList,empCount);
    }

    @PostMapping("/addEmpToData")
    @ResponseBody
    public Result<Object> addEmp(Emp emp){
        empService.addEmp(emp);
        return Result.success("添加成功");
    }

    @GetMapping("/addEmp")
    public String toAddUi(Model model){
        List<Dept> deptList = empService.getDeptList();
        model.addAttribute("deptList",deptList);
        return "emp/addemp";
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public Result<Object> deleteByEmpIds(@PathVariable("ids") String ids){
        empService.deleteByEmpId(ids);
        return Result.success("成功删除");
    }

    @GetMapping("/{id}")
    public String getEmpById(@PathVariable ("id")String id, Model model){
        Emp empById = empService.getEmpById(id);
        List<Dept> deptList = empService.getDeptList();
        model.addAttribute("deptList",deptList);
        model.addAttribute("emp",empById);
        return "emp/editemp";
    }

    @PutMapping("")
    @ResponseBody
    public Result<Object> toUpdataEmp(Emp emp){
        empService.updataEmp(emp);
        return Result.success("修改成功");
    }
}
