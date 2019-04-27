package fei.web;

import fei.model.Department;
import fei.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.web
 * @date 2019/4/7
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @function: 获取所有部门
     * EasyUI绑定json数据的key必须是rows
     */
    @ResponseBody
    @RequestMapping("/departList")
    public List<Department> departList(){
        return departmentService.departList();
    }
}
