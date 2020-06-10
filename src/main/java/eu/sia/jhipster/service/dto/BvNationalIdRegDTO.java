package eu.sia.jhipster.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import eu.sia.jhipster.domain.enumeration.EVENTEnum;
import eu.sia.jhipster.domain.enumeration.STATUSEnum;

/**
 * A DTO for the {@link eu.sia.jhipster.domain.BvNationalIdReg} entity.
 */
public class BvNationalIdRegDTO implements Serializable {
    
    private Long id;

    private Long submitterMemberId;

    private Long submitterTraderId;

    private String submitterTraderName;

    @NotNull
    private Long memberId;

    private Integer nationalIdType;

    private String nationalIdCode;

    @NotNull
    private String shortCode;

    private String idNameDisplay;

    private String countryCodeInvestmentDecision;

    private String countryCodeOrderExecution;

    private EVENTEnum event;

    private STATUSEnum status;

    private String userData;

    private Long creationDate;

    private Long creationTime;

    @NotNull
    private Long updateDate;

    @NotNull
    private Long updateTime;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubmitterMemberId() {
        return submitterMemberId;
    }

    public void setSubmitterMemberId(Long submitterMemberId) {
        this.submitterMemberId = submitterMemberId;
    }

    public Long getSubmitterTraderId() {
        return submitterTraderId;
    }

    public void setSubmitterTraderId(Long submitterTraderId) {
        this.submitterTraderId = submitterTraderId;
    }

    public String getSubmitterTraderName() {
        return submitterTraderName;
    }

    public void setSubmitterTraderName(String submitterTraderName) {
        this.submitterTraderName = submitterTraderName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getNationalIdType() {
        return nationalIdType;
    }

    public void setNationalIdType(Integer nationalIdType) {
        this.nationalIdType = nationalIdType;
    }

    public String getNationalIdCode() {
        return nationalIdCode;
    }

    public void setNationalIdCode(String nationalIdCode) {
        this.nationalIdCode = nationalIdCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getIdNameDisplay() {
        return idNameDisplay;
    }

    public void setIdNameDisplay(String idNameDisplay) {
        this.idNameDisplay = idNameDisplay;
    }

    public String getCountryCodeInvestmentDecision() {
        return countryCodeInvestmentDecision;
    }

    public void setCountryCodeInvestmentDecision(String countryCodeInvestmentDecision) {
        this.countryCodeInvestmentDecision = countryCodeInvestmentDecision;
    }

    public String getCountryCodeOrderExecution() {
        return countryCodeOrderExecution;
    }

    public void setCountryCodeOrderExecution(String countryCodeOrderExecution) {
        this.countryCodeOrderExecution = countryCodeOrderExecution;
    }

    public EVENTEnum getEvent() {
        return event;
    }

    public void setEvent(EVENTEnum event) {
        this.event = event;
    }

    public STATUSEnum getStatus() {
        return status;
    }

    public void setStatus(STATUSEnum status) {
        this.status = status;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BvNationalIdRegDTO)) {
            return false;
        }

        return id != null && id.equals(((BvNationalIdRegDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BvNationalIdRegDTO{" +
            "id=" + getId() +
            ", submitterMemberId=" + getSubmitterMemberId() +
            ", submitterTraderId=" + getSubmitterTraderId() +
            ", submitterTraderName='" + getSubmitterTraderName() + "'" +
            ", memberId=" + getMemberId() +
            ", nationalIdType=" + getNationalIdType() +
            ", nationalIdCode='" + getNationalIdCode() + "'" +
            ", shortCode='" + getShortCode() + "'" +
            ", idNameDisplay='" + getIdNameDisplay() + "'" +
            ", countryCodeInvestmentDecision='" + getCountryCodeInvestmentDecision() + "'" +
            ", countryCodeOrderExecution='" + getCountryCodeOrderExecution() + "'" +
            ", event='" + getEvent() + "'" +
            ", status='" + getStatus() + "'" +
            ", userData='" + getUserData() + "'" +
            ", creationDate=" + getCreationDate() +
            ", creationTime=" + getCreationTime() +
            ", updateDate=" + getUpdateDate() +
            ", updateTime=" + getUpdateTime() +
            "}";
    }
}
