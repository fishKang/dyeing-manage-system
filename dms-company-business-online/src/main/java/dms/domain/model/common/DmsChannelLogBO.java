package dms.domain.model.common;

import lombok.Data;
import org.apache.logging.log4j.Logger;

@Data
public class DmsChannelLogBO {
    private String serialno;
    private String original;
    private Integer status;
    private String input;
    private String output;
    private String indate;
    private String intime;
    private String outdate;
    private String outtime;
    private String operator;
    private String apsservice;
    private Logger logger;
    private boolean regChanLog;
}
