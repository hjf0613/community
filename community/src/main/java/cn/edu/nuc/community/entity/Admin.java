package cn.edu.nuc.community.entity;

public class Admin {
    private Integer adminId;

    private Integer roleId;
    
    private String roleName;

    private String adminName;

    private String adminPassword;

    
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", roleId=" + roleId + ", roleName=" + roleName + ", adminName="
				+ adminName + ", adminPassword=" + adminPassword + "]";
	}
    
}