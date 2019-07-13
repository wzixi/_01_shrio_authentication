package com.qf.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;

public class MyJdbcRealm extends JdbcRealm {
    public MyJdbcRealm(){
        setSaltStyle(SaltStyle.COLUMN);
    }
}
