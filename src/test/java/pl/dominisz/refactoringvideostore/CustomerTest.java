package pl.dominisz.refactoringvideostore;

import org.junit.Assert;

import static org.junit.Assert.*;

public class CustomerTest {

    @org.junit.Test
    public void statement() {
        Customer customer = new Customer("Adam Nowak");
        String expectedStatement = "Rental Record for Adam Nowak\n" +
                "You owed 0.0\n" +
                "You earned 0 frequent renter points\n";
        String actualStatement = StatementCreator.createFor(customer);

        Assert.assertEquals(expectedStatement, actualStatement);
    }
}