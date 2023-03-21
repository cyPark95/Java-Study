package segregation;

public class Rental {

    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    private abstract class Movie {
        private int priceCode;

        public abstract int getFrequentRenterPoints(int daysRented);

        public int getPriceCode() {
            return priceCode;
        }
    }

    private class NewReleaseMovie extends Movie {
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return daysRented > 1 ? 2 : 1;
        }
    }

    private class RegularMovie extends Movie {
        @Override
        public int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    }
}
