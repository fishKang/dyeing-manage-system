package dms.domain.valueobject;

import dms.domain.model.common.DmsChannelLogBO;
import dms.domain.model.common.DmsCommonBO;
import lombok.Data;

@Data
public class DmsChannelLogVO {
    private DmsCommonBO dmsCommonBO;
    private DmsChannelLogBO dmsChannelLogBO;
}
