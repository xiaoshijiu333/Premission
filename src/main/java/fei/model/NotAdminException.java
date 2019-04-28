package fei.model;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @author xiaoshijiu
 * @description 自定义异常，不是管理员异常，继承认证异常
 * @package fei.model
 * @date 2019/4/28
 */
public class NotAdminException extends AuthenticationException {

    public NotAdminException(String message) {
        super(message);
    }

}
