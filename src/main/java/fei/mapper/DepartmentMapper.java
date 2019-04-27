package fei.mapper;

import fei.model.Department;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.mapper
 * @date 2019/4/7
 */
public interface DepartmentMapper {

    /**
     * @function: 查询所有部门
     */
    List<Department> departList();
}
