package cn.edu.nuc.community.entity;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class League {
    private Integer leagueId;

    private Integer roleId;
    
    @NotEmpty(message="用户名不能为空！")
    private String leagueName;
    
    @NotEmpty(message="密码不能为空")
    @Length(max=20,min=6,message="密码不能小于6位")
    private String leaguePassword;

    private String leagueCompany;
    
    @Pattern(regexp="^1[34578]\\d{9}$",message="手机号不存在！")
    private String leaguePhone;

    @Email
    private String leagueEmail;

    private BigDecimal leagueState;

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName == null ? null : leagueName.trim();
    }

    public String getLeaguePassword() {
        return leaguePassword;
    }

    public void setLeaguePassword(String leaguePassword) {
        this.leaguePassword = leaguePassword == null ? null : leaguePassword.trim();
    }

    public String getLeagueCompany() {
        return leagueCompany;
    }

    public void setLeagueCompany(String leagueCompany) {
        this.leagueCompany = leagueCompany == null ? null : leagueCompany.trim();
    }

    public String getLeaguePhone() {
        return leaguePhone;
    }

    public void setLeaguePhone(String leaguePhone) {
        this.leaguePhone = leaguePhone == null ? null : leaguePhone.trim();
    }

    public String getLeagueEmail() {
        return leagueEmail;
    }

    public void setLeagueEmail(String leagueEmail) {
        this.leagueEmail = leagueEmail == null ? null : leagueEmail.trim();
    }

    public BigDecimal getLeagueState() {
        return leagueState;
    }

    public void setLeagueState(BigDecimal leagueState) {
        this.leagueState = leagueState;
    }

	@Override
	public String toString() {
		return "League [leagueId=" + leagueId + ", roleId=" + roleId + ", leagueName=" + leagueName
				+ ", leaguePassword=" + leaguePassword + ", leagueCompany=" + leagueCompany + ", leaguePhone="
				+ leaguePhone + ", leagueEmail=" + leagueEmail + ", leagueState=" + leagueState + "]";
	}
    
    
}