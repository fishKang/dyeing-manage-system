package dms.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import dms.domain.valueobject.DmsUserVO;
import dms.dto.DmsUser;
import dms.mapper.DmsUserMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sql.util.SqlExecutor;

import java.util.Date;
import java.util.Map;

@Repository
public class DmsUserRepository {
    @Autowired
    DmsUserMapper dmsUserMapper;

    public DmsUser selectForUserRegister(DmsUserVO dmsUserVO , Logger log) {
        Map<String,Object> queryMap = BeanUtil.beanToMap(dmsUserVO.getDmsUserBO());
        return dmsUserMapper.selectForUserRegister(queryMap);
    }

    public int insertForUserRegister(DmsUserVO dmsUserVO ,Logger log) {
        DmsUser dmsUser = new DmsUser();
        BeanUtil.copyProperties(dmsUserVO.getDmsUserBO(),dmsUser);
        dmsUser.setStatus(0);
        dmsUser.setCreatedate(DateUtil.today());
        dmsUser.setCreatetime(DateUtil.formatTime(new Date()));
        dmsUser.setOperator(dmsUser.getName());
//        return SqlExecutor.insert(log,"dms.mapper.DmsUserMapper.insertSelective",dmsUser);
        return dmsUserMapper.insertSelective(dmsUser);
    }
}
