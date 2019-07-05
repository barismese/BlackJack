

public class Shoe {

    final static int DECK_SIZE = 52;
    final static int SHOE_SIZE = 312;
      
    private Card[] cards1;
    private Card[] cards;
    private int N = 0;
    private int U = 0;
    

    public Shoe() {
        cards1 = new Card[DECK_SIZE];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards1[N] = new Card( j, i + "" + j + ".png");
                N++;
            }
        }
        
      cards = new Card[SHOE_SIZE];
      for ( int w = 0; w < 6; w++){
         int O = 0;
        for( int t = 0; t < 4; t++){
        for( int e = 0; e < 13; e++){  
          cards[U] = cards1[O];
          U++;
          O++;
      }
      }
    }
    }

    public Card dealFrom() {
        return cards[--U];
    }

    public boolean isEmpty() {
        return (U == 0);
    }

    public int size() {
        return U;
    }
    

    public void shuffle() {
        for (int i = 0; i < U; i++) {
            int r = (int) (Math.random() * i);
            Card swap = cards[i];
            cards[i] = cards[r];
            cards[r] = swap;
        }
    }
}
