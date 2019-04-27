package fei.service.impl;

import fei.mapper.DepartmentMapper;
import fei.model.Department;
import fei.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.service.impl
 * @date 2019/4/7
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * @function: 获取所有部门
     */
    @Override
    public List<Department> departList() {
        return departmentMapper.departList();
    }
}
