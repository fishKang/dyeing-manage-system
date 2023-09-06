package dms.dto;

import java.io.Serializable;

public class DmsOperatelog implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 染色操作序号
     *
     * @mbggenerated
     */
    private String serialno;

    /**
     * 请求序号
     *
     * @mbggenerated
     */
    private String original;

    /**
     * 请求服务
     *
     * @mbggenerated
     */
    private String service;

    /**
     * 请求方法
     *
     * @mbggenerated
     */
    private String method;

    /**
     * 状态 0-待处理 1-正在处理 2-处理成功 3-处理失败
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 请求日期
     *
     * @mbggenerated
     */
    private String indate;

    /**
     * 请求时间
     *
     * @mbggenerated
     */
    private String intime;

    /**
     * 返回日期
     *
     * @mbggenerated
     */
    private String outdate;

    /**
     * 返回时间
     *
     * @mbggenerated
     */
    private String outtime;

    /**
     * 操作员
     *
     * @mbggenerated
     */
    private String operator;

    /**
     * 请求参数
     *
     * @mbggenerated
     */
    private String input;

    /**
     * 返回参数
     *
     * @mbggenerated
     */
    private String output;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOutdate() {
        return outdate;
    }

    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialno=").append(serialno);
        sb.append(", original=").append(original);
        sb.append(", service=").append(service);
        sb.append(", method=").append(method);
        sb.append(", status=").append(status);
        sb.append(", indate=").append(indate);
        sb.append(", intime=").append(intime);
        sb.append(", outdate=").append(outdate);
        sb.append(", outtime=").append(outtime);
        sb.append(", operator=").append(operator);
        sb.append(", input=").append(input);
        sb.append(", output=").append(output);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}