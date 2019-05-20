package pl.dominisz.refactoringvideostore.Movies;

import pl.dominisz.refactoringvideostore.Movie;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getRentalPoints(int daysRented) {
        if(daysRented < 2){
            return 1;
        }
        return 2;
    }
}
