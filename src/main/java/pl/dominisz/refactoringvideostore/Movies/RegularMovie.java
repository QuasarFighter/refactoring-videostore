package pl.dominisz.refactoringvideostore.Movies;

import pl.dominisz.refactoringvideostore.Movie;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }

    @Override
    public int getRentalPoints(int daysRented) {
        return 1;
    }
}
