package pl.britenet.campus_api.model;

public final class Category { //nie mozna rozszerzac w przypadku klasy - final
    private  String name;
    private int id;

    private String description;

    public Category(){} //konstruktor

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category\n" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'';
    }
    public  String toStringName(){
        return "Category\n" +
        "name='" + name;
    }
}
