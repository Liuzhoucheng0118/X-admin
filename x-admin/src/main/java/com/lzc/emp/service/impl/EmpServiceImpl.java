package com.lzc.emp.service.impl;

import com.lzc.emp.mapper.DeptMapper;
import com.lzc.emp.mapper.EmpMapper;
import com.lzc.emp.pojo.Dept;
import com.lzc.emp.service.EmpService;
import com.lzc.emp.vo.EmpQuery;
import com.lzc.emp.pojo.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Emp> getEmpList(EmpQuery empQuery) {
        return empMapper.getEmpList(empQuery);
    }

    @Override
    public Long getEmpCount(EmpQuery empQuery) {
        return empMapper.getEmpCount(empQuery);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public List<Dept> getDeptList(){
        return deptMapper.getDeptList();
    }

    @Override
    public void deleteByEmpId(String ids){
        empMapper.deleteByEmpId(ids);
    }

    @Override
    public Emp getEmpById(String id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updataEmp(Emp emp) {
        empMapper.toUpdataEmp(emp);
    }
}
