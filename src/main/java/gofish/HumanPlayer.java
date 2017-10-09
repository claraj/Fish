package gofish;

import java.util.ArrayList;
import java.util.Scanner;

import static input.InputUtils.stringInput;

public class HumanPlayer extends Player {


    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    protected String identifyCardValueToAskFor() {
       
        String cardValRequested;
        
        do {
            cardValRequested = stringInput("What card value do you want to ask for?").toUpperCase();
            System.out.println("You need to have a " + cardValRequested + " already to request more. Try again");
        } while (!hand.hasCardOfThisValue(cardValRequested));

        return cardValRequested;
    }

    @Override
    protected Player selectOpponent(ArrayList<Player> players) {

        for (Player p : players) {
            if (!p.equals(this)) {
                return p;              //return first other player. TODO ask user for who to ask for cards from
            }
        }

        return null;
    }
}
