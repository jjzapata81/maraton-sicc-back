package com.tns.maraton.validators;

import static java.lang.Character.isDigit;

public class ValidateUser {

    public boolean isNotNull(String user) {
        return null != user;
    }

    public boolean size(String user) {
        int size = user.length();
        if (size >= 3 && size <= 15) return true;
        else return false;
    }

    public boolean existUser(String user, String[] users) {
        for (int n = 0; n < users.length; n++) {
            if (user == users[n]) return true;
        }
        return false;
    }

    public boolean haveNumber(String user) {
        for (int n = 0; n < user.length(); n++) {
            if (Character.isDigit(user.charAt(n))) return true;
        }
        return false;
    }

    public boolean haveSpacing(String user) {
        for (int n = 0; n < user.length(); n++) {
            if (user.charAt(n)==' ') return true;
        }
        return false;
    }
}
