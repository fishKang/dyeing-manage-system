package dms.domain.service;

import dms.domain.model.user.DmsUserBO;
import org.apache.logging.log4j.Logger;

public interface IUserService {
    public DmsUserBO userRegister(DmsUserBO DmsUserBO, Logger log);
    public int userCreate(DmsUserBO DmsUserBO, Logger log);
    public int userUpdate(DmsUserBO DmsUserBO, Logger log);
    public int userDelete(DmsUserBO DmsUserBO, Logger log);
    public DmsUserBO userSelete(DmsUserBO DmsUserBO, Logger log);
}
