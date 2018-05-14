import java.util.Scanner;

/**
 * Created by mhamilton on 5/8/18.
 */
public class PlayState implements ProgramState {
        Duck programDuck;
        int playInput = 0;
        inputInterpreter interpreter = inputInterpreter.getInstance();
        // this represents the next state of the program (ie, where we're transitioning to after user input)
        enumState nextState = enumState.PLAY;
        Scanner inputGatherer = new Scanner(System.in);
        
        public PlayState(Duck duck){
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

        //Naming/creation states:
        public void setName(String duckName){
            System.out.println("You can't do that right now!");
        }
        public void setType(String duckType){ //change to ENUM type?
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
