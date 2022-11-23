package pl.britenet.campus_api.model;

public final class Category { //nie mozna rozszerzac w przypadku klasy - final
    private  String name;
    private int id;

    public Category(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
