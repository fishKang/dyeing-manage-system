package dms.domain.model.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class DmsCommonBO implements Serializable {
    private int zoneno;
    private String service;
    private String method;
    private String logtype;
    private String department;
    private String workdate;
    private String worktime;
    private String request;
    private String response;
}
