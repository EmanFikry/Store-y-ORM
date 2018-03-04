/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.util.user;

import java.util.regex.Pattern;

/**
 *
 * @author Ghada
 */
public class ProductValidation {

    public boolean validateName(String name) {
        boolean validName = false;
        if (!name.isEmpty() && name.length() <= 50 && Pattern.compile("^[a-zA-Z]+([ ][a-zA-Z]*)*$").matcher(name).matches()) {
            validName = true;
        }
        return validName;
    }

    public boolean validatePrice(String price) {
        boolean validPrice = false;
        float productPrice = Float.parseFloat(price);
        if (productPrice > 0) {
            validPrice = true;
        }
        return validPrice;
    }

    public boolean validateCategory(String category) {
        boolean validCategory = false;
        if (!category.isEmpty() && category.length() <= 50 && Pattern.compile("^[a-zA-Z]+([ ][a-zA-Z]*)*$").matcher(category).matches()) {
            validCategory = true;
        }
        return validCategory;
    }

    public boolean validateAmount(String amount) {
        boolean validAmount = false;
        int productAmount = Integer.parseInt(amount);
        if (productAmount >= 0) {
            validAmount = true;
        }
        return validAmount;
    }

    public boolean validateImgURL(String imgURL) {
        boolean validImgURL = false;
        if (!imgURL.isEmpty() && imgURL.length() <= 100) {
            validImgURL = true;
        }
        return validImgURL;
    }

    public boolean validateDescription(String description) {
        boolean validDescription = false;
        if (!description.isEmpty() && description.length() <= 200) {
            validDescription = true;
        }
        return validDescription;
    }

}
