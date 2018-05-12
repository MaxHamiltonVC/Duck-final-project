/**
 * Created by mhamilton on 5/8/18.
 */
public class FeedState implements ProgramState{
        Duck programDuck;
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.FEED;
        public FeedState(Duck duck){
                programDuck = duck;
        }
        public void interpretUserInput(String userInput){}
        public void takeUserInput(){}

        public void feed(int foodAmount){
            if(programDuck.stomach + foodAmount > programDuck.satiated){
                System.out.println("" + programDuck.name + " can't eat that much right now!");
            }
            else{
                programDuck.stomach = programDuck.stomach + foodAmount;
                System.out.println("" + programDuck.name + " enjoyed the food, but they are still hungry!");
            }
        }
        public void play(int playTime){
            System.out.println("" + programDuck.name + " doesn't want to play right now!");        
        }
        public void educate(){
            System.out.println("" + programDuck.name + " doesn't want to learn right now!");
        }
        public void clean(){
            System.out.println("" + programDuck.name + " doesn't want to be cleaned right now!");
        }
        public void sleep(int sleepTime){
            System.out.println("" + programDuck.name + " doesn't want to sleep right now!");
        }
        public void scold(){
            System.out.println("" + programDuck.name + " won't listen right now!");
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
