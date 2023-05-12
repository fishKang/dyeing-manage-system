package dms.domain.valueobject;

import dms.domain.model.common.DmsCommonBO;
import dms.domain.model.DmsUserBO;
import lombok.Data;

@Data
public class DmsUserVO {
    private DmsCommonBO dmsCommonBO;
    private DmsUserBO dmsUserBO;
}
