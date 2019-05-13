package pl.dominisz.refactoringvideostore;

// This file is the original program.  It has been left here so you can compare it with the refactored version.
import java.util.*;

public class Customer 
{

	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add (rental);
	}
	
	public String getName () {
		return name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}
}
