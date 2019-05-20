package pl.dominisz.refactoringvideostore;

import org.junit.Assert;
import org.junit.Test;
import pl.dominisz.refactoringvideostore.Movies.ChildrenMovie;
import pl.dominisz.refactoringvideostore.Movies.NewReleaseMovie;
import pl.dominisz.refactoringvideostore.Movies.RegularMovie;

import static org.junit.Assert.*;

public class CustomerTest {

    @org.junit.Test
    public void simpleStatement() {
        Customer customer = new Customer("Adam Nowak");
        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "You owed 0.0\n" +
                "You earned 0 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        assertEquals(expectedStatement, actualStatement);
    }

    //todo parametrized test for three tests of three types of movie

    @Test
    public void shouldCreateStatementWithRegularMovie(){
        Customer customer = new Customer("Adam Nowak");
        customer.addRental(new Rental(new RegularMovie("movie1"), 10));

        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "\tmovie1\t14.0\n"+
                "You owed 14.0\n" +
                "You earned 1 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldCreateStatementWithNewReleaseMovie(){
        Customer customer = new Customer("Adam Nowak");
        customer.addRental(new Rental(new NewReleaseMovie("movie2"), 20));

        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "\tmovie2\t60.0\n"+
                "You owed 60.0\n" +
                "You earned 2 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldCreateStatementWithChildrensMovie(){
        Customer customer = new Customer("Adam Nowak");
        customer.addRental(new Rental(new ChildrenMovie("movie3"), 30));

        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "\tmovie3\t42.0\n"+
                "You owed 42.0\n" +
                "You earned 1 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldCreateStatementWithThreeMovies(){
        Customer customer = new Customer("Adam Nowak");
        customer.addRental(new Rental(new RegularMovie("movie1"), 10));
        customer.addRental(new Rental(new NewReleaseMovie("movie2"), 20));
        customer.addRental(new Rental(new ChildrenMovie("movie3"), 30));

        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "\tmovie1\t14.0\n"+
                "\tmovie2\t60.0\n"+
                "\tmovie3\t42.0\n"+
                "You owed 116.0\n" +
                "You earned 4 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        assertEquals(expectedStatement, actualStatement);
    }
}