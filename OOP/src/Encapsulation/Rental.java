package Encapsulation;

public class Rental {

    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    private static class Movie {
        public static int REGULAR = 0;
        public static int NEW_RELEASE = 1;
        private int priceCode;

        public int getFrequentRenterPoints(int daysRented) {
            if (priceCode == Movie.NEW_RELEASE && daysRented > 1)
                return 2;
            else
                return 1;
        }

        public int getPriceCode() {
            return priceCode;
        }
    }
}
