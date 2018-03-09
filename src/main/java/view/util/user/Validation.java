/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.util.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Eman-PC
 */
public class Validation {

    public boolean validateName(String name) {
        boolean validName = false;
        if (!name.isEmpty() && name.length() <= 100 && Pattern.compile("^[a-zA-Z]+([ ][a-zA-Z]*)*$").matcher(name).matches()) {
            validName = true;
        }
        return validName;
    } 

    public boolean validateCreditLimit(String creditLimit) {
        
        int credit = Integer.parseInt(creditLimit);
        boolean validcreditLimit = false;
        if (credit >= 0) {
            validcreditLimit = true;
        }
        return validcreditLimit;
    }

    public boolean validatePassword(String password, String confirmPassword) {
        boolean validPassword = false;
        if (!password.isEmpty() && password.equals(confirmPassword) && password.length() <= 50) {
            validPassword = true;
        }
        return validPassword;
    }

    public boolean validateEmail(String email) {

        boolean validEmail = false;
        if (!email.isEmpty() && email.length() <= 50
                && Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(email).matches()) {
            validEmail = true;
        }
        return validEmail;
    }

    public boolean validateAddress(String address) {
        boolean validAddress = false;
        if (!address.isEmpty() && address.length() <= 70) {
            validAddress = true;
        }
        return validAddress;
    }

    public void validateJob(String job) {

    }

    public boolean validateDate(String date) {
        boolean validDate = false;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date enteredDate = formatter.parse(date);
            if (enteredDate.before(formatter.parse("2000-02-28"))) {
                validDate = true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error in validating date");
        }
        return validDate;
    }
}
