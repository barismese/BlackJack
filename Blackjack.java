

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

public class Blackjack extends JFrame implements ActionListener {

    private Shoe shoe;
    public Player player = new Player("player",0);
    public Player dealer = new Player("dealer",0);

    private JButton jbtnHit = new JButton("Hit");
    private JButton jbtnStand = new JButton("Stand");
    private JButton jbtnBet = new JButton("Bet");
    
    private JButton jbtnHit2 = new JButton("Hit");
    private JButton jbtnStand2 = new JButton("Stand");
    private JButton jbtnBet2 = new JButton("Bet");
    
    private JButton jbtnHit3 = new JButton("Hit");
    private JButton jbtnStand3 = new JButton("Stand");
    private JButton jbtnBet3 = new JButton("Bet");
    
    private JButton jbtnDeal = new JButton("Deal");

    
    private String bet;
    private int beta ;

    private boolean checkbj = false;

    
    private JLabel jlblStatus = new JLabel(" ", JLabel.CENTER);
   

    JPanel playerPanel = new JPanel();
    JPanel playerPanel2 = new JPanel();
    JPanel playerPanel3 = new JPanel();
    
    JPanel dealPanel = new JPanel();
   
    
    JPanel dealerPanel = new JPanel();
    
    JPanel buttonsPanel = new JPanel();
    JPanel buttonsPanel2 = new JPanel();
    JPanel buttonsPanel3 = new JPanel();
     
    JPanel statusPanel = new JPanel();
    

    JPanel table = new JPanel();

    Blackjack() {
        JFrame gameFrame = new JFrame(" BlackJack");
       
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonsPanel.add(jbtnHit);
        buttonsPanel.add(jbtnStand);
        buttonsPanel.add(jbtnBet);
        buttonsPanel2.add(jbtnHit2);
        buttonsPanel2.add(jbtnStand2);
        buttonsPanel2.add(jbtnBet2);
        buttonsPanel3.add(jbtnHit3);
        buttonsPanel3.add(jbtnStand3);
        buttonsPanel3.add(jbtnBet3);
        
       
        dealPanel.add(jbtnDeal);
       
        statusPanel.add(jlblStatus);
      
        jbtnDeal.addActionListener(this);
       
        
        jbtnHit.addActionListener(this);
        jbtnStand.addActionListener(this);
        
        jbtnHit2.addActionListener(this);
        jbtnStand2.addActionListener(this);
        
        jbtnHit3.addActionListener(this);
        jbtnStand3.addActionListener(this);
       
        
        jbtnBet.addActionListener(this);
        jbtnBet2.addActionListener(this);
        jbtnBet3.addActionListener(this);

        jbtnHit.setEnabled(false);
        jbtnStand.setEnabled(false);
        jbtnBet.setEnabled(false);
        jbtnBet2.setEnabled(false);
        jbtnBet3.setEnabled(false);
        jbtnDeal.setEnabled(false);
        
        dealerPanel.setOpaque(false);
        playerPanel.setOpaque(false);
        buttonsPanel.setOpaque(false);
        buttonsPanel2.setOpaque(false);
        buttonsPanel3.setOpaque(false);
        dealPanel.setOpaque(false);
   
       
       
        playerPanel2.setBackground(Color.GREEN);
        playerPanel3.setBackground(Color.GREEN);
      
      
       
        statusPanel.setBackground(Color.RED);
        
        jbtnStand.setEnabled(false);
        jbtnHit.setEnabled(false);
        jbtnBet.setEnabled(true);
        
        jbtnStand2.setEnabled(false);
        jbtnHit2.setEnabled(false);
        jbtnBet2.setEnabled(true);
        
        jbtnStand3.setEnabled(false);
        jbtnHit3.setEnabled(false);
        jbtnBet3.setEnabled(true);    
      
        table.add(new JLabel(new ImageIcon("btable.png")));
        
        gameFrame.setLayout(null);
        gameFrame.add(dealPanel);
       
        gameFrame.add(buttonsPanel);
        gameFrame.add(buttonsPanel2);
        gameFrame.add(buttonsPanel3);
        gameFrame.add(dealerPanel);
        gameFrame.add(statusPanel);
        gameFrame.add(playerPanel);
        gameFrame.add(playerPanel2);
        gameFrame.add(playerPanel3);

        
        
        gameFrame.add(table);
      
        
        table.setBounds(0,0,1366,724);
        dealerPanel.setBounds(500,70,400,220);
        playerPanel.setBounds(550,450,300,220);
        playerPanel2.setBounds(175,250,300,220);
        playerPanel3.setBounds(900,250,300,220);
        
        dealPanel.setBounds(585,350,200,40);
     
      
        buttonsPanel.setBounds(585,400,230,50);
        buttonsPanel2.setBounds(225,200,230,50);
        buttonsPanel3.setBounds(950,200,230,50);
       
        statusPanel.setBounds(600,330,200,40);
        
        gameFrame.setSize(1366, 724);
        gameFrame.setVisible(true);
        gameFrame.setResizable(false);
    }

    private void hitPlayer() {
        Card newCard = player.dealTo(shoe.dealFrom());
        playerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        playerPanel.updateUI();
    }
    
 
     
    private void betPlayer() {
       
       if ( player.getBalance() == 0  )
        {
      
        String deposit = JOptionPane.showInputDialog ( "Your balance is 0, deposit money " + " Enter your deposit amount", "Enter" );
        int deposita = Integer.parseInt(deposit);
        player.depositMoney(deposita);
        
       }
       
        int bal = player.getBalance();
        
        bet = JOptionPane.showInputDialog ( "Enter your bet. Your balance is : " + player.getBalance() );
        beta = Integer.parseInt(bet);
        player.bet(beta);
        
        
        while ( beta > bal) {
        
        JOptionPane.showMessageDialog(null, "You dont have enough money","Blackjack", JOptionPane.PLAIN_MESSAGE);
        returnBet();
        betPlayer(); 
        
        }
        
        while ( beta <= 0)
        {
             JOptionPane.showMessageDialog(null, "Your bet is invalid."," Blackjack", JOptionPane.PLAIN_MESSAGE);
             returnBet();
             betPlayer();
        }
    }
    
    private void addWinningsPlayer() {
      
      player.addWinnings(beta);
           
    }
    
    private void returnBet(){
     player.returnBet(beta); 
    }

    private void hitDealerDown() {
        Card newCard = dealer.dealTo(shoe.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/b2fv.png")));
        dealerPanel.updateUI();
    }

    private void hitDealer() {
        Card newCard = dealer.dealTo(shoe.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        dealerPanel.updateUI();
    }

    private void deal() {
       
        int y = 312 - ((int)(Math.random()*30)+220);
      
        playerPanel.removeAll();
        dealerPanel.removeAll();
        playerPanel.updateUI();
        dealerPanel.updateUI();
        
        //
        playerPanel2.removeAll();  
        playerPanel2.updateUI();
     
        //
        playerPanel3.removeAll();
        playerPanel3.updateUI();
          
        //
        
        player.reset();
        dealer.reset();
        
        if (shoe == null || shoe.size() < y ) {
            shoe = new Shoe();
            shoe.shuffle();
            jlblStatus.setText("New Shoe");
        }
       
         
       
        checkbj= false;
        hitPlayer();
        hitDealerDown();
        hitPlayer();
        hitDealer();
        
        if ( player.value() == 21 ) {
          
         checkbj = true; 
        }
        
       
    }

    private void checkWinner() {
        dealerPanel.removeAll();
        for (int i = 0; i < dealer.inHand(); i++) {
            dealerPanel.add(new JLabel(new ImageIcon("cards/" + dealer.cards[i].toString())));
        }
        if (player.value() > 21) {
            jlblStatus.setText("Player Busts");
        } else if (dealer.value() > 21) {
            jlblStatus.setText("Dealer Busts");
            addWinningsPlayer();
        } else if (dealer.value() == player.value()) {
            jlblStatus.setText("Push");
            returnBet();
        } else if (dealer.value() < player.value()) {
            jlblStatus.setText("Player Wins");
             addWinningsPlayer();
        } else {
            jlblStatus.setText("Dealer Wins");
        }
    }
    
    private void checkBlackjack() {
      
      if( checkbj || player.value() == 21) {
       jbtnHit.setEnabled(false);
       jbtnStand.setEnabled(false);
     
       if ( !checkbj ) {  while (dealer.value() < 17) {
                hitDealer();
            }
       }
        
       checkWinner();
       jbtnBet.setEnabled(true);
      }
       
      
     
      
    }

    public void actionPerformed(ActionEvent e) {
      
  
        
        if (e.getSource() == jbtnHit) {
          
            hitPlayer();
            checkBlackjack(); 
            if (player.value() > 21) {
                checkWinner();
                jbtnHit.setEnabled(false);
                jbtnStand.setEnabled(false);
                jbtnDeal.setEnabled(false);
                jbtnBet.setEnabled(true);
            }
        }
        
        
        
        if (e.getSource() == jbtnStand) {
            while (dealer.value() < 17) {
                hitDealer();
            }
            checkWinner();
            jbtnHit.setEnabled(false);
            jbtnStand.setEnabled(false);
            jbtnDeal.setEnabled(false);
            jbtnBet.setEnabled(true);
          
        
        }
        
        if ( e.getSource() == jbtnBet ){
          
         betPlayer();
          jbtnDeal.setEnabled(true);
          jbtnBet.setEnabled(false);
        }
        
        if ( e.getSource() == jbtnBet2 ){
          
          betPlayer();
          jbtnDeal.setEnabled(true);
          jbtnBet2.setEnabled(false);
        }
        
        if ( e.getSource() == jbtnBet3 ) {
          betPlayer();
          jbtnDeal.setEnabled(true);
          jbtnBet3.setEnabled(false);
         
        }
        
        if ( e.getSource() == jbtnDeal) { 
          
            deal();
            jbtnDeal.setEnabled(false);
            jbtnHit.setEnabled(true);
            jbtnStand.setEnabled(true);            
            jlblStatus.setText(" ");
            jbtnBet.setEnabled(false);     
            checkBlackjack(); 
        }
        
     
     
          
       
        
        
        
        
    }
    
}