package dms.common;

public enum CodeEnum {
    ERR_0000("0000","交易成功"),
    ERR_0001("0001","用户注册查询失败"),
    ERR_0002("0002","用户未找到记录"),
    ERR_0003("0003","用户已注册"),
    ERR_0004("0004","用户注册失败"),
    ERR_0005("0005","用户登录失败"),
    ERR_0006("0006","加工明细插入失败"),
    ERR_0007("0007","加工明细更新失败"),
    ERR_0100("0100","渠道日志已存在此记录"),
    ERR_0101("0101","渠道日志更新失败"),
    ERR_9999("9999","处理异常"),
    ;

    private String code;
    private String msg;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getErrMsg(String code){
        for(CodeEnum codeEnum:CodeEnum.values()){
            if(code.equals(codeEnum.getCode())){
                return codeEnum.getMsg();
            }
        }
        return "";
    }

}
