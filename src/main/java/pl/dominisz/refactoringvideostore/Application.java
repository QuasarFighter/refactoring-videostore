package pl.dominisz.refactoringvideostore;

public class Application {

    public static void main(String[] args) {
        Customer customer = new Customer("Adam Nowak");

        String statement = StatementCreator.createFor(customer);
        System.out.println(statement);
    }
}
