package cn.edu.nuc.community.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer leagueId;

    private Integer rinfoId;

    private Integer userId;

    private String orderName;

    private BigDecimal orderNumber;

    private BigDecimal orderPrice;

    private Date orderTime;

    private String orderDesc;

    private BigDecimal orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getRinfoId() {
        return rinfoId;
    }

    public void setRinfoId(Integer rinfoId) {
        this.rinfoId = rinfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? null : orderDesc.trim();
    }

    public BigDecimal getOrderState() {
        return orderState;
    }

    public void setOrderState(BigDecimal orderState) {
        this.orderState = orderState;
    }
}