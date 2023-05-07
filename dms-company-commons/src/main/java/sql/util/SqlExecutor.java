package sql.util;

import exception.DatabaseException;
import org.apache.logging.log4j.Logger;
import spring.util.TradeResponse;

import java.sql.Connection;
import java.sql.Savepoint;
import java.util.List;

public class SqlExecutor {
    private static final ThreadLocal<Boolean> ISTRANSACTION = new ThreadLocal();
    private static final ThreadLocal<IMybatisExecutor> LOCAL = new ThreadLocal();
    private SqlExecutor(){}

    private static IMybatisExecutor getExecutor() {
         Boolean isTran = ISTRANSACTION.get();
        if (isTran != null && isTran) {
            IMybatisExecutor executor = LOCAL.get();
            if (executor == null) {
                executor = new MybatisExecutorWithTransation();
                LOCAL.set(executor);
            }
            return executor;
        } else {
            return new MybatisExecutorWithoutTransation();
        }
    }

    public static void beginTransaction() {
        ISTRANSACTION.set(true);
        LOCAL.set(null);
    }
    public static void endTransaction() {
        close();
        ISTRANSACTION.set(false);
        LOCAL.set(null);
    }

    public static <T> T selectOne(Logger logger,String statementid,Object parameter){
        if(logger != null ){
            logger.info(getExecutor().getStatementById(statementid,parameter));
        }
        return getExecutor().selectOne(statementid,parameter);
    }

    public static <T> T selectOne(String statementId, Object parameter) {
        return getExecutor().selectOne(statementId, parameter);
    }
    public static <T> List<T> selectList(Logger log, String statementId, Object parameter) {
        if (log != null) {
            log.info(getExecutor().getStatementById(statementId, parameter));
        }
        return getExecutor().selectList(statementId, parameter);
    }
    public static <T> List<T> selectList(String statementId, Object parameter) {
        return getExecutor().selectList(statementId, parameter);
    }
    public static <T> List<T> selectList(Logger log, String statementId, Object parameter, int begin, int limit) {
        if (log !=null) {
            log.info(getExecutor().getStatementById(statementId, parameter));
        }
        return getExecutor().selectList(statementId, parameter, begin, limit);
    }
    public static <T> List<T> selectlist(String statementId,Object parameter,int begin,int limit) {
            return getExecutor().selectList(statementId, parameter, begin, limit);
    }
    public static int insert(Logger log, String statementId, Object parameter) {
        if(log!=null){
            log.info(getExecutor().getStatementById(statementId, parameter));
        }
        return getExecutor().insert(statementId, parameter);
    }

    public static int insert(String statementId, Object parameter) {
        return getExecutor().insert(statementId, parameter);
    }
    public static int update(Logger log, String statementId, Object parameter) {
        if (log != null) {
            log.info(getExecutor().getStatementById(statementId, parameter));
        }
        return getExecutor().update(statementId, parameter);
    }
    public static int update(String statementId, Object parameter) {
        return getExecutor().update(statementId, parameter);
    }
    public static int delete(Logger log, String statementId, Object parameter) {
        if (log !=null) {
            log.info(getExecutor().getStatementById(statementId, parameter));
        }
        return getExecutor().delete(statementId, parameter);
    }

    public static int delete(String statementId, Object parameter){
        return getExecutor().delete(statementId, parameter);
    }
    public static DataBaseBean selectListRetDataBaseBean(String statementId, Object parameter) {
        try {
            List ret = getExecutor().selectList(statementId, parameter);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()),var3.getMessage()));
        }
    }

    public static DataBaseBean selectListRetDataBaseBean(String statementId, Object parameter,int begin,int limit) {
        try {
            List ret = getExecutor().selectList(statementId, parameter,begin,limit);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()),var3.getSqlMessage()));
        }
    }

    public static DataBaseBean selectOneRetDataBaseBean(String statementId, Object parameter) {
        try {
            Object ret = getExecutor().selectOne(statementId, parameter);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()), var3.getSqlMessage()));
        }
    }

    public static DataBaseBean insertRetDataBaseBean(String statementId, Object parameter) {
        try {
            Object ret = getExecutor().insert(statementId, parameter);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()), var3.getSqlMessage()));
        }
    }

    public static DataBaseBean updateRetDataBaseBean(String statementId, Object parameter) {
        try {
            Object ret = getExecutor().update(statementId, parameter);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()), var3.getSqlMessage()));
        }
    }
    public static DataBaseBean deleteRetDataBaseBean(String statementId, Object parameter) {
        try {
            Object ret = getExecutor().delete(statementId, parameter);
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createSuccessResponse(null), ret);
        } catch (DatabaseException var3) {
            return new DataBaseBean(getExecutor().getStatementById(statementId, parameter), TradeResponse.createFailResponse(String.valueOf(var3.getSqlCode()), var3.getSqlMessage()));
        }
    }

    public static void commit(){
        getExecutor().commit();
    }

    public static void close(){
        getExecutor().close();
    }

    public static void rollback(){
        getExecutor().rollback();
    }

    public static Savepoint savepoint(String savepointId){
        return getExecutor().savepoint(savepointId);
    }

    public static void rollback(Savepoint savepoint){
        getExecutor().rollback(savepoint);
    }
    public static Connection getConnection() {
        return getExecutor().getConnection();
    }
    public static String getURL(Logger log) {
        return getExecutor().getURL(log);
    }
    public static String getSqlFragment(String statementId, Object parameter) {
        return getExecutor().getStatementById(statementId, parameter);
    }
}
