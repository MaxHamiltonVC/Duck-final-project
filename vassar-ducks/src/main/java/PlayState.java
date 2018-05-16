import java.util.Scanner;

/**
 * Created by mhamilton on 5/8/18.
 */
public class PlayState implements ProgramState {
    private Duck programDuck;
    private int playInput = 0;
    private final inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.PLAY;
    private final Scanner inputGatherer = new Scanner(System.in);

    public PlayState(Duck duck){
        programDuck = duck;
    }

    public void interpretUserInput(String userInput){
        enumUserAction processedInput = inputInterpreter.interpret(userInput);
        switch(processedInput){
            case EDUCATE:
                educate();
                break;
            case SLEEP:
                sleep(0);
                break;
            case SCOLD:
                scold();
                break;
            case CLEAN:
                clean(0);
                break;
            case PLAY:
                System.out.println("You're already playing with the duck!");
                break;
            case MAIN:
                nextState = enumState.MAIN;
                break;
            case FEED:
                feed(0);
                break;
            case EXIT:
                exit();
                break;
            case RESTART:
                System.out.println("Are you sure you want to restart the duck app with a whole new duck? "
                        + programDuck.getName()+" will be lost forever!");
                if(inputInterpreter.interpret(inputGatherer.next())==enumUserAction.YES){
                        System.out.println("Restarting the duck app! Say goodbye to "+programDuck.getName()+"...");
                        restart();
                }
                break;
            case HELP:
                System.out.println("Commands include: ");
                System.out.println("Educated, sleep, scold, clean, play, main, feed, exit, and restart.");
                break;
            default:
                System.out.println("Input not recognized. Type 'help' for a list of possible commands.");
                break;
        }
    }

    /**
     * Prompts the user for how much they would like to play for. If the input is inappropriate (not an integer)
     * then it will try to do their action, print out an error or help message appropriate to what they were
     * trying to do, and then continue with the loop and re-prompt for a more appropriate input.
     */
    public void takeUserInput(){
        System.out.println("How long would you like to play with your duck? (In minutes)");
        boolean improperInput = true;
        playInput = 0;
        String playStringInput = "";
        while(improperInput){
            try{
                playStringInput = inputGatherer.next();
                playInput = Integer.parseInt(playStringInput);
                improperInput = false;
            }
            catch(Exception e){
                interpretUserInput(playStringInput);
                System.out.println("Improper input--please type in an integer value (or exit"
                        +", help, main, or restart).");
            }
        }
        play(playInput);
        nextState = enumState.MAIN;
    }

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + " doesn't want to be fed right now!");
    }
    public void play(int playTime){
        programDuck.setHappiness(programDuck.getHappiness() + playInput);
        System.out.println(programDuck.getName() + " had a lot of fun!");
    }
    public void educate(){
        System.out.println(programDuck.getName() + " doesn't want to learn right now!");
    }
    public void clean(int cleanTime){
        System.out.println(programDuck.getName() + " doesn't want to be cleaned right now!");
    }
    public void sleep(int sleepTime){
        System.out.println(programDuck.getName() + " doesn't want to sleep right now!");
    }
    public void scold(){
        System.out.println(programDuck.getName() + " won't listen right now!");
    }

    public void setType(String duckType){ //change to ENUM type?
        System.out.println("You can't do that right now!");
    }

    //Post-game-end states:
    /**
     * Exits the game. This is done by changing the next state to EXIT, which will end the loop in DuckApp.
     */
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){
            nextState = enumState.NAME;
            programDuck = new Duck();}

    /**
     * This returns our next state, so that DuckApp can figure out where to go next in its loop.
     * @return the next state, one of the states enumerated by enumState.
     */
    public enumState getNextState(){
            return nextState;
    }
    /**
     * Checks if the duck has died. The thing that could go wrong:
     * Duck is too dirty
     * Duck has too big or too small of an ego
     * Duck is too sleepy
     * Duck is too hungry
     * Duck is too unhappy
     */
    public void checkForDeath(){
        if(programDuck.getEgo()<0||programDuck.getEgo()>100||programDuck.getCleanliness()<0
                ||programDuck.getHappiness()<0||programDuck.getHunger()>100||programDuck.getSleepiness()>100){
            //these are all the conditions for the duck dying (as laid out in the duck class' comments)
            nextState = enumState.DEATH;
        }
    }
} 
