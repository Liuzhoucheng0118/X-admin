package com.lzc.emp.service;

import com.lzc.emp.pojo.Dept;
import com.lzc.emp.vo.EmpQuery;
import com.lzc.emp.pojo.Emp;

import java.util.List;

public interface EmpService {

    public List<Emp> getEmpList(EmpQuery empQuery);

    public Long getEmpCount(EmpQuery empQuery);

    public void addEmp(Emp emp);

    public List<Dept> getDeptList();

    public void deleteByEmpId(String ids);

    public Emp getEmpById(String id);

    public void updataEmp(Emp emp);
}
