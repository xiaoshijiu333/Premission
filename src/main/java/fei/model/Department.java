package fei.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xiaoshijiu
 * @location Premission/fei.model
 * @date 2019/4/6
 */
@Setter@Getter@ToString
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
}
