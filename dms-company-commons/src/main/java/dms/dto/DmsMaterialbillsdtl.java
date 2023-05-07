package dms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DmsMaterialbillsdtl implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 料单明细编号
     *
     * @mbggenerated
     */
    private Integer billid;

    /**
     * 染料、助剂名称
     *
     * @mbggenerated
     */
    private String dyename;

    /**
     * %用量、比重
     *
     * @mbggenerated
     */
    private BigDecimal proportion;

    /**
     * 磅出量（克）
     *
     * @mbggenerated
     */
    private BigDecimal quantity;

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    private String createdate;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * 失效日期
     *
     * @mbggenerated
     */
    private String expirydate;

    /**
     * 失效时间
     *
     * @mbggenerated
     */
    private String expirytime;

    /**
     * 状态 0-正常 1-作废
     *
     * @mbggenerated
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public String getDyename() {
        return dyename;
    }

    public void setDyename(String dyename) {
        this.dyename = dyename;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(String expirytime) {
        this.expirytime = expirytime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billid=").append(billid);
        sb.append(", dyename=").append(dyename);
        sb.append(", proportion=").append(proportion);
        sb.append(", quantity=").append(quantity);
        sb.append(", createdate=").append(createdate);
        sb.append(", createtime=").append(createtime);
        sb.append(", expirydate=").append(expirydate);
        sb.append(", expirytime=").append(expirytime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}