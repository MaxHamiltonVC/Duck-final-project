import java.util.Scanner;
public class ScoldState implements ProgramState {
    private Duck programDuck;
    private final inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.SCOLD;
    public ScoldState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = inputInterpreter.interpret(userInput);
        Scanner inputGatherer = new Scanner(System.in);
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
        interpretUserInput("scold");
    }

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + " doesn't want to be fed right now!");
    }

    /**
     * This will print a message telling the user that this is not the right time to play, because this state
     * is not one in which playing is allowed.
     * @param playTime the amount of time to play for.
     */
    public void play(int playTime){
        System.out.println("" + programDuck.name + " doesn't want to play right now!");
    }
    public void educate(){
        System.out.println("" + programDuck.name + " doesn't want to learn right now!");
    }
    public void clean(int cleanTime){
        System.out.println("" + programDuck.name + " doesn't want to be cleaned right now!");
    }
    public void sleep(int sleepTime){
        System.out.println("" + programDuck.name + " doesn't want to sleep right now!");
    }
    public void scold(){
        System.out.println("What would you like to say to scold your duck?");
        // the harshness of the scolding is based on the length of the message.
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        programDuck.setEgo(programDuck.getEgo() - (message.length()/5));
        programDuck.setSleepiness(programDuck.getSleepiness()+12);
        programDuck.setCleanliness(programDuck.getCleanliness()-10);
        if(programDuck.getEgo()<20){
            System.out.println(programDuck.getName() + " seems sad and dejected.");
        }
        else if(programDuck.getEgo()<40){
            System.out.println(programDuck.getName() + " sulks, but seemed to learn from your scolding.");
        }
        else if(programDuck.getEgo()<60){
            System.out.println(programDuck.getName() + " arrogantly accepts your criticisms.");}
        else if(programDuck.getEgo()<80){
            System.out.println(programDuck.getName() + " hardly seems fazed by your scolding.");}
        else{
            System.out.println(programDuck.getName() + " is totally unfazed by anything you've said.");}
            System.out.println("Would you like to scold "+programDuck.getName()+ " again?");
        while(true){
            String again = sc.nextLine();
            if(inputInterpreter.interpret(again)==enumUserAction.YES){
                scold();
                break;
            }
            else if(inputInterpreter.interpret(again)==enumUserAction.NO){
                nextState = enumState.MAIN;
                break;
            }
            else{
                System.out.println("Please give a yes or no answer. Would you like to scold once more?");
            }
        }
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
