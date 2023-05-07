package dms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DmsMaterialbills implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 类型 0-纱染 1-散染
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 客户名称
     *
     * @mbggenerated
     */
    private String customer;

    /**
     * 投缸量KG
     *
     * @mbggenerated
     */
    private BigDecimal quantity;

    /**
     * 色名
     *
     * @mbggenerated
     */
    private String colorname;

    /**
     * 色号
     *
     * @mbggenerated
     */
    private String colorcode;

    /**
     * 成衣缸号
     *
     * @mbggenerated
     */
    private String clothescode;

    /**
     * 纱线缸号
     *
     * @mbggenerated
     */
    private String yarncode;

    /**
     * 状态 0-有效 1-无效
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 创建日期
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
     * 计划号
     *
     * @mbggenerated
     */
    private String plan;

    /**
     * 原料品种
     *
     * @mbggenerated
     */
    private String material;

    /**
     * 明细数量
     *
     * @mbggenerated
     */
    private Integer count;

    /**
     * 工艺及说明
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 制表/操作员
     *
     * @mbggenerated
     */
    private String operator;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getClothescode() {
        return clothescode;
    }

    public void setClothescode(String clothescode) {
        this.clothescode = clothescode;
    }

    public String getYarncode() {
        return yarncode;
    }

    public void setYarncode(String yarncode) {
        this.yarncode = yarncode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", customer=").append(customer);
        sb.append(", quantity=").append(quantity);
        sb.append(", colorname=").append(colorname);
        sb.append(", colorcode=").append(colorcode);
        sb.append(", clothescode=").append(clothescode);
        sb.append(", yarncode=").append(yarncode);
        sb.append(", status=").append(status);
        sb.append(", createdate=").append(createdate);
        sb.append(", expirydate=").append(expirydate);
        sb.append(", plan=").append(plan);
        sb.append(", material=").append(material);
        sb.append(", count=").append(count);
        sb.append(", description=").append(description);
        sb.append(", operator=").append(operator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}