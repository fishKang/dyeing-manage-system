package dms.domain.valueobject;

import dms.domain.model.DmsColorBO;
import dms.domain.model.common.DmsCommonBO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DmsColorVO {
    private DmsCommonBO dmsCommonBO;
    private DmsColorBO dmsColorBO;
    private List<Map> dmsColorList;
}
