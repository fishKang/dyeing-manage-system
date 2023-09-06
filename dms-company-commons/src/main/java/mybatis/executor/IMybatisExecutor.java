package mybatis.executor;

import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.List;

public interface IMybatisExecutor {
    <T> T selectOne(String var1, Object var2);
    <T> T selectOne(String var1, String... var2);
    <E> List<E> selectList(String var1, Object var2);
    <E> List<E> seLectList(String var1, String... var2);
    <E> List<E> selectList(String var1, Object var2, int var3, int var4);
    int insert(String var1, Object var2);
    int insert(String varl, String... var2);
    int update(String var1,Object var2);
    int update(String var1, String... var2);
    int delete(String varl, Object var2);
    int delete(String var1, String... var2);
    void commit();
    void rollback();
    void close();
    Savepoint savepoint(String var1);
    void rollback(Savepoint var1);
    ResultSet openCursor(String var1, Object var2);
    ResultSet openCursorKV(String var1, String... var2);
    ResultSet openCursor(String var1, String... var2);
    String getStatementById(String var1);
    String getStatementById(String var1, Object var2);
    String getStatementById(String var1, String... var2);
    Connection getConnection();
    String getURL(Logger var1);
}
