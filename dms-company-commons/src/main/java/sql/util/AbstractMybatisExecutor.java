package sql.util;

import exception.DatabaseException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.util.SpringUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMybatisExecutor implements IMybatisExecutor{
    private SqlSessionFactory sqlSessionFactory;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    String factoryType = "";

    public AbstractMybatisExecutor(){

    }
    protected SqlSession getSqlSession(boolean autoCommit) {
         if (this.sqlSessionFactory == null) {
            if ("".equals(this.factoryType)) {
                this.sqlSessionFactory = (SqlSessionFactory) SpringUtil.getBean("sqlSessionFactory");
            } else {
                this.sqlSessionFactory = (SqlSessionFactory) SpringUtil.getBean("sqlSessionFactory_" + this.factoryType);
            }
        }
        return this.sqlSessionFactory.openSession(autoCommit);
    }
    protected RuntimeException seprateSqlException(RuntimeException runEx) {
        this.logger.error (runEx.getMessage());
        runEx.printStackTrace();
        return (RuntimeException)(runEx.getCause() instanceof SQLException ? this.handleSQLException((SQLException)runEx.getCause(), runEx) : new DatabaseException(runEx.getMessage(), runEx));
    }

    protected RuntimeException handleSQLException(SQLException sqlEx, Throwable e) {
        this.logger.error(sqlEx.getMessage());
        DatabaseException dbEx = new DatabaseException(sqlEx.getMessage(), e);
        dbEx.setSqlCode(sqlEx.getErrorCode());
        dbEx.setSqlState(sqlEx.getSQLState());
        dbEx.printStackTrace();
        return dbEx;
    }

    public <T> T selectOne(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.selectOne(statementId, parameter);
    }
    public int insert(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.insert(statementId, parameter);
    }
    public int update(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.update(statementId, parameter);
    }
    public int delete(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.delete(statementId, parameter);
    }
    public ResultSet openCursorkV(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.openCursor(statementId, parameter);
    }
    public String getStatementById(String statementId, String... parameters) {
        Map<String, String> parameter = this.parse(parameters);
        return this.getStatementById(statementId, parameters);
    }
    private Map<String, String> parse(String... parameters) {
        if (parameters == null) {
            return null;
        } else {
            Map<String, String> parameter = new HashMap();
            String name = null;
            String value = null;
            for (int i = 0; i < parameters.length; ++i) {
                if (i % 2 == 0) {
                    name = parameters[i];
                } else {
                    value = parameters[i];
                    parameter.put(name, value);
                }
            }
            return parameter;
        }
    }

    public String getFactoryType() {
        return this.factoryType;
    }

    public void setFactoryType(String factoryType){
        this.factoryType = factoryType;
    }
}
