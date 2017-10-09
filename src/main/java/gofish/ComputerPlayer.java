package gofish;


import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player{

    static Random rnd = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected String identifyCardValueToAskFor() {

        //Randomly pick a value from cards held by computer
        //Todo more intelligent suggestion?

        int cardSelectedIndex = rnd.nextInt(hand.size());
        Card cardSelected = hand.get(cardSelectedIndex);
        return cardSelected.value;

    }


    @Override
    protected Player selectOpponent(ArrayList<Player> players) {

        // What if no other players?
        if ( players.size() <= 1 )  { return null; }  // This isn't useful, but hopefully whatever else uses this will crash and it will be noticed
        
        
        for (Player p : players) {
            if (p != this) {
                return p;    //return first other player.
                
                // TODO computer make a 'decision' for who to ask for cards from
            }
        }

        return null;
    }
}
