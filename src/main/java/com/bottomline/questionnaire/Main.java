package com.bottomline.questionnaire;

import com.bottomline.questionnaire.exception.PaymentException;
import com.bottomline.questionnaire.exception.PriceException;
import com.bottomline.questionnaire.model.Result;
import com.bottomline.questionnaire.util.Calculate;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Sore the price given by user
        String price;
        // Store the payments given by user
        Long payments;

        try {
            if (args.length == 0) {
                throw new PriceException("Please type a valid price number.");
            } else if (args.length == 1){
                throw new PaymentException("Please type a valid payment number;.");
            }

            // Get price from first input argument
            price = args[0];
            // Get payments from second input argument
            payments = Long.parseLong(args[1]);

            // Calculate the amount with the calculate method and store it to returnAmount
            Result returnAmount = Calculate.calculate(price, payments);
            System.out.println(returnAmount);
        } catch (InputMismatchException | PriceException | PaymentException e) {
            System.out.println(e);
        }

    }
}
