package fei.web.shiro.realm;

import fei.model.Employee;
import fei.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaoshijiu
 * @location Premission/fei.web.shiro.realm
 * @date 2019/4/25
 */
public class EmployeeRealm extends AuthorizingRealm {


    @Autowired
    private EmployeeService employeeService;

    private static final Log LOG = LogFactory.getLog(EmployeeRealm.class);

    /**
     * @function: 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        LOG.info("来到了认证");
        //获取身份信息
        String username = (String) token.getPrincipal();
        LOG.info("用户名：" + username);

        //根据用户名查询有没有当前用户
        Employee employee = employeeService.getEmployeeByUserName(username);

        //没有查询到或者不是管理员，直接返回null
        if (employee == null || employee.getAdmin() == false) {
            return null;
        }

        //定义加密的盐值，是ByteSource类型
        ByteSource salt = ByteSource.Util.bytes(employee.getUsername());

        LOG.info("密码明文：" + employee.getPassword());

        /**
         * @function: 数据库密码加密（因为存的还是明文）
         * 参数：加密算法，密码（需要加密的字段），加密的盐值（通常为了区分各用户，使用用户主键），加密迭代次数
         */
        SimpleHash newpassword =
                new SimpleHash("MD5", employee.getPassword(), salt, 3);

        LOG.info("密码密文：" + newpassword);


        /**
         * 因为当前realm配置了凭证管理器，所以token中的密码会自动加密
         * 就是将SimpleAuthenticationInfo的密码与token的密码进行匹配判断是否可以登录成功
         * 参数: 主体,正确的密码,盐,当前realm名称
         * */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee, newpassword, salt, this.getName());

        return info;
    }

    /**
     * @function: 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
