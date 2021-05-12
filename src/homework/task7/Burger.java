package homework.task7;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private int id;
    private List<Ingredient> ingredientsList;
    public Burger(List<Ingredient> list, int id) {
        super();
        this.id = id;
        this.ingredientsList = list;
    }
    public List<Ingredient> getIngredientsList(){
        return new ArrayList<>(this.ingredientsList);
    }
    public int getId(){
        return this.id;
    }
    @Override
    public String toString() {
        return "id:" + id + " Burger" + ingredientsList;
    }
}
