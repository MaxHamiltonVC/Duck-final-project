import java.util.Scanner;
public class CleanState implements ProgramState{
    private Duck programDuck;
    final inputInterpreter interpreter = inputInterpreter.getInstance();
    private final Scanner inputGatherer = new Scanner(System.in);
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.CLEAN;
    public CleanState(Duck duck){
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
                System.out.println("You're already cleaning the duck!");
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
        System.out.println("How long would you like to clean for? (In minutes)");
        boolean improperInput = true;
        int cleanInput = 0;
        String cleanStringInput = "";
        while(improperInput){
            try{
                cleanStringInput = inputGatherer.next();
                cleanInput = Integer.parseInt(cleanStringInput);
                improperInput = false;
            }
            catch(Exception e){
                interpretUserInput(cleanStringInput);
                System.out.println("Improper input--please type in an integer value to clean (or exit"
                +", help, main, or restart).");
            }
        }
        clean(cleanInput);
        nextState = enumState.MAIN;
    }

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + "'s stench has made them lose their appetite.");
    }
    /**
     * This will print a message telling the user that this is not the right time to play, because this state
     * is not one in which playing is allowed.
     * @param playTime the amount of time to play for.
     */
    public void play(int playTime){
        System.out.println("Judging by how " + programDuck.getName() + " smells, I think they've had enough playtime.");
    }
    public void educate(){
        System.out.println("The only thing " + programDuck.getName() + " can think about is being cleaned.");
    }
    public void clean(int cleanTime){
        programDuck.setCleanliness(programDuck.getCleanliness() + cleanTime);
        programDuck.setSleepiness(programDuck.getSleepiness()+10+(cleanTime/2));
        System.out.println(programDuck.getName() + " looks cleaner!");
        nextState = enumState.MAIN;
    }
    public void sleep(int sleepTime){
        System.out.println(programDuck.getName() + " doesn't want to sleep in their filth!");
    }
    /**
     * Prints a message informing the user that this is not a state in which the duck can be scolded.
     */
    public void scold(){
        System.out.println(programDuck.getName() + " can't hear you because their ears are COVERED in filth!");
    }

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;
    }
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();}

    public enumState getNextState(){
        return nextState;
    }
    public void checkForDeath(){
        if(programDuck.getEgo()<0||programDuck.getEgo()>100||programDuck.getCleanliness()<0
                ||programDuck.getHappiness()<0||programDuck.getHunger()>100||programDuck.getSleepiness()>100){
            //these are all the conditions for the duck dying (as laid out in the duck class' comments)
            nextState = enumState.DEATH;
        }
    }
}
