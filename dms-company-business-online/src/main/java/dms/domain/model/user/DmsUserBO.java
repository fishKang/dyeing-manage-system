package dms.domain.model.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class DmsUserBO implements Serializable {
    int id;
    String name;
    String password;
    String permission;
}
