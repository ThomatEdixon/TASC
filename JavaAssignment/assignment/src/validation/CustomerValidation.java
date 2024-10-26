package validation;

import entity.Customer;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerValidation {
    public static boolean validateName(String name){
        if (name == null || name.isEmpty()) {
            return false;
        }
        return true;
    }
    public static boolean validateEmail(String email){
        if (email == null || !email.matches("^[a-z]+[0-9]{1,12}+@([a-z]+.)+[a-z]{2,4}$")) {

            return false;
        }
        return true;
    }
    public static boolean validatePhoneNumber(String phoneNumber){
        if (phoneNumber == null || !phoneNumber.matches("[0-9]{10}")) {
            return false;
        }

        return true;
    }
    public static boolean validateDuplicate(String phoneNumber,Map<String,Customer> customerMap){
        if (isPhoneNumberDuplicate(phoneNumber, customerMap)) {
            return false;
        }
        return true;
    }

    private static boolean isPhoneNumberDuplicate(String phoneNumber, Map<String,Customer> customerMap) {
        Set<String> existingPhoneNumbers = new HashSet<>();
        for(String keyPhoneNumber : customerMap.keySet()){
            existingPhoneNumbers.add(keyPhoneNumber);
        }
        return existingPhoneNumbers.contains(phoneNumber);
    }
}

