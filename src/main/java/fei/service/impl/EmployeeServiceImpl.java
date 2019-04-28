package fei.service.impl;

import fei.mapper.EmployeeMapper;
import fei.model.Employee;
import fei.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.service.impl
 * @date 2019/4/6
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * @function: 获取员工列表
     */
    @Override
    public List<Employee> employeeList() {
        return employeeMapper.employeeList();
    }

    /**
     * @function: 插入员工
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeMapper.saveEmployee(employee);
    }

    /**
     * @function: 根据用户名查找员工
     */
    @Override
    public Employee getEmployeeByUserName(String username) {
        return employeeMapper.getEmployeeByUserName(username);
    }


    /**
     * @function: 根据角色获取用户的权限
     */
    @Override
    public List<String> getEmployeePremission(List<String> roles) {
        return employeeMapper.getEmployeePremission(roles);
    }

    /**
     * @function: 根据用户id获取用户的角色
     */
    @Override
    public List<String> getEmployeeRoles(Long id) {
        return employeeMapper.getEmployeeRoles(id);
    }
}
