package fei.mapper;

import fei.model.Employee;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.mapper
 * @date 2019/4/6
 */
public interface EmployeeMapper {

    /**
     * @function: 获取员工列表
     */
    List<Employee> employeeList();

    /**
     * @function: 插入员工
     */
    void saveEmployee(Employee employee);

    /**
     * @function: 根据用户名查找员工
     */
    Employee getEmployeeByUserName(String username);
}
