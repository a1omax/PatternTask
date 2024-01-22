package patterns.example.views.html;

import patterns.example.Customer;
import patterns.example.Rental;

public class HtmlView implements CustomerRentalRecordView {

    @Override
    public String generateRecordOutput(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Rental Record for\s""")
                .append(customer.getName())
                .append("""
                </title>
                </head>
                <body>
                    <h1>Rental Record for\s""")
                .append(customer.getName())
                .append("""
                        </h1>
                            <ul>""");
        for (Rental each : customer.getRentals()) {
            sb.append("<li>")
                    .append(each.getMovie().getTitle())
                    .append(" - ")
                    .append(each.getMovie().getMovieType().getAmount(each.getDaysRented()))
                    .append("</li>\n");
        }
        sb.append("""
                </ul>
                   \s
                    <p>Amount owed is <strong>""")
                .append(customer.getTotalAmount())
                .append("""
                        </strong></p>
                            <p>You earned <strong>""")
                .append(customer.getFrequentRenterPoints())
                .append("""
                        </strong> frequent renter points</p>
                                                
                        </body>
                        </html>""");
        return sb.toString();
    }
}
