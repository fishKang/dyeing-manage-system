package dms.infrastructure.exception;

import lombok.Data;

@Data
public class BusinessFailException extends Exception{
    private static final long serialVersionUID = 1184944069954989435L;

    private String code;
    private String msg;
    private String info;

    public BusinessFailException() {
        super();
    }

    public BusinessFailException(String message) {
        super(message);
    }

    public BusinessFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessFailException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BusinessFailException(String code, String message,String info) {
        super(message);
        this.code = code;
        this.msg = message;
        this.info = info;
    }

    public BusinessFailException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessFailException(Throwable cause) {
        super(cause);
    }

    public BusinessFailException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public BusinessFailException(String code, String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
