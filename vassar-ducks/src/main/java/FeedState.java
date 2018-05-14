/**
 * Created by mhamilton on 5/8/18.
 */
import java.util.Scanner;
public class FeedState implements ProgramState{
    int foodAmount = 0;
    Duck programDuck;
    Scanner inputGatherer = new Scanner(System.in);
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.FEED;
    public FeedState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = interpreter.interpret(userInput);
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
                clean();
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
                System.out.println("Are you sure you want to restart the duck app with a whole new duck?"
                        + programDuck.getName()+" will be lost forever!");
                if(interpreter.interpret(inputGatherer.next())==enumUserAction.YES){
                    System.out.println("Restarting the duck app! Say goodbye to "+programDuck.getName()+"...");
                    restart();
                }
                break;
            default:
                System.out.println("Input not recognized. Type 'help' for a list of possible commands.");
                break;
        }
    }
    public void takeUserInput(){
        System.out.println("How much would you like to feed your duck?");
        boolean improperInput = true;
        foodAmount = 0;
        String foodAmountString = "";
        while(improperInput){
            try{
                foodAmountString = inputGatherer.next();
                foodAmount = Integer.parseInt(foodAmountString);
                improperInput = false;
            }
            catch(Exception e){
                interpretUserInput(foodAmountString);
                System.out.println("Improper input--please type in an integer value (or exit"
                +", help, main, or restart).");
            }
        }

        feed(foodAmount);
        nextState = enumState.MAIN;
    }

    public void feed(int foodAmount){
        programDuck.setHunger(programDuck.getHunger() + foodAmount);
        programDuck.hunger = programDuck.hunger + foodAmount;
        System.out.println(programDuck.getName() + " enjoyed the food!");

    }
    public void play(int playTime){
        System.out.println(programDuck.getName() + " doesn't want to play right now!");        
    }
    public void educate(){
        System.out.println(programDuck.getName() + " doesn't want to learn right now!");
    }
    public void clean(){
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
}
