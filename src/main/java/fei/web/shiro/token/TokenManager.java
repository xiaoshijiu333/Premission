package fei.web.shiro.token;

import fei.model.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author xiaoshijiu
 * @location Premission/fei.web.shiro.token
 * @description shiro管理下的 token工具类
 * @date 2019/4/26
 */
public class TokenManager {

    /**
     * @function: 当前用户信息
     * shiro登录成功后就可以拿到当前subject的所有信息
     */
    public static Employee getInfo(){
        return (Employee) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * @function: 登录认证
     */
    public static Employee login(Employee employee){
        //用户模型变成shiro里面的UsernamepasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(employee.getUsername(), employee.getPassword());
        //shiro登录认证，会传到配置的自定义的realm中
        SecurityUtils.getSubject().login(token);
        return getInfo();
    }
}
