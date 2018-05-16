import java.util.HashMap;
public class inputInterpreter {
    private static inputInterpreter internalInterpreter;
    private static final HashMap<String,enumUserAction> meaningMap = new HashMap<String,enumUserAction>();

    /**
     * This looks at our map (as defined in the instantiator) and figures out what enumerated user input
     * that correlates to (or error, if none others).
     * @param toInterpret a string, the user's input into the console
     * @return an enumUserAction representing the action intended by that string, or error if no correlated action.
     */
    public static enumUserAction interpret(String toInterpret){
        // this interprets the user input and, if it's found to be something outside of the possible commands,
        // returns an error state that prompts an error message to the user.
        if(meaningMap.get(toInterpret.toLowerCase())!=null)
            return meaningMap.get(toInterpret.toLowerCase());
        else return enumUserAction.ERROR;
    }

    /**
     * This instantiates a list of correlations of user inputs to states. Some states, such as "YES," have multiple
     * inputs that can correlate to that state (eg. "yes" and "y").
     */
    private inputInterpreter(){
        meaningMap.put("clean",enumUserAction.CLEAN);
        meaningMap.put("educate",enumUserAction.EDUCATE);
        meaningMap.put("feed",enumUserAction.FEED);
        meaningMap.put("exit",enumUserAction.EXIT);
        meaningMap.put("quit",enumUserAction.EXIT);
        meaningMap.put("back",enumUserAction.MAIN);
        meaningMap.put("home",enumUserAction.MAIN);
        meaningMap.put("return",enumUserAction.MAIN);
        meaningMap.put("name",enumUserAction.RENAME);
        meaningMap.put("rename",enumUserAction.RENAME);
        meaningMap.put("restart",enumUserAction.RESTART);
        meaningMap.put("play",enumUserAction.PLAY);
        meaningMap.put("scold",enumUserAction.SCOLD);
        meaningMap.put("sleep",enumUserAction.SLEEP);
        meaningMap.put("help",enumUserAction.HELP);
        meaningMap.put("?",enumUserAction.HELP);

        meaningMap.put("y",enumUserAction.YES);
        meaningMap.put("yes",enumUserAction.YES);
        meaningMap.put("no",enumUserAction.NO);
        meaningMap.put("n",enumUserAction.NO);
    }

    /**
     * This is a singleton class, so this allows states to get instances of it so that we don't have to run
     * all of the map functions over again.
     * @return the instance of inputInterpreter.
     */
    public static inputInterpreter getInstance(){
        if(internalInterpreter == null){
            internalInterpreter = new inputInterpreter();
        }
        return internalInterpreter;
    }
}
