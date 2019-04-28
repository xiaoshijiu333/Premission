package fei.service;

import fei.model.Employee;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.service
 * @date 2019/4/6
 */
public interface EmployeeService {

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

    /**
     * @function: 根据角色获取用户的权限
     */
    List<String> getEmployeePremission(List<String> roles);

    /**
     * @function: 根据用户id获取用户的角色
     */
    List<String> getEmployeeRoles(Long id);
}
