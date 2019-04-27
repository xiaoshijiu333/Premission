package fei.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiaoshijiu
 * @location Premission/fei.model
 * @date 2019/4/6
 */
@Setter
@Getter
@ToString
public class Employee {
    private Long id;

    private String username;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inputtime;

    private String telphone;

    private String email;

    /**
     * 是否在职
     */
    private Boolean state;

    /**
     * 是否是管理员
     */
    private Boolean admin;

    /**
     * 部门
     */
    private Department department;
}
