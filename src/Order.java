import java.util.ArrayList;

/**
 * Created by mattia palmas on 2017-08-30.
 */
public class Order {
    private ArrayList<FoodItem> foodItem;

    public Order(ArrayList foodItem) {
        this.foodItem = foodItem;
    }


    public ArrayList<FoodItem> getFoodItem() {
        return foodItem;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < foodItem.size(); i++) {
            if (foodItem.get(i) != null){
                result += foodItem.get(i).getQuantity() + " " + foodItem.get(i).getNameFood() + ". ";
            }
        }
        return result;
    }
}
