import java.util.HashMap;
public class inputInterpreter {
    private static inputInterpreter internalInterpreter;
    private static HashMap<String,enumUserAction> meaningMap = new HashMap<String,enumUserAction>();
    public static enumUserAction interpret(String toInterpret){
        // this interprets the user input and, if it's found to be something outside of the possible commands,
        // returns an error state that prompts an error message to the user.
        if(meaningMap.get(toInterpret.toLowerCase())!=null)
            return meaningMap.get(toInterpret.toLowerCase());
        else return enumUserAction.ERROR;
    }
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
    public static inputInterpreter getInstance(){
        if(internalInterpreter == null){
            internalInterpreter = new inputInterpreter();
        }
        return internalInterpreter;
    }
}
