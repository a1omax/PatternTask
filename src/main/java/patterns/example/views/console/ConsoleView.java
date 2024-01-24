package patterns.example.views.console;

import patterns.example.customers.Customer;
import patterns.example.rentals.Rental;
import patterns.example.views.CustomerRentalRecordView;

public class ConsoleView implements CustomerRentalRecordView {
    @Override
    public String generateRecordOutput(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rental Record for ").append(customer.getName()).append("\n");
        for (Rental each : customer.getRentals()) {
            sb.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(each.getDaysRented())
                    .append("\n");
        }
        //add footer lines
        sb.append("Amount owed is ").append(customer.getTotalAmount()).append("\n");
        sb.append("You earned ").append(customer.getFrequentRenterPoints()).append(" frequent renter points");
        return sb.toString();
    }
}
