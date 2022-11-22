package pl.britenet.campus_api.command;

public class ExitCommand extends Command{

    public ExitCommand() { super(Constants.COMMAND_NAME_EXIT); }

    @Override
    public void execute(){
        System.exit(0);

    }
}
