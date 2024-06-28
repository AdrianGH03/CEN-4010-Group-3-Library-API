package com.group_3.restful_group_3_project.userFolder;

public class UserValidation {
    
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;

        int atPosition = email.indexOf('@');
        int dotPosition = email.lastIndexOf('.');
        
        return atPosition > 0 && dotPosition > atPosition + 1 && dotPosition < email.length() - 1; //check if email matches <useremailname>@<email>.<domain>
    }

    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() >= 3;
    }

    public static boolean isValidPassword(String password) {
        // Implement your own password policy here
        return password != null && password.length() >= 8;
    }
}