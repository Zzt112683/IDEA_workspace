package com.neuedu.mapper;

import com.neuedu.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> listEmp();

    int saveEmp(@Param("emp") Emp emp);

    int deleteEmpById(int id);

    Emp getEmpById(int id);

    int updateEmp(@Param("emp") Emp emp);
}
