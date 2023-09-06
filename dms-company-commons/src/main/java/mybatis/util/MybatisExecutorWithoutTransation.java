package mybatis.util;

import exception.DatabaseException;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;

public class MybatisExecutorWithoutTransation extends AbstractMybatisExecutor{
    private SqlSession session;
    public MybatisExecutorWithoutTransation() {
        this.setFactoryType("");
    }
    public MybatisExecutorWithoutTransation(String factoryType) {
        this.setFactoryType(factoryType);
    }

    @Override
    public <T> T selectOne(String statementId, Object parameter) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try {
            T t=this.session.selectOne(statementId,parameter);
            return t;
        } catch (RuntimeException var4) {
            throw this.seprateSqlException(var4);
        }

    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try {
            List<E> e = this.session.selectList(statementId, parameter);
            return e;
        } catch (RuntimeException var4) {
            throw this.seprateSqlException(var4);
        }

    }

    @Override
    public <E> List<E> seLectList(String statementId, String... parameter) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object parameter, int offset, int limit) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try{
            RowBounds rowBounds = new RowBounds(offset,limit);
            List<E> e = this.session.selectList(statementId, parameter, rowBounds);
            return e;
        } catch (RuntimeException var7) {
            throw this.seprateSqlException(var7);
        }
    }

    @Override
    public int insert(String statementId, Object parameter) {
        if(this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try {
            int i = this.session.insert(statementId,parameter);
            return i;
        } catch (RuntimeException var4) {
            throw this.seprateSqlException(var4);
        }
    }

    @Override
    public int update(String statementId, Object parameter) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try {
            int i = this.session.update(statementId, parameter);
            return i;
        } catch (RuntimeException var4) {
            throw this.seprateSqlException(var4);
        }
    }

    @Override
    public int delete(String statementId, Object parameter) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        try {
            int i = this.session.delete(statementId, parameter);
            return i;
        } catch (RuntimeException var4) {
            throw this.seprateSqlException(var4);
        }
    }

    @Override
    public void commit() {
    }

    @Override
    public void rollback() {
    }

    @Override
    public void close() {
    }

    @Override
    public Savepoint savepoint(String statementId) {
        throw new DatabaseException("No Savepoint Function");
    }

    @Override
    public void rollback(Savepoint statementId) {

    }

    @Override
    public ResultSet openCursor(String statementId, Object parameter) {
        throw new DatabaseException("No openCursor Function");
    }

    @Override
    public ResultSet openCursorKV(String statementId, String... parameter) {
        throw new DatabaseException("No openCursorKV Function");
    }

    @Override
    public ResultSet openCursor(String statementId, String... parameter) {
        throw new DatabaseException("No openCursor Function");
    }

    @Override
    public String getStatementById(String statementId) {
        String result = "";
        try {
            if (this.session ==null) {
                this.session = this.getSqlSession(true);
            }
            result = this.session.getConfiguration().getMappedStatement(statementId).getBoundSql((Object)null).getSql();
        } catch(Exception var4){
            this.logger.error("getStatementById时发生未知异常.…", var4);
        }
        return result;
    }

    @Override
    public String getStatementById(String statementId, Object parameter) {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        return this. session.getConfiguration().getMappedStatement(statementId).getBoundSql(parameter).getSql();
    }

    @Override
    public String getStatementById(String statementId, String... parameter) {
        return null;
    }

    @Override
    public Connection getConnection() {
        if (this.session == null) {
            this.session = this.getSqlSession(true);
        }
        Connection conn = this.session.getConnection();
        return conn;
    }

    @Override
    public String getURL(Logger log) {
        this.session = this.getSqlSession(true);
        Connection conn = this.getConnection();
        try{
            if(conn != null) {
                String var3 = conn.getMetaData().getURL();
                return var3;
            }
        } catch (SQLException var14) {
            log.error("MybatisExecutorWithTransation connction infor String fail!");
        }finally{
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException var13) {
                }
            }
            this.close();
        }
        return null;
    }
}
