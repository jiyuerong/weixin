package cn.com.widemex.streetDiscount.shopPlatform.domain.log;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OperatorRec entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OPERATOR_REC", schema = "PORTAL")
@SequenceGenerator(name="opLogGenerator", sequenceName="SEQ_OPERACTOR_REC", allocationSize=1)
public class OperatorRec implements java.io.Serializable {

	// Fields

	private BigDecimal opeRecId;
	private String account;
	private String operationType;
	private String operationTarget;
	private String description;
	private Date operateTime;

	// Constructors

	/** default constructor */
	public OperatorRec() {
	}

	/** minimal constructor */
	public OperatorRec(BigDecimal opeRecId) {
		this.opeRecId = opeRecId;
	}

	/** full constructor */
	public OperatorRec(BigDecimal opeRecId, String account,
			String operationType, String operationTarget, String description,
			Date operateTime) {
		this.opeRecId = opeRecId;
		this.account = account;
		this.operationType = operationType;
		this.operationTarget = operationTarget;
		this.description = description;
		this.operateTime = operateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="opLogGenerator")
	@Column(name = "OPE_REC_ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getOpeRecId() {
		return this.opeRecId;
	}

	public void setOpeRecId(BigDecimal opeRecId) {
		this.opeRecId = opeRecId;
	}

	@Column(name = "ACCOUNT", length = 32)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "OPERATION_TYPE", length = 120)
	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Column(name = "OPERATION_TARGET", length = 120)
	public String getOperationTarget() {
		return this.operationTarget;
	}

	public void setOperationTarget(String operationTarget) {
		this.operationTarget = operationTarget;
	}

	@Column(name = "DESCRIPTION", length = 120)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPERATE_TIME", length = 7)
	public Date getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

}