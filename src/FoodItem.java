/**
 * Created by mattia palmas on 2017-08-30.
 */
public class FoodItem {
    private int quantity;
    private String nameFood;

    public int getQuantity() {
        return quantity;
    }

    public String getNameFood() {
        return nameFood;
    }

    public FoodItem(int quantity, String nameFood) {
        this.quantity = quantity;
        this.nameFood = nameFood;
    }
}
