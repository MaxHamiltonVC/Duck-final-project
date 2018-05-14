/**
 * Created by mhamilton on 5/8/18.
 */
import java.util.Scanner;
public class DeathState implements ProgramState{
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    String epitaph = "";
    Scanner inputGatherer = new Scanner(System.in);
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.DEATH;
    public DeathState(Duck duck){
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
                System.out.println("Are you sure you want to restart the duck app with a whole new duck without"
                        + " writing an epitaph first? The memory of "
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
        System.out.println("Alas, your duck is dead. Don't cry--even the best duck parents aren't perfect."
        +" To commemorate your duck's legacy, please enter an epitaph for them, to b e stored forever:");
        epitaph = inputGatherer.next();
        interpretUserInput(epitaph);
    }

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + " is dead. They can eat no longer.");
    }
    public void play(int playTime){
        System.out.println(programDuck.getName() + " is dead. They can play no longer.");}
    public void educate(){
        System.out.println(programDuck.getName() + " is dead. Their days of education are over.");}
    public void clean(int cleanTime){
        System.out.println(programDuck.getName() +
                " is dead. You clean them, but it doesn't bring them back.");}
    public void sleep(int sleepTime){
        System.out.println(programDuck.getName() + " is dead. They're sleeping forever now, in a way.");}
    public void scold(){
        System.out.println(programDuck.getName() + " is dead. Haven't they suffered enough?");}

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

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
