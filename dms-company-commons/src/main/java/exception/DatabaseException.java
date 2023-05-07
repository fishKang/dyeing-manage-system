package exception;

import lombok.Data;

@Data
public class DatabaseException extends RuntimeException{

    private int sqlCode;
    private String sqlState;
    private String sqlMessage;
    private Throwable throwable;

    public DatabaseException(){

    }
    public DatabaseException(String message) {
        this.sqlMessage = message;
    }
    public DatabaseException(String message, Throwable e) {
        this.sqlMessage = message;
        this.throwable = e;
    }
}
