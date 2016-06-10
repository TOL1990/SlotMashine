package com.spalah.cources.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Тарас on 10.06.2016.
 */
public class RegEx {
    private final static String LOGIN_RULE = "^[a-zA-Z]+[a-zA-Z0-9]+$";
    public static boolean nickChek(String nickName) {
        Pattern p = Pattern.compile(LOGIN_RULE);
        Matcher m = p.matcher(nickName);
        return m.matches();
    }
}
