package services;

import entity.Amount;
import library.BookLendingRecord;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FeeService {


    public static final String CURRENCY = "INR";
    public static final Long DAY = 24*60*60L;
    public static final Long RATE= 10L;
    Logger logger = Logger.getLogger(FeeService.class.getName());
    //If book is not returned yet calculate fees till now;
    public Amount amountCalculateFees(BookLendingRecord bookLendingRecord) {
        Amount amount = new Amount();
        amount.setCurrencyCode(CURRENCY);
        if (bookLendingRecord != null) {
            long initiatedTime = bookLendingRecord.getInitiatedTime();
            long returnedBookTime = bookLendingRecord.getReturnedTime();
            if (returnedBookTime == 0) {
                returnedBookTime = System.currentTimeMillis();
            }
            double days =  (Math.ceil(returnedBookTime-initiatedTime) / DAY);
            amount.setAmount(days*RATE);
        }
        logger.log(Level.INFO, String.valueOf(amount));
        return amount;
    }
}
