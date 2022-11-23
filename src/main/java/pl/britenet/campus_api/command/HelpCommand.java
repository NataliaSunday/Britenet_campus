package pl.britenet.campus_api.command;

import java.util.List;

public class HelpCommand extends Command{

    private List<Command> commandList;
    public HelpCommand(List<Command> commandList) {
        super(Constants.COMMAND_NAME_HELP);
        this.commandList = commandList;
    }

    @Override
    public void execute(){
        for(Command command: commandList){
            System.out.println(command.getName());
        }
    }
}
/*klasy abstrakcyjne klasy bez ciała nie isnieje są schematem dla innych klas.
//metodyka serwisowa - klasa podejmujaca decyzje (user mowi co chce,potem [command service], wybieramy komende i robimy jej execute.)
v komenda exit()
v koemnda help - zmodyfikwoać żeby wyswietlala wszystkie.

v zaprojektować baze (user, produkty, koszyk, zamowienia, kategorie) lucidart
3 osoby w biurze i zapytac ile punktu prestiżu dostałam
kolega z supportu pexa
bychawska bestia
sprynio


 */