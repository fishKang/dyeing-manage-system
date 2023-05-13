package dms.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import dms.domain.valueobject.DmsColorVO;
import dms.domain.valueobject.DmsCustomerVO;
import dms.dto.DmsExample;
import dms.mapper.DmsColorMapper;
import dms.mapper.DmsCustomerMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DmsColorRepository {
    @Autowired
    DmsColorMapper dmsColorMapper;

    public void selectCustomerList(DmsColorVO dmsColorVO , Logger log) {
        dmsColorVO.getDmsColorBO().setName("%"+dmsColorVO.getDmsColorBO().getName()+"%");
        Map<String,Object> input = BeanUtil.beanToMap(dmsColorVO.getDmsColorBO());

        List list =  dmsColorMapper.selectDmsColorList(input);
        dmsColorVO.setDmsColorList(list);
    }
}
