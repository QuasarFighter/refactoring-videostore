package pl.dominisz.refactoringvideostore.Movies;

import pl.dominisz.refactoringvideostore.Movie;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }

    @Override
    public int getRentalPoints(int daysRented) {
        return 1;
    }
}
