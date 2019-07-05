public class Player {

    final static int MAX_CARDS = 312;
    public Card[] cards = new Card[MAX_CARDS];
    private int N = 0;
    private String name;
    private int balance;
    private int betamount;
    private String current;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

     public Card dealTo(Card c) {
        cards[N++] = c;
        return c;
    }
    
      public void betseata(int betamount) {
      
     this.balance = balance - betamount; 
      
      }
      
      public void betseatb (int betamount) {
        
        this.balance = balance - betamount; 
        
      }
      
      public void betseatc (int betamount) {
        
        this.balance = balance - betamount; 
        
      }
      
      
    
    public void returnBet( int betamount){
      
     this.balance = balance + betamount; 
    }
    
    public void addWinnings(int betamount) {
      
      this.balance = balance + betamount +betamount;
      
    }
    
    public void depositMoney(int deposit) {
     
      this.balance = deposit;
    }
    
    public int getBalance() {
       return balance;
    }
   
     
    public int inHand() {
        return N;
    }


    public void reset() {
        N = 0;
    }

    public int value() {
        int val = 0;
        boolean hasAce = false;
        for (int i = 0; i < N; i++) {
            val = val + cards[i].rank();
            if (cards[i].isAce()) {
                hasAce = true;
            }
        }
        if (hasAce && (val <= 11)) {
            val = val + 10;
        }
        return val;
    }
}
