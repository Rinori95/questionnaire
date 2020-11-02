package com.bottomline.questionnaire.util;

import com.bottomline.questionnaire.exception.PaymentException;
import com.bottomline.questionnaire.exception.PriceException;
import com.bottomline.questionnaire.model.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {

    /**
     * Calculate the amount by giving price and number of payments
     *
     * @param price String
     * @param payments Long
     *
     * @return The result after calculation
     *
     * @throws PriceException
     * @throws PaymentException
     */
    public static Result calculate(String price, Long payments) throws PriceException, PaymentException{

        BigDecimal totalPrice = new BigDecimal(price);

        // Check if price is less or equal to zero
        if (totalPrice.compareTo(BigDecimal.valueOf(0)) <= 0){
            // Throw exception if price is less or equal to zero
            throw new PriceException("The price is less or equal to 0");
        }

        // Check if payments is less or equal to zero
        if (payments <= 0) {
            // Throw exception if payments is less or equal to zero
            throw new PaymentException("The payment is less or equal to 0");
        }

        // Divide price and payments
        BigDecimal regularAmount = totalPrice.divide(new BigDecimal(payments), 2, RoundingMode.DOWN);

        // Store the latest value of price by multiplying the price to payment - 1, to help us to find the latest amount
        BigDecimal lastPrice = regularAmount.multiply(new BigDecimal(--payments));

        return new Result(regularAmount,  totalPrice.subtract(lastPrice));
    }
}
