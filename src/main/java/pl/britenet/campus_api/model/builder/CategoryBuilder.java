package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Category;

public class CategoryBuilder {

    private final Category category;

    public CategoryBuilder() {
        this.category = new Category();
    }
    public Category getCategory() {
        return this.category;
    }

    public CategoryBuilder setId(int id){
        this.category.setId(id);
        return this;
    }

    public CategoryBuilder setName(String name){
        this.category.setName(name);
        return this;
    }

    public CategoryBuilder setDescription(String description){
        this.category.setDescription(description);
        return this;
    }


}

// v baza danych
//v diagramy
// buildery i klasy do builderow
// const trait check w mysql - dowiedzieć sie i zrobić kilka
// zagrac w bilarda

// spotkanie o 10