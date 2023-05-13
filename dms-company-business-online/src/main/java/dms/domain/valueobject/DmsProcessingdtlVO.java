package dms.domain.valueobject;

import dms.domain.model.DmsProcessingdtlBO;
import dms.domain.model.common.DmsCommonBO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DmsProcessingdtlVO {
    private DmsCommonBO dmsCommonBO;
    private DmsProcessingdtlBO dmsProcessingdtlBO;
    private List<Map> dmsProcessingdtlBOList;
}
