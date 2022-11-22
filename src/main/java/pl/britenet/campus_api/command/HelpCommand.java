package pl.britenet.campus_api.command;

public class HelpCommand extends Command{

    public HelpCommand() {
        super(Constants.COMMAND_NAME_HELP);
    }

    @Override
    public void execute(){
        Constants commands = new Constants();
        commands.getCommands().forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
/*klasy abstrakcyjne klasy bez ciała nie isnieje są schematem dla innych klas.
//metodyka serwisowa - klasa podejmujaca decyzje (user mowi co chce,potem [command service], wybieramy komende i robimy jej execute.)
v komenda exit()
v koemnda help - zmodyfikwoać żeby wyswietlala wszystkie.

zaprojektować baze (user, produkty, koszyk, zamowienia, kategorie) lucidart
3 osoby w biurze i zapytac ile punktu prestiżu dostałam
kolega z supportu pexa
bychawska bestia
sprynio


 */