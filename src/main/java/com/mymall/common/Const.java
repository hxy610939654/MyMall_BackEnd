package com.mymall.common;

import org.apache.commons.lang3.StringUtils;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0;//User
        int ROLE_ADMIN = 1;//Administrator
    }
}
