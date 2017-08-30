import java.util.HashMap;
import java.util.Map;

/**
 * Created by mattia palmas on 2017-08-29.
 */
public class Table {

    private Order antipasto, main, desert;
    private boolean isFree;
    private int tableNumber;


    public Table(int tableNumber) {
        isFree = true;
        this.tableNumber = tableNumber;
    }


    public boolean isFree() {
        return isFree;
    }

    public Order getAntipasto() {
        return antipasto;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Order getMain() {
        return main;
    }

    public Order getDesert() {
        return desert;
    }

    public void setAntipasto(Order antipasto) {
        this.antipasto = antipasto;
        isFree = false;
    }

    public void setMain(Order main) {
        this.main = main;
        isFree = false;
    }

    public void setDesert(Order desert) {
        this.desert = desert;
        isFree = false;
    }





    public void closeTable(){
        antipasto = null;
        main = null;
        desert = null;
        isFree = true;
    }

}
