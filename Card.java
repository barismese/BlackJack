

public class Card {


    private int rank;
    private String image;

    Card( int rank, String image) {
      
        this.rank = rank;
        this.image = image;
    }

    public boolean isAce() {
        return rank == 0;
    }

    public int rank() {
        if (rank == 0) {
            return 1;
        }
        if (rank >= 9) {
            return 10;
        }
        return rank + 1;
    }

    public String toString() {
        return this.image;
    }
}
