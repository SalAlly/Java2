package AllySalLab4;

public class CardGameDemo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        CardPlayer player = new CardPlayer();

 
        for (int i = 0; i < 5; i++) {
            Card card = deck.deal();
            if (card != null) {
                player.getCard(card);
            }
        }

        System.out.println("Player's hand:");
        player.showCards();
    }
}