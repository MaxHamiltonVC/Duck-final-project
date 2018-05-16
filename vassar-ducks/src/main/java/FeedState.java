import java.util.Scanner;
public class FeedState implements ProgramState{  
    private Duck programDuck;
    private final inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.FEED;
    private final Scanner inputGatherer = new Scanner(System.in);
    
    public FeedState(Duck duck){
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
                play(0);
                break;
            case MAIN:
                nextState = enumState.MAIN;
                break;
            case FEED:
                System.out.println("You're already feeding the duck!");
                break;
            case EXIT:
                exit();
                break;
            case RESTART:
                System.out.println("Are you sure you want to restart the duck app with a whole new duck?"
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
        System.out.println("How many grams of food would you like to feed your duck?");
        boolean improperInput = true;
        int feedInput = 0;
        String sleepStringInput = "";
        while(improperInput){
            try{
                sleepStringInput = inputGatherer.next();
                feedInput = Integer.parseInt(sleepStringInput);
                improperInput = false;
            }
            catch(Exception e){
                interpretUserInput(sleepStringInput);
                System.out.println("Improper input--please type in an integer value to sleep (or exit"
                        +", help, main, or restart).");
            }
        }
        feed(feedInput);
        nextState = enumState.MAIN;
    }

    public void feed(int foodAmount){
        programDuck.setHunger(programDuck.getHunger() + foodAmount);
        programDuck.setSleepiness(programDuck.getSleepiness()+10+(foodAmount/4));
        System.out.println(programDuck.getName() + " enjoyed the food!");
    }
    /**
     * This will print a message telling the user that this is not the right time to play, because this state
     * is not one in which playing is allowed.
     * @param playTime the amount of time to play for.
     */
    public void play(int playTime){
        System.out.println(programDuck.getName() + " doesn't want to play right now!");        
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

    //Naming/creation states:
    public void setName(String duckName){
        System.out.println("You can't do that right now!");
    }
    public void setType(String duckType){//change to ENUM type?
        System.out.println("You can't do that right now!");
    } 

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
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
