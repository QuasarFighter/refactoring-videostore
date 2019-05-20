package pl.dominisz.refactoringvideostore;

import java.util.Enumeration;
import java.util.List;

public class StatementCreator {

    public static String createFor (Customer customer) {
        double 				totalAmount 			= 0;
        int					frequentRenterPoints 	= 0;
        String 				result 					= "Rental Record for " + customer.getName() + "\n";

        for (Rental rental : customer.getRentals()) {
            double thisAmount = rental.getAmount();//getAmountForRental(rental);

            frequentRenterPoints += rental.getRentalPoints();//getRentalPointsForRental(rental);

            result += "\t" + rental.getMovie ().getTitle () + "\t"
                    + String.valueOf (thisAmount) + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + String.valueOf (totalAmount) + "\n";
        result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


        return result;
    }

    /*private static int getRentalPointsForRental(Rental rental){
        int frequentRenterPoints = 1;
        if (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE
                && rental.getDaysRented () > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }*/

    /*private static double getAmountForRental(Rental rental) {
        double thisAmount = 0;
        // determines the amount for each line
        switch (rental.getMovie().getPriceCode ()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented () > 2)
                    thisAmount += (rental.getDaysRented () - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented () * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented () > 3)
                    thisAmount += (rental.getDaysRented () - 3) * 1.5;
                break;
        }
        return thisAmount;
    }*/
}
