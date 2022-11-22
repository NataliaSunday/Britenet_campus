package pl.britenet.campus_api.command;


import java.util.HashMap;

public class Constants {

    public static final String COMMAND_NAME_HELP = "help";
    public static final String COMMAND_NAME_EXIT = "exit";

    HashMap<String, String> commandsMap = new HashMap<String, String>();


    public HashMap<String, String> getCommands(){
        this.commandsMap.put("Help", "Show commands");
        this.commandsMap.put("Exit", "Exit the app");
        return this.commandsMap;
    }
}
