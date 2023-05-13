package dms.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import dms.domain.valueobject.DmsCustomerVO;
import dms.domain.valueobject.DmsProcessingdtlVO;
import dms.dto.DmsExample;
import dms.dto.DmsProcessingdtl;
import dms.mapper.DmsProcessingdtlMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class DmsProcessingdtlRepository {
    @Autowired
    DmsProcessingdtlMapper dmsProcessingdtlMapper;

    public int addProcessingdtl(DmsProcessingdtlVO dmsProcessingdtlVO , Logger log) {
        DmsProcessingdtl dmsProcessingdtl = new DmsProcessingdtl();
        BeanUtil.copyProperties(dmsProcessingdtlVO.getDmsProcessingdtlBO(),dmsProcessingdtl);
        dmsProcessingdtl.setStatus(0);
        dmsProcessingdtl.setCreatedate(DateUtil.today());
        dmsProcessingdtl.setCreatetime(DateUtil.formatTime(new Date()));
        return dmsProcessingdtlMapper.insert(dmsProcessingdtl);
    }

    public void selectProcessingdtlList(DmsProcessingdtlVO dmsProcessingdtlVO , Logger log) {
        Map<String,Object> input = BeanUtil.beanToMap(dmsProcessingdtlVO.getDmsProcessingdtlBO());
        List list =  dmsProcessingdtlMapper.selectProcessingdtlList(input);
        dmsProcessingdtlVO.setDmsProcessingdtlBOList(list);
    }

    public int updateProcessingdtl(DmsProcessingdtlVO dmsProcessingdtlVO , Logger log) {
        DmsProcessingdtl dmsProcessingdtl = new DmsProcessingdtl();
        BeanUtil.copyProperties(dmsProcessingdtlVO.getDmsProcessingdtlBO(),dmsProcessingdtl);

        return dmsProcessingdtlMapper.updateDmsProcessingdtl(dmsProcessingdtl);
    }
}
