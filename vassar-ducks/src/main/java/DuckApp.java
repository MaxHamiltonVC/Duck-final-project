
class DuckApp{
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
		duckState.checkForDeath(); // checks if we should move to the death state
		programRunning = (duckState.getNextState()!=enumState.EXIT); // checks if program should end
	}
}

	/**
	 *
	 * @param currentState The current state of the program, which implements the ProgramState interface
	 * @param newState the new state to be transitioned to, which implements the ProgramState interface
	 * @param duck The duck that our program uses, which will be passed on to the new state.
	 * @return The new ProgramState implementor, with the same duck that currentState had.
	 */
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
