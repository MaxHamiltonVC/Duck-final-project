
public class DuckApp{
public static void main(String[] args){
	// This will keep track of whether our program's loop is still running
	boolean programRunning = true;
	Duck programDuck = new Duck();
	ProgramState duckState = new NameState(programDuck);
	// we start in the name state, by default
	enumState currentState = enumState.NAME;

	while(programRunning){
		// actually this needs to be changed--the interpretation of user input should happen in this class,
		// and the fulfillment of that input should be different by state. PLEASE change!

		// the main loop: go into the intended next state, then run that state's user input protocol
		// and have it decide internally what to do from there.
		duckState = switchState(duckState,duckState.getNextState(),programDuck);
		duckState.takeUserInput();
		programRunning = (duckState.getNextState()!=enumState.EXIT); // checks if program should end
	}
}
	private static ProgramState switchState(ProgramState currentState, enumState newState, Duck duck){
		switch(newState){
			case FEED:
				return new FeedState(duck);
			case MAIN:
				return new MainState(duck);
			case NAME:
				return new NameState(duck);
			case PLAY:
				return new PlayState(duck);
			case CLEAN:
				return new CleanState(duck);
			case DEATH:
				return new DeathState(duck);
			case SCOLD:
				return new ScoldState(duck);
			case SLEEP:
				return new SleepState(duck);
			case EDUCATE:
				return new EducateState(duck);
			default:
				System.out.println("Error in changing states.");
				break;

		}
		System.out.println("Returning default state (error has occurred):");
		return new MainState(duck);
	}
}
