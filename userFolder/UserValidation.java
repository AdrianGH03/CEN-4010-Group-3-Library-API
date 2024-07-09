package com.group_3.restful_group_3_project.userFolder;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.YearMonth;

public class UserValidation {
    
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;

        int atPosition = email.indexOf('@');
        int dotPosition = email.lastIndexOf('.');
        
        return atPosition > 0 && dotPosition > atPosition + 1 && dotPosition < email.length() - 1; //check if email matches <useremailname>@<email>.<domain>
    }

    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty() && username.length() >= 3; //check if username not empty, longer than 3 chars
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8; //check if password not empty, longer than 8 chars
    }



    public static String isValidCreditCard(CreditCard creditCard) {
        if (!isValidCreditCardName(creditCard.getCreditCardName())) {
            return "Invalid credit card name";
        }
        if (!isValidCreditCardNumber(creditCard.getCardNumber())) {
            return "Invalid credit card number";
        }
        if (!isValidExpirationDate(creditCard.getExpirationDate())) {
            return "Invalid expiration date";
        }
        if (!isValidSecurityCode(creditCard.getSecurityCode())) {
            return "Invalid security code";
        }
        if (!isValidCardHolderName(creditCard.getCardHolderName())) {
            return "Invalid card holder name";
        }
        if (!isValidCardProvider(creditCard.getCardProvider())) {
            return "Invalid card provider";
        }
        return "Valid";
    }

    private static boolean isValidCreditCardName (String creditCardName) {
        return creditCardName != null && !creditCardName.trim().isEmpty();
    }
    
    private static boolean isValidCreditCardNumber(String cardNumber) {

       if(cardNumber == null || cardNumber.isEmpty()){
         return false;
       }
       else if (cardNumber.length() < 16 || cardNumber.length() > 19){
          return false;
       }
       for (int i = 0; i < cardNumber.length(); i++) {
           if(!Character.isDigit(cardNumber.charAt(i))){
             return false;
           }
       }
       return true; //check if not empty, 16-19 in length (cuz cards could be this long), all digits

    }
    
    private static boolean isValidExpirationDate(String expirationDate) {
        if (expirationDate == null || expirationDate.trim().isEmpty()) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        try {
            YearMonth expYearMonth = YearMonth.parse(expirationDate, formatter);
            YearMonth currentYearMonth = YearMonth.now();
            
            return !expYearMonth.isBefore(currentYearMonth);
        } catch (DateTimeParseException e) {
            return false;
        }

        //check date follows MM/YY format and is not in future and isnt empty
    }
    
    private static boolean isValidSecurityCode(String securityCode) {
        if(securityCode == null || securityCode.isEmpty()){
            return false;
          }
          else if (securityCode.length() < 3 || securityCode.length() > 4){
             return false;
          }
          for (int i = 0; i < securityCode.length(); i++) {
              if(!Character.isDigit(securityCode.charAt(i))){
                return false;
              }
          }
          return true; //same as card number, but 3-4 digits
        
    }
    
    private static boolean isValidCardHolderName(String cardHolderName) {
        if(cardHolderName == null || cardHolderName.isEmpty()){
            return false;
        }
        for (int i = 0; i < cardHolderName.length(); i++) {
            if(Character.isDigit(cardHolderName.charAt(i))){
              return false;
            }
        }
        return true;  //check if not empty and has no digits in it
    }

    private static boolean isValidCardProvider(String cardProvider){
        String[] providers = {"visa", "mastercard", "american express", "discover", "jcb"};
        if(cardProvider == null || cardProvider.isEmpty()){
            return false;
        }
        for (String provider : providers) {
            if (provider.trim().equals(cardProvider.trim().toLowerCase())) {
                return true;
            }
        }
        return false; //check if not empty and is one of the card providers
    }
}