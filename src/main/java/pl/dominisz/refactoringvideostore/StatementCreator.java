package pl.dominisz.refactoringvideostore;

import java.util.Enumeration;
import java.util.List;

public class StatementCreator {

    public static String createFor (Customer customer) {
        double 				totalAmount 			= 0;
        int					frequentRenterPoints 	= 0;
        String 				result 					= "Rental Record for " + customer.getName() + "\n";

        for (Rental each : customer.getRentals()) {
            double 		thisAmount = 0;

            // determines the amount for each line
            switch (each.getMovie().getPriceCode ()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented () > 2)
                        thisAmount += (each.getDaysRented () - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented () * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented () > 3)
                        thisAmount += (each.getDaysRented () - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE
                    && each.getDaysRented () > 1)
                frequentRenterPoints++;

            result += "\t" + each.getMovie ().getTitle () + "\t"
                    + String.valueOf (thisAmount) + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + String.valueOf (totalAmount) + "\n";
        result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


        return result;
    }
}
