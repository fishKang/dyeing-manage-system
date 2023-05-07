package dms.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.exceptions.StatefulException;
import dms.common.CodeEnum;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.dto.DmsOperatelog;
import dms.mapper.DmsOperatelogMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DmsOperatelogRepository {
    @Autowired
    DmsOperatelogMapper dmsOperatelogMapper;

    public int insertOperatelog(DmsChannelLogVO dmsChannelLogVO, Logger log){
        try{
            DmsOperatelog dmsOperatelog = new DmsOperatelog();
            BeanUtil.copyProperties(dmsChannelLogVO.getDmsChannelLogBO(),dmsOperatelog);
            BeanUtil.copyProperties(dmsChannelLogVO.getDmsCommonBO(),dmsOperatelog);
            dmsOperatelog.setStatus(1);
            log.info("insertOperatelog入参为："+dmsOperatelog.toString());
            return dmsOperatelogMapper.insert(dmsOperatelog);
        }catch (Exception e){
            throw new StatefulException(Integer.valueOf(CodeEnum.ERR_0100.getCode()), CodeEnum.ERR_0100.getMsg());
        }
    }

    public int updateOperatelog(DmsChannelLogVO dmsChannelLogVO, Logger log){
        try{
            DmsOperatelog dmsOperatelog = new DmsOperatelog();
            BeanUtil.copyProperties(dmsChannelLogVO.getDmsChannelLogBO(),dmsOperatelog);
            BeanUtil.copyProperties(dmsChannelLogVO.getDmsCommonBO(),dmsOperatelog);
            dmsOperatelog.setStatus(2);
            log.info("updateOperatelog入参为："+dmsOperatelog.toString());
            return dmsOperatelogMapper.updateBySerialno(dmsOperatelog);
        }catch (Exception e){
            throw new StatefulException(Integer.valueOf(CodeEnum.ERR_0101.getCode()), CodeEnum.ERR_0101.getMsg());
        }
    }
}
