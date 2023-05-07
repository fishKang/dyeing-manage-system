package dms.domain.service.impl;

import dms.domain.model.user.DmsUserBO;
import dms.domain.service.IUserService;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public DmsUserBO userRegister(DmsUserBO DmsUserBO, Logger log) {
        return null;
    }

    @Override
    public int userCreate(DmsUserBO DmsUserBO, Logger log) {
        return 0;
    }

    @Override
    public int userUpdate(DmsUserBO DmsUserBO, Logger log) {
        return 0;
    }

    @Override
    public int userDelete(DmsUserBO DmsUserBO, Logger log) {
        return 0;
    }

    @Override
    public DmsUserBO userSelete(DmsUserBO DmsUserBO, Logger log) {
        return null;
    }
}
