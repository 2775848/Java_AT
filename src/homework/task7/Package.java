package homework.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Package {
    private int id;
    private List<Ingredient> ingredientsList;
    public Package(List<Ingredient> list, int id) {
        super();
        this.id = id;
        this.ingredientsList = list;
    }
    public static Package generateRandom(int id) {
        int MAX_NUMBER_OF_INGREDIENTS = 10;
        int MIN_NUMBER_OF_INGREDIENTS = 1;
        List<Ingredient> ingredientsList = new ArrayList<>();
        Random r = new Random();
        int numberOfIngredients = MIN_NUMBER_OF_INGREDIENTS + r.nextInt(MAX_NUMBER_OF_INGREDIENTS);
        for (int i = 0; i < numberOfIngredients; i++) {
            int randomIngredientIndex = r.nextInt(Ingredient.values().length);
            ingredientsList.add(Ingredient.values()[randomIngredientIndex]);
        }
        return new Package(ingredientsList, id);
    }
    public List<Ingredient> getIngredientsList(){
        return new ArrayList<>(this.ingredientsList);
    }
    public int getId(){
        return this.id;
    }
    @Override
    public String toString() {
        return "id:" + id + " Package" + ingredientsList;
    }
}
