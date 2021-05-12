package homework.task7;

import java.util.Collections;
import java.util.List;

public class Chief {
    public Burger cookBurger(Package p){
        List<Ingredient> ingredientsList = p.getIngredientsList();
//        if( ! validatePackage(p)) return null;
        sortCheese(ingredientsList);
        sortCutlet(ingredientsList);
        sortSalad(ingredientsList);
        sortBun(ingredientsList);
        return new Burger(ingredientsList, p.getId());
    }

// проверка набора по составу ингредиентов
    public static boolean isValidPackage(Package p){
        List<Ingredient> ingredientsList = p.getIngredientsList();
        boolean isValid = true;
        StringBuilder errMsg = new StringBuilder();

        if ( Collections.frequency(ingredientsList, Ingredient.BUN) > 3  ) {
            errMsg.append(" ну куда столько хлеба?");
            isValid = false;
        }
        if ( ! ingredientsList.contains(Ingredient.CUTLET) ) {
            errMsg.append(" а мясо где?");
            isValid = false;
        }
        if ( Collections.frequency(ingredientsList, Ingredient.BUN) < 2 ) {
            errMsg.append(" нет хотя бы 2-х булок!");
            isValid = false;
        }
        if ( ! isValid ) System.out.println("Rejected! " + p + " -" + errMsg);
        return isValid;
    }

// методы для сортировки
    private void sortCheese(List<Ingredient> ingredientsList) {
        ingredientsList.sort((o1, o2) -> {
            if (o1 != o2) {
                if (o1 == Ingredient.CHEESE) return -1;
                if (o2 == Ingredient.CHEESE) return 1;
            }
            return 0;
        });
    }
    private void sortCutlet(List<Ingredient> ingredientsList) {
        ingredientsList.sort((o1, o2) -> {
            if (o1 != o2) {
                if (o1 == Ingredient.CUTLET) return -1;
                if (o2 == Ingredient.CUTLET) return 1;
            }
            return 0;
        });
    }
    private void sortSalad(List<Ingredient> ingredientsList) {
        ingredientsList.sort((o1, o2) -> {
            if (o1 != o2) {
                if (o1 == Ingredient.SALAD) return -1;
                if (o2 == Ingredient.SALAD) return 1;
            }
            return 0;
        });
    }
    private void sortBun(List<Ingredient> ingredientsList) {
        ingredientsList.sort((o1, o2) -> {
            if (o1 != o2) {
                if (o1 == Ingredient.BUN) return -1;
                if (o2 == Ingredient.BUN) return 1;
            }
            return 0;
        });
        ingredientsList.remove(0); // удаляем булку в начале
        ingredientsList.add(Ingredient.BUN); // и добавляем булку в конец

        if (Collections.frequency(ingredientsList, Ingredient.BUN) == 3 ) { // если 3булки, то
            ingredientsList.remove(0); // опять удаляем в начале
            ingredientsList.add( ingredientsList.size()/2, Ingredient.BUN); // и добавляем в середину
        }
    }
}