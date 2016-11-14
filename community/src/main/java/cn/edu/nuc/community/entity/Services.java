package cn.edu.nuc.community.entity;

import java.math.BigDecimal;

public class Services {
    private Integer serviceId;

    private BigDecimal servicePid;

    private String serviceName;

    private BigDecimal serviceState;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getServicePid() {
        return servicePid;
    }

    public void setServicePid(BigDecimal servicePid) {
        this.servicePid = servicePid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public BigDecimal getServiceState() {
        return serviceState;
    }

    public void setServiceState(BigDecimal serviceState) {
        this.serviceState = serviceState;
    }
}