package dms.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import dms.domain.valueobject.DmsColorVO;
import dms.domain.valueobject.DmsCraftVO;
import dms.mapper.DmsColorMapper;
import dms.mapper.DmsCraftMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DmsCraftRepository {
    @Autowired
    DmsCraftMapper dmsCraftMapper;

    public void selectCraftList(DmsCraftVO dmsCraftVO , Logger log) {
        dmsCraftVO.getDmsCraftBO().setName("%"+dmsCraftVO.getDmsCraftBO().getName()+"%");
        Map<String,Object> input = BeanUtil.beanToMap(dmsCraftVO.getDmsCraftBO());

        List list =  dmsCraftMapper.selectDmsCraftList(input);
        dmsCraftVO.setDmsCraftList(list);
    }
}
