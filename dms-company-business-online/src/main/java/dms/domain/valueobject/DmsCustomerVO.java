package dms.domain.valueobject;

import dms.domain.model.DmsCustomerBO;
import dms.domain.model.common.DmsCommonBO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DmsCustomerVO {
    private DmsCommonBO dmsCommonBO;
    private DmsCustomerBO dmsCustomerBO;
    private List<Map> dmsCustomerList;
}
