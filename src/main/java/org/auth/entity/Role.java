package org.auth.entity;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;

public class Role {
    private Integer id;
    private String name;
    private String remark;
    private String functionIds;

    public Role() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }
}
