package cn.edu.nuc.community.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Rinfo {
    private Integer rinfoId;

    private Integer leagueId;
    
    private League league;

    private Integer serviceId;
    
    private Services service;

    private String rinfoDesc;

    private BigDecimal rinfoPrice;

    private String rinfoDate;

    public Integer getRinfoId() {
        return rinfoId;
    }

    public void setRinfoId(Integer rinfoId) {
        this.rinfoId = rinfoId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getRinfoDesc() {
        return rinfoDesc;
    }

    public void setRinfoDesc(String rinfoDesc) {
        this.rinfoDesc = rinfoDesc == null ? null : rinfoDesc.trim();
    }

    public BigDecimal getRinfoPrice() {
        return rinfoPrice;
    }

    public void setRinfoPrice(BigDecimal rinfoPrice) {
        this.rinfoPrice = rinfoPrice;
    }

    public String getRinfoDate() {
        return rinfoDate;
    }

    public void setRinfoDate(String rinfoDate) {
        this.rinfoDate = rinfoDate;
    }

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}
    
    
}