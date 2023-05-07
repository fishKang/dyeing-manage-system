package dms.controller.service;

import java.util.Map;

public interface IService {
    public Map<String, Object> invoke(Map<String, Object> inputMap);
}
