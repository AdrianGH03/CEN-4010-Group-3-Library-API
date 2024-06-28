package com.group_3.restful_group_3_project.userFolder;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor // Lombok annotation to create a no args constructor
@AllArgsConstructor // Lombok annotation to create a all args constructor

public class CreditCard {
    @Id
    private String creditCardName;
    
    private String cardNumber;
    private String expirationDate;
    private String securityCode;
    private String cardHolderName;
    private String cardType;
    private String cardProvider;
}
