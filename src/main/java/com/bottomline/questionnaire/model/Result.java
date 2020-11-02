package com.bottomline.questionnaire.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Getter
@Setter
public class Result {

    private NumberFormat numberFormat;
    private BigDecimal regularAmount;
    private BigDecimal lastAmount;

    public Result(BigDecimal regularAmount, BigDecimal lastAmount) {
        this.regularAmount = regularAmount;
        this.lastAmount = lastAmount;
        numberFormat = NumberFormat.getCurrencyInstance(Locale.UK);
    }

    @Override
    public String toString() {
        if (getLastAmount().equals(getRegularAmount())) {
            return "Regular amount: " + numberFormat.format(getRegularAmount());
        } else {
            return "Regular amount: " + numberFormat.format(getRegularAmount()) + "\n" +
                    "Last amount: " + numberFormat.format(getLastAmount());
        }
    }
}
