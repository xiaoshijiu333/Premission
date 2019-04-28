package fei.web;

import fei.model.Employee;
import fei.model.NotAdminException;
import fei.model.ResultMessage;
import fei.web.shiro.realm.EmployeeRealm;
import fei.web.shiro.token.TokenManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author xiaoshijiu
 * @location Premission/fei.web
 * @description 管理员登录
 * @date 2019/4/26
 */
@RestController
public class LoginController {

    private static final Log LOG = LogFactory.getLog(EmployeeRealm.class);

    @RequestMapping("/login")
    public ResultMessage userLogin(Employee employee){

        ResultMessage message = new ResultMessage();

        try {
            TokenManager.login(employee);
            LOG.info("登录成功");
            return ResultMessage.succ();
        }catch (UnknownAccountException e){
            message.setResultCode(200);
            message.setResultMes("账户不存在");
            LOG.warn("账户不存在");
            return message;
        }catch (NotAdminException e){
            message.setResultCode(200);
            message.setResultMes(e.getMessage());
            LOG.warn(e.getMessage());
            return message;
        }
        catch (IncorrectCredentialsException e){
            message.setResultCode(200);
            message.setResultMes("密码错误");
            LOG.warn("密码错误");
            return message;
        }catch (Exception e){
            message.setResultCode(500);
            message.setResultMes("服务器发生异常");
            LOG.error(e.getMessage());
            return message;
        }
    }
}
