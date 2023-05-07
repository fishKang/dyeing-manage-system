package dms.dto;

import java.io.Serializable;

public class DmsUser implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 状态 0-有效 1-无效
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 权限 0-系统管理员 1-高级操作员 2-中级操作员 3-初级操作员
     *
     * @mbggenerated
     */
    private Integer permission;

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
     * 操作员
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
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
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", permission=").append(permission);
        sb.append(", createdate=").append(createdate);
        sb.append(", createtime=").append(createtime);
        sb.append(", expirydate=").append(expirydate);
        sb.append(", expirytime=").append(expirytime);
        sb.append(", operator=").append(operator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}