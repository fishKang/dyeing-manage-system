package dms.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class DmsProcessingdtlBO implements Serializable {
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private List<Integer> deletelistid;
    /**
     * 唯一标识
     *
     * @mbggenerated
     */
    private int id;
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
     * 开始查询日期
     *
     * @mbggenerated
     */
    private String begindate;

    /**
     * 结束查询日期
     *
     * @mbggenerated
     */
    private String enddate;

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
}
