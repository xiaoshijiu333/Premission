package fei.web;

import fei.model.Employee;
import fei.model.ResultMessage;
import fei.service.EmployeeService;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaoshijiu
 * @location Premission/fei.web
 * @date 2019/4/6
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * @function: 获取员工列表
     * EasyUI绑定json数据的key必须是rows
     */
    @RequestMapping("/employeeList")
    @ResponseBody
    public List<Employee> employeeList(){
        List<Employee> employees = employeeService.employeeList();

        return employees;
    }

    /**
     * @function: 添加员工
     * @RequiresPermissions("create") 表示必须要有create的权限才可以访问
     */
    @ResponseBody
    @RequestMapping("/saveEmployee")
    @RequiresPermissions("create")
    public ResultMessage saveEmployee(Employee employee){
        try {
            //手动设置员工在职
            employee.setState(true);
            employeeService.saveEmployee(employee);
            //设置成功的返回信息
            ResultMessage message = ResultMessage.succ();
            return message;
        }catch (Exception e){
            //有异常就会进入这里
            ResultMessage message = ResultMessage.fail();
            return message;
        }
    }

    /**
     * @function: 没有权限异常处理
     */
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public ResultMessage ShiroException(){
        ResultMessage<String> message = new ResultMessage<>();
        message.setResultCode(200);
        message.setResultMes("你没有权限访问进行该操作");
        message.setResultData(null);
        return message;
    }
}
