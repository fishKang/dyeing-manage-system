package dms.domain.valueobject;

import dms.domain.model.DmsCraftBO;
import dms.domain.model.common.DmsCommonBO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DmsCraftVO {
    private DmsCommonBO dmsCommonBO;
    private DmsCraftBO dmsCraftBO;
    private List<Map> dmsCraftList;
}
