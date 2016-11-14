package cn.edu.nuc.community.entity;

import java.math.BigDecimal;

public class Role {
    private Integer roleId;

    private String roleName;

    private BigDecimal roleState;

    private String roleDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public BigDecimal getRoleState() {
        return roleState;
    }

    public void setRoleState(BigDecimal roleState) {
        this.roleState = roleState;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }
}