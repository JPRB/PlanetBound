package PlanetBound.UI.txt;

import PlanetBound.GameLogic.Estados.*;
import PlanetBound.GameLogic.Game;
import PlanetBound.GameLogic.Utils.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextUserInterface {

    private Game game;
    private Scanner s;
    private boolean exit = false;

    public TextUserInterface (Game game) {
        this.game = game;
        s = new Scanner(System.in);
    }

    private void showGame () {
        System.out.println(game);
    }


    private int Menu (List<String> list) {
        int value;


        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "-" + list.get(i));
        }
        System.out.print("> ");

        while (!s.hasNextInt()) s.next();

        value = s.nextInt();

        return value;
    }


    private void getUserInputWhileAwaitingBeginning () {
        int value;

        List<String> MenuInicio = Arrays.asList("Jogar", "Exit");

        value = Menu(MenuInicio);

        if (value == 1) {
            game.start();
        } else if (value == 2)
            exit = true;
    }

    private void getUserInputShipSelection () {
        int value;

        System.out.println("Escolha uma Nave: ");
        List<String> MenuShipSelection = Arrays.asList("Militar", "Explorer");

        value = Menu(MenuShipSelection);

        if (value > 0 && value < 3)
            game.chooseShip(value);
    }

    private void getUserInputDecisionPlanetOrbit () {

        System.out.println(game.getNave());

        System.out.println("Neste planeta existem estes recursos: " + game.getPlanetResources());

        System.out.println("Escolha uma Opção: ");

        List<String> MenuPlanetOrbit = new ArrayList<>(Arrays.asList("Explorar Recursos", "Ir para outro planeta"));

        if (game.haveStationShip()) MenuPlanetOrbit.add("Ir para a Estação Espacial");

        // Se Houver estação espacial, pode ir lá
        //value = Menu(MenuPlanetOrbit);

        switch (Menu(MenuPlanetOrbit)) {
            case 1:
                game.explorePlanet();
                break;
            case 2:
                game.moveToPlanet();
                break;
            case 3:
                if (MenuPlanetOrbit.size() == 3) {
                    game.moveToSpaceStation();
                    break;
                }
            default:
                System.out.println("Opção inexistente");

        }

        // Decidir explorar planeta depois

        // Avançar para próximo planeta
    }


    private void getUserInputDecisionSpaceStation () {

        System.out.println(game.getNave());

        System.out.println("Escolha uma Opção: ");

        List<String> MenuPlanetOrbit =
                new ArrayList<>(Arrays.asList
                        ("Voltar para planeta Orbita",
                                Enums.Station.convertResources.getDescription(),
                                Enums.Station.buyDrone.getDescription(),
                                Enums.Station.hireNewCrew.getDescription(),
                                Enums.Station.upgradeWeapons.getDescription(),
                                Enums.Station.upgradeCargoHold.getDescription())
                );


        switch (Menu(MenuPlanetOrbit)) {
            case 1:
                game.moveToPlanet();
                break;
            case 2:
               game.getItemsSpaceStations(Enums.Station.convertResources.getValue());
                break;
            case 3:
                game.getItemsSpaceStations(Enums.Station.buyDrone.getValue());
                break;
            case 4:
                game.getItemsSpaceStations(Enums.Station.hireNewCrew.getValue());
                break;
            case 5:
                game.getItemsSpaceStations(Enums.Station.upgradeWeapons.getValue());
                break;
            case 6:
                game.getItemsSpaceStations(Enums.Station.upgradeCargoHold.getValue());
                break;
            default:
                System.out.println("Opção inexistente");
        }

    }


    private void getUserInputDecisionLandingParty()
    {
        int value;

        System.out.println("Move Drone: ");

        List<String> MenuPlanetOrbit = new ArrayList<>(Arrays.asList("Y-", "X+", "X-", "Y+"));

        value = Menu(MenuPlanetOrbit);

        if (value > 0 && value < 5)
            game.moveDrone(value);
        else
            System.out.println("Opção inexistente");

    }


    private void getUserInputWhileGameOver() {

        List<String> MenuGameOver = Arrays.asList("Jogar Novamente", "Exit");

        switch (Menu(MenuGameOver)) {
            case 1:
                game.playAgain();
                break;
            case 2:
                exit = true;
                break;
            default:
                System.out.println("Opção inexistente");
        }
    }


    public void run () {

        while (!exit) {

            if (game.getMsgLog().size() > 0) {

                System.out.println();

                game.getMsgLog().forEach((msg) -> System.out.println("---> " + msg));

                game.clearMsgLog();

            }

            /* switch (game.getState()){
                case :
            }*/

            if (game.getState() instanceof AwaitBeginning) {
                getUserInputWhileAwaitingBeginning();
            } else if (game.getState() instanceof AwaitShipSelection) {
                getUserInputShipSelection();
            } else if (game.getState() instanceof PlanetOrbit) {
                getUserInputDecisionPlanetOrbit();
            }else if (game.getState() instanceof AwaitToExplorerResources) {
                    getUserInputDecisionLandingParty();
            } else if (game.getState() instanceof AwaitStationDecisions) {
                getUserInputDecisionSpaceStation();
            }else if(game.getState() instanceof GameOver){
                getUserInputWhileGameOver();
            }
        }

        System.out.println();
        System.out.println("************** Game over *****************");
        showGame();

    }

}
