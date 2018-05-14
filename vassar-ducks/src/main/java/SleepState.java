/**
 * Created by mhamilton on 5/8/18.
 */
import java.util.Scanner;
public class SleepState implements ProgramState {
    int sleepInput = 0;
    Duck programDuck;
    Scanner inputGatherer = new Scanner(System.in);
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.SLEEP;
    public SleepState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = interpreter.interpret(userInput);
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
        System.out.println("How long would you like to sleep for?");
        boolean improperInput = true;
        sleepInput = 0;
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

    public void feed(int foodAmount){}
    public void play(int playTime){}
    public void educate(){}
    public void clean(){}
    public void sleep(int sleepTime){}
    public void scold(){}

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();
    }

    public enumState getNextState(){
        return nextState;
    }
}
