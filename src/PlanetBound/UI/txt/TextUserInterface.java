package PlanetBound.UI.txt;

import PlanetBound.GameLogic.Estados.AwaitBeginning;
import PlanetBound.GameLogic.Estados.AwaitShipSelection;
import PlanetBound.GameLogic.Estados.PlanetOrbit;
import PlanetBound.GameLogic.Game;

import javax.xml.bind.annotation.XmlEnum;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextUserInterface {

    private Game game;
    private Scanner s;
    private boolean exit = false;

    public TextUserInterface(Game  game) {
        this.game = game;
        s = new Scanner(System.in);
    }

    private void showGame()
    {
        System.out.println(game);
    }


    private int Menu (List<String> list){
        int value;


        for (int i = 0; i < list.size(); i ++) {
            System.out.println(i+1 + "-"+list.get(i));
        }
        System.out.print("> ");

        while(!s.hasNextInt()) s.next();

        value=s.nextInt();

        return value;
    }


    private void getUserInputWhileAwaitingBeginning()
    {
        int value;


        List<String> MenuInicio = Arrays.asList("Begin", "Exit");

        value = Menu(MenuInicio);

        if(value == 1) {
            game.start();
        }
        else if (value == 2)
            game.finish();
    }

    /*private void getUserInputWhileAwaitingBet()
    {
        int value;

        System.out.println("\n\n---------------------------------");
        showGame();

        System.out.println();
        System.out.println("Bet up to "+ game.getScore()+" point(s) or -1 to end the game");
        System.out.print("> ");

        while(!s.hasNextInt()) s.next();

        value=s.nextInt();

        if(value>=0){
            game.bet(value);
        }else{
            game.finish();
        }

    }

    private void getUserInputWhileAwaitingOptionSelection()
    {
        int value;

        System.out.println("\n\n---------------------------------");
        showGame();

        System.out.println();
        System.out.println("A black ball was removed from the bag");
        System.out.println();
        System.out.println("1-Lose a point");
        System.out.println("2-Remove two balls from the bag (black balls return to the bag and white balls are removed from the game)");
        System.out.print("> ");

        while(!s.hasNextInt()) s.next();

        value = s.nextInt();

        if(value == 1){
            game.removeOneBallFromCollectedWhiteBalls();
        }else if(value == 2){
            game.getTwoBallsFromBag();
        }

    }
    private void getUserInputWhileGameOver()
    {
        int value;

        System.out.println("1-Play again");
        System.out.println("2-Exit");
        System.out.print("> ");

        while(!s.hasNextInt()) s.next();

        value=s.nextInt();

        if(value==1){
            game.start();
        }else if(value == 2){
            exit = true;
        }
    }*/


    private void getUserInputDecisionPlanetOrbit()
    {
        int value;

        // game.getState().;
        System.out.println("1-Play again");
        System.out.println("2-Exit");
        System.out.print("> ");

        while(!s.hasNextInt()) s.next();

        value=s.nextInt();

        if(value==1){
            game.start();
        }else if(value == 2){
            exit = true;
        }
    }

    private void getUserInputExplorer () {

    }


    private void getUserInputShipSelection ()
    {
        int value;

        System.out.println("Escolha uma Nave: ");
        List<String> MenuShipSelection = Arrays.asList("Militar", "Explorer");

        value = Menu(MenuShipSelection);

        if(value > 0 && value < 3)
            game.chooseShip(value);
    }



    public void run () {

        while(!exit){

            if(game.getMsgLog().size() > 0){

                System.out.println();

                game.getMsgLog().forEach((msg) -> System.out.println("---> " + msg));

                //game.clearMsgLog();

            }

            /* switch (game.getState()){
                case :
            }*/

            if(game.getState() instanceof AwaitBeginning){
                getUserInputWhileAwaitingBeginning();
            }
            else if(game.getState() instanceof AwaitShipSelection){
                getUserInputShipSelection();
            }
            else if(game.getState() instanceof PlanetOrbit){
                getUserInputDecisionPlanetOrbit();
                //System.out.println("vou Orbitar um planeta");

            }/*else if(game.getState() instanceof GameOver){
                getUserInputWhileGameOver();
            }*/
        }

        System.out.println();
        System.out.println("************** Game over *****************");
        showGame();

    }

}
