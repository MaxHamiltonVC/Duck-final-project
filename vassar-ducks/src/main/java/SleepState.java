import java.util.Scanner;
public class SleepState implements ProgramState {
    private Duck programDuck;
    private final Scanner inputGatherer = new Scanner(System.in);
    private final inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.SLEEP;
    public SleepState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = inputInterpreter.interpret(userInput);
        switch(processedInput){
            case EDUCATE:
                educate();
                break;
            case SLEEP:
                System.out.println("You're already sleeping! Enter an integer value for how long.");
                break;
            case SCOLD:
                scold();
                break;
            case CLEAN:
                clean(0);
                break;
            case PLAY:
                play(0);
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
    public void takeUserInput(){
        System.out.println("How long would you like to sleep for?");
        boolean improperInput = true;
        int sleepInput = 0;
        String sleepStringInput = "";
        while(improperInput){
            try{
                sleepStringInput = inputGatherer.next();
                sleepInput = Integer.parseInt(sleepStringInput);
                improperInput = false;
            }
            catch(Exception e){
                interpretUserInput(sleepStringInput);
                System.out.println("Improper input--please type in an integer value to sleep (or exit"
                +", help, main, or restart).");
            }
        }
        sleep(sleepInput);
        nextState = enumState.MAIN;

    }
    public void feed(int foodAmount){
        System.out.println("You should finish sleeping before you do that.");
    }

    /**
     * This will print a message telling the user that this is not the right time to play, because this state
     * is not one in which playing is allowed.
     * @param playTime the amount of time to play for.
     */
    public void play(int playTime){
        System.out.println("You should finish sleeping before you do that.");}
    public void educate(){}
    public void clean(int cleanTime) {
        System.out.println("You should finish sleeping before you do that.");
    }

    /**
     * sleeps for the inputted amount of time. This will decrease the duck's sleepiness, but increase
     * its dirtiness and hunger.
     * @param sleepTime the amount of time that programDuck will sleep for.
     */
    public void sleep(int sleepTime){
        programDuck.setSleepiness(programDuck.getSleepiness()-sleepTime);
        programDuck.setCleanliness(programDuck.getCleanliness() - 15);
        programDuck.setHunger(programDuck.getHunger()+15);
        programDuck.setHappiness(programDuck.getHappiness()+sleepTime);
        System.out.println(programDuck.getName() + " slept for "+sleepTime+" hours!");
        nextState = enumState.MAIN;
    }

    /**
     * Prints a message informing the user that this is not a state in which the duck can be scolded.
     */
    public void scold(){
        System.out.println("You should finish sleeping before you do that.");}

    //Naming/creation states:

    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:

    /**
     * Exits the game. This is done by changing the next state to EXIT, which will end the loop in DuckApp.
     */
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();
    }

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
