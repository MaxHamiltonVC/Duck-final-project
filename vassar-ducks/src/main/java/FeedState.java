/**
 * Created by mhamilton on 5/8/18.
 */
public class FeedState implements ProgramState{
        Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.FEED;
        public FeedState(Duck duck){
                programDuck = duck;
        }
        public void interpretUserInput(String userInput){}
        public void takeUserInput(){}

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
        public void exit(){}
        public void restart(){}

    public enumState getNextState(){
        return nextState;
    }
    }
