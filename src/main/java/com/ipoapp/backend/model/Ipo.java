/*
package com.ipoapp.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String openDate;
    private String closeDate;
    private Double issueSize;
    private String priceBand;
    private String subscription;
    private Double gmp;
    private String status;
    private String details;

    // GETTERS
    public Long getId() { return id; }
    public String getCompanyName() { return companyName; }
    public String getOpenDate() { return openDate; }
    public String getCloseDate() { return closeDate; }
    public Double getIssueSize() { return issueSize; }
    public String getPriceBand() { return priceBand; }
    public String getSubscription() { return subscription; }
    public Double getGmp() { return gmp; }
    public String getStatus() { return status; }
    public String getDetails(){ return details;}

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setOpenDate(String openDate) { this.openDate = openDate; }
    public void setCloseDate(String closeDate) { this.closeDate = closeDate; }
    public void setIssueSize(Double issueSize) { this.issueSize = issueSize; }
    public void setPriceBand(String priceBand) { this.priceBand = priceBand; }
    public void setSubscription(String subscription) { this.subscription = subscription; }
    public void setGmp(Double gmp) { this.gmp = gmp; }
    public void setStatus(String status) { this.status = status; }
    public void setDetails(String details){this.details=details;}
}
*/
package com.ipoapp.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ipo")
public class Ipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // core fields
    private String companyName;
    private Double gmp;
    private String subscription;
    private String type; // "Mainboard" or "SME"
    private String openDate;   // store as ISO string yyyy-MM-dd
    private String closeDate;
    private Double issuePrice;
    private String priceBand;
    private String issueSize;  // you previously used strings for size
 
   
    private String status;

    @Column(columnDefinition = "TEXT")
    private String description; // admin can set per-IPO content

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getOpenDate() { return openDate; }
    public void setOpenDate(String openDate) { this.openDate = openDate; }

    public String getCloseDate() { return closeDate; }
    public void setCloseDate(String closeDate) { this.closeDate = closeDate; }

    public Double getIssuePrice() { return issuePrice; }
    public void setIssuePrice(Double issuePrice) { this.issuePrice = issuePrice; }

    public String getPriceBand() { return priceBand; }
    public void setPriceBand(String priceBand) { this.priceBand = priceBand; }

    public String getIssueSize() { return issueSize; }
    public void setIssueSize(String issueSize) { this.issueSize = issueSize; }

    public String getSubscription() { return subscription; }
    public void setSubscription(String subscription) { this.subscription = subscription; }

    public Double getGmp() { return gmp; }
    public void setGmp(Double gmp) { this.gmp = gmp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}