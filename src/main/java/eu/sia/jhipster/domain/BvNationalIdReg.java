package eu.sia.jhipster.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

import eu.sia.jhipster.domain.enumeration.EVENTEnum;

import eu.sia.jhipster.domain.enumeration.STATUSEnum;

/**
 * A BvNationalIdReg.
 */
@Entity
@Table(name = "bv_national_id_reg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "bvnationalidreg")
public class BvNationalIdReg implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "submitter_member_id")
    private Long submitterMemberId;

    @Column(name = "submitter_trader_id")
    private Long submitterTraderId;

    @Column(name = "submitter_trader_name")
    private String submitterTraderName;

    @NotNull
    @Column(name = "member_id", nullable = false, unique = true)
    private Long memberId;

    @Column(name = "national_id_type")
    private Integer nationalIdType;

    @Column(name = "national_id_code")
    private String nationalIdCode;

    @NotNull
    @Column(name = "short_code", nullable = false, unique = true)
    private String shortCode;

    @Column(name = "id_name_display")
    private String idNameDisplay;

    @Column(name = "country_code_investment_decision")
    private String countryCodeInvestmentDecision;

    @Column(name = "country_code_order_execution")
    private String countryCodeOrderExecution;

    @Enumerated(EnumType.STRING)
    @Column(name = "event")
    private EVENTEnum event;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private STATUSEnum status;

    @Column(name = "user_data")
    private String userData;

    @Column(name = "creation_date")
    private Long creationDate;

    @Column(name = "creation_time")
    private Long creationTime;

    @NotNull
    @Column(name = "update_date", nullable = false, unique = true)
    private Long updateDate;

    @NotNull
    @Column(name = "update_time", nullable = false, unique = true)
    private Long updateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubmitterMemberId() {
        return submitterMemberId;
    }

    public BvNationalIdReg submitterMemberId(Long submitterMemberId) {
        this.submitterMemberId = submitterMemberId;
        return this;
    }

    public void setSubmitterMemberId(Long submitterMemberId) {
        this.submitterMemberId = submitterMemberId;
    }

    public Long getSubmitterTraderId() {
        return submitterTraderId;
    }

    public BvNationalIdReg submitterTraderId(Long submitterTraderId) {
        this.submitterTraderId = submitterTraderId;
        return this;
    }

    public void setSubmitterTraderId(Long submitterTraderId) {
        this.submitterTraderId = submitterTraderId;
    }

    public String getSubmitterTraderName() {
        return submitterTraderName;
    }

    public BvNationalIdReg submitterTraderName(String submitterTraderName) {
        this.submitterTraderName = submitterTraderName;
        return this;
    }

    public void setSubmitterTraderName(String submitterTraderName) {
        this.submitterTraderName = submitterTraderName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public BvNationalIdReg memberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getNationalIdType() {
        return nationalIdType;
    }

    public BvNationalIdReg nationalIdType(Integer nationalIdType) {
        this.nationalIdType = nationalIdType;
        return this;
    }

    public void setNationalIdType(Integer nationalIdType) {
        this.nationalIdType = nationalIdType;
    }

    public String getNationalIdCode() {
        return nationalIdCode;
    }

    public BvNationalIdReg nationalIdCode(String nationalIdCode) {
        this.nationalIdCode = nationalIdCode;
        return this;
    }

    public void setNationalIdCode(String nationalIdCode) {
        this.nationalIdCode = nationalIdCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public BvNationalIdReg shortCode(String shortCode) {
        this.shortCode = shortCode;
        return this;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getIdNameDisplay() {
        return idNameDisplay;
    }

    public BvNationalIdReg idNameDisplay(String idNameDisplay) {
        this.idNameDisplay = idNameDisplay;
        return this;
    }

    public void setIdNameDisplay(String idNameDisplay) {
        this.idNameDisplay = idNameDisplay;
    }

    public String getCountryCodeInvestmentDecision() {
        return countryCodeInvestmentDecision;
    }

    public BvNationalIdReg countryCodeInvestmentDecision(String countryCodeInvestmentDecision) {
        this.countryCodeInvestmentDecision = countryCodeInvestmentDecision;
        return this;
    }

    public void setCountryCodeInvestmentDecision(String countryCodeInvestmentDecision) {
        this.countryCodeInvestmentDecision = countryCodeInvestmentDecision;
    }

    public String getCountryCodeOrderExecution() {
        return countryCodeOrderExecution;
    }

    public BvNationalIdReg countryCodeOrderExecution(String countryCodeOrderExecution) {
        this.countryCodeOrderExecution = countryCodeOrderExecution;
        return this;
    }

    public void setCountryCodeOrderExecution(String countryCodeOrderExecution) {
        this.countryCodeOrderExecution = countryCodeOrderExecution;
    }

    public EVENTEnum getEvent() {
        return event;
    }

    public BvNationalIdReg event(EVENTEnum event) {
        this.event = event;
        return this;
    }

    public void setEvent(EVENTEnum event) {
        this.event = event;
    }

    public STATUSEnum getStatus() {
        return status;
    }

    public BvNationalIdReg status(STATUSEnum status) {
        this.status = status;
        return this;
    }

    public void setStatus(STATUSEnum status) {
        this.status = status;
    }

    public String getUserData() {
        return userData;
    }

    public BvNationalIdReg userData(String userData) {
        this.userData = userData;
        return this;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public BvNationalIdReg creationDate(Long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public BvNationalIdReg creationTime(Long creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public BvNationalIdReg updateDate(Long updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public BvNationalIdReg updateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BvNationalIdReg)) {
            return false;
        }
        return id != null && id.equals(((BvNationalIdReg) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BvNationalIdReg{" +
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
