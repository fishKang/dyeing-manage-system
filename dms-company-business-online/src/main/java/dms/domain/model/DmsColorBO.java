package dms.domain.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class DmsColorBO implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 颜色名称
     *
     * @mbggenerated
     */
    private String name;

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
}