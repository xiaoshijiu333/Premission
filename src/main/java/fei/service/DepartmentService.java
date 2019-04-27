package fei.service;

import fei.model.Department;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.service
 * @date 2019/4/7
 */
public interface DepartmentService {

    /**
     * @function: 获取所有部门
     */
    List<Department> departList();
}
