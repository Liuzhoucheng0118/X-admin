package com.lzc.emp.mapper;

import com.lzc.emp.pojo.Dept;
import com.lzc.emp.pojo.Emp;
import com.lzc.emp.vo.EmpQuery;

import java.util.List;

public interface DeptMapper {

    public List<Dept> getDeptList();
}
