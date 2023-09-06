package dms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class  DmsProcessingdtl implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 客户名称
     *
     * @mbggenerated
     */
    private String customer;

    /**
     * 计划号
     *
     * @mbggenerated
     */
    private String plan;

    /**
     * 色号
     *
     * @mbggenerated
     */
    private String colorcode;

    /**
     * 类型
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 原料
     *
     * @mbggenerated
     */
    private String material;

    /**
     * 状态 0-有效 1-无效
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 计划量
     *
     * @mbggenerated
     */
    private BigDecimal plannedvolume;

    /**
     * 出库净重
     *
     * @mbggenerated
     */
    private BigDecimal netweight;

    /**
     * 出库日期
     *
     * @mbggenerated
     */
    private String outbounddate;

    /**
     * 登记时间
     *
     * @mbggenerated
     */
    private String createtime;

    /**
     * 登记日期
     *
     * @mbggenerated
     */
    private String createdate;

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
     * 操作员
     *
     * @mbggenerated
     */
    private String operator;

    /**
     * 结算量
     *
     * @mbggenerated
     */
    private BigDecimal settlementvolume;

    /**
     * 单价类型 0-数量关系 1-固定值
     *
     * @mbggenerated
     */
    private Integer pricetype;

    /**
     * 单价
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * 金额
     *
     * @mbggenerated
     */
    private BigDecimal amount;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPlannedvolume() {
        return plannedvolume;
    }

    public void setPlannedvolume(BigDecimal plannedvolume) {
        this.plannedvolume = plannedvolume;
    }

    public BigDecimal getNetweight() {
        return netweight;
    }

    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }

    public String getOutbounddate() {
        return outbounddate;
    }

    public void setOutbounddate(String outbounddate) {
        this.outbounddate = outbounddate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public BigDecimal getSettlementvolume() {
        return settlementvolume;
    }

    public void setSettlementvolume(BigDecimal settlementvolume) {
        this.settlementvolume = settlementvolume;
    }

    public Integer getPricetype() {
        return pricetype;
    }

    public void setPricetype(Integer pricetype) {
        this.pricetype = pricetype;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customer=").append(customer);
        sb.append(", plan=").append(plan);
        sb.append(", colorcode=").append(colorcode);
        sb.append(", type=").append(type);
        sb.append(", material=").append(material);
        sb.append(", status=").append(status);
        sb.append(", plannedvolume=").append(plannedvolume);
        sb.append(", netweight=").append(netweight);
        sb.append(", outbounddate=").append(outbounddate);
        sb.append(", createtime=").append(createtime);
        sb.append(", createdate=").append(createdate);
        sb.append(", expirydate=").append(expirydate);
        sb.append(", expirytime=").append(expirytime);
        sb.append(", operator=").append(operator);
        sb.append(", settlementvolume=").append(settlementvolume);
        sb.append(", pricetype=").append(pricetype);
        sb.append(", price=").append(price);
        sb.append(", amount=").append(amount);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}