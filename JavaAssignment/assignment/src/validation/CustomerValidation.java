package validation;

import entity.Customer;
import exception.DuplicatePhoneNumberException;
import exception.InvalidEmailException;
import exception.InvalidPhoneNumberException;
import exception.NullOrEmptyFieldException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomerValidation {

    public static void validateCustomer(String name, String email, String phoneNumber, Map<String,Customer> customerMap) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new NullOrEmptyFieldException("Name cannot be null or empty.\n");
        }

        if (email == null || !email.matches("^[a-z]+[0-9]{1,12}+@([a-z]+.)+[a-z]{2,4}$")) {
            throw new InvalidEmailException("Invalid email format.\n" + ". Please enter a valid email format (e.g., user123@example.com).");
        }

        if (phoneNumber == null || !phoneNumber.matches("[0-9]{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be 10 digits.\n ");
        }

        if (isPhoneNumberDuplicate(phoneNumber, customerMap)) {
            throw new DuplicatePhoneNumberException("Phone number already exists.");
        }
    }

    private static boolean isPhoneNumberDuplicate(String phoneNumber, Map<String,Customer> customerMap) {
        Set<String> existingPhoneNumbers = new HashSet<>();
        for(String keyPhoneNumber : customerMap.keySet()){
            existingPhoneNumbers.add(keyPhoneNumber);
        }
        return existingPhoneNumbers.contains(phoneNumber);
    }
}

