package cn.edu.nuc.community.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class User {
    private Integer userId;

    private Integer roleId;

    @NotEmpty(message="用户名不能为空！")
    @Pattern(regexp="\\w{6,20}",message="用户名6-20位")
    private String userName;
    
    @NotEmpty(message="密码不能为空")
    @Length(max=20,min=6,message="密码不能小于6位")
    private String userPassword;

    @Pattern(regexp="^1[34578]\\d{9}$",message="手机号不存在！")
    private String userPhone;

    @Email
    private String userEmail;
    @Pattern(regexp="^[\u4E00-\u9FA5]{1,6}$",message="必须为中文名！")
    private String userRealname;
    @Pattern(regexp="(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)",message="身份证格式不对！")
    private String userCard;
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userBirth;

    private String userAddress;
    @Min(value=0)
    private BigDecimal userAccount;

    private BigDecimal userState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard == null ? null : userCard.trim();
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public BigDecimal getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BigDecimal userAccount) {
        this.userAccount = userAccount;
    }

    public BigDecimal getUserState() {
        return userState;
    }

    public void setUserState(BigDecimal userState) {
        this.userState = userState;
    }
}