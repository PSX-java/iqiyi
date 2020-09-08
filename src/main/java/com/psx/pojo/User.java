package com.psx.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int Usersid;
    private String username;
    private String pass;
    private String sex;

    public int getUsersid() {
        return Usersid;
    }

    public void setUsersid(int usersid) {
        Usersid = usersid;
    }
}
