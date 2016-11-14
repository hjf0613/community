package cn.edu.nuc.community.entity;

import java.math.BigDecimal;

public class Function {
    private Integer funId;

    private String funName;

    private String funUrl;

    private BigDecimal funPid;
    
    private String funPname;

    private BigDecimal funState;
    
    private Integer rr;
    

    public Integer getRr() {
		return rr;
	}

	public void setRr(Integer rr) {
		this.rr = rr;
	}

	public String getFunPname() {
		return funPname;
	}

	public void setFunPname(String funPname) {
		this.funPname = funPname;
	}

	public Integer getFunId() {
        return funId;
    }

    public void setFunId(Integer funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName == null ? null : funName.trim();
    }

    public String getFunUrl() {
        return funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl == null ? null : funUrl.trim();
    }

    public BigDecimal getFunPid() {
        return funPid;
    }

    public void setFunPid(BigDecimal funPid) {
        this.funPid = funPid;
    }

    public BigDecimal getFunState() {
        return funState;
    }

    public void setFunState(BigDecimal funState) {
        this.funState = funState;
    }

	@Override
	public String toString() {
		return "Function [funId=" + funId + ", funName=" + funName + ", funUrl=" + funUrl + ", funPid=" + funPid
				+ ", funPname=" + funPname + ", funState=" + funState + ", rr=" + rr + "]";
	}
    
}