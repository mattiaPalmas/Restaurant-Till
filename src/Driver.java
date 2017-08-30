import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by mattia palmas on 2017-08-29.
 */
public class Driver {

    static final int FIRST_COURSE = 1;
    static final int SECOND_COURSE = 2;
    static final int THIRD_COURSE = 3;
    static ArrayList<FoodItem> antipastoFood,mainFood,desertFood;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        Table table01,table02,table03,table04,table05;
        antipastoFood = new ArrayList<>();
        mainFood = new ArrayList<>();
        desertFood = new ArrayList<>();


        table01 = new Table(1);
        table02 = new Table(2);
        table03 = new Table(3);
        table04 = new Table(4);
        table05 = new Table(5);


        System.out.println("\n---------------- TABLES RESTAURANT ------------\n");
        System.out.println("-----     -----     -----     -----     -----");
        System.out.println("| "  + table01.getTableNumber() + " |     " + "| "  + table02.getTableNumber() + " |     " + "| "  + table03.getTableNumber() + " |     " + "| "  + table04.getTableNumber() + " |     " + "| "  + table05.getTableNumber() + " |     ");
        System.out.println("-----     -----     -----     -----     -----");

        int choose = 1;
        while (choose != 0){
            System.out.println("\nChoose the number:");
            System.out.println("1: insert order.");
            System.out.println("2: check table order.");
            System.out.println("3: close table.");
            System.out.println("0: quit.");
            choose = scn.nextInt();
            int table=0;
            switch (choose){
                case 1 :
                    table = getTableNumber();

                    switch (table){
                        case 1 : setTableOrder(table01);
                            break;
                        case 2 : setTableOrder(table02);
                            break;
                        case 3 : setTableOrder(table03);
                            break;
                        case 4 : setTableOrder(table04);
                            break;
                        case 5 : setTableOrder(table05);
                            break;
                    }
                    break;
                case 2 :
                    table = getTableNumber();

                    switch (table){
                        case 1 : checkTableOrder(table01);
                            break;
                        case 2 : checkTableOrder(table02);
                            break;
                        case 3 : checkTableOrder(table03);
                            break;
                        case 4 : checkTableOrder(table04);
                            break;
                        case 5 : checkTableOrder(table05);
                            break;
                    }
                    break;
                case 3 :
                    antipastoFood = new ArrayList<>();
                    mainFood = new ArrayList<>();
                    desertFood = new ArrayList<>();

                    table = getTableNumber();

                    switch (table){
                        case 1 : table01.closeTable();
                            break;
                        case 2 : table02.closeTable();
                            break;
                        case 3 : table03.closeTable();
                            break;
                        case 4 : table04.closeTable();
                            break;
                        case 5 : table05.closeTable();
                            break;
                    }

                    break;
                case 0 :
                    break;
            }
        }



    }

    /*
        Print state table. If is not empty shows the order inside.
     */
    private static void checkTableOrder(Table table) {
        System.out.println("Table " + table.getTableNumber());
        if (table.isFree()){
            System.out.println("Table is empty.");
        }
        else {
            if (table.getAntipasto() != null){
                System.out.println("Antipasto: " + table.getAntipasto().toString());
            }

            if (table.getMain() != null){
                System.out.println("Main: " + table.getMain().toString());
            }

            if (table.getDesert() != null){
                System.out.println("Desert: " + table.getDesert().toString());
            }




        }
    }

    /*
    Add an order inside a table.
     */
    private static void setTableOrder(Table table) {
        System.out.println("Table " + table.getTableNumber());


        int index= 0;
        int course=0;
        while (1 > 0 ){

            System.out.println("write which course (1 or 2 or 3). ");

            while (course==0){
                if (!scn.hasNextInt()) {
                    System.out.println("Sorry you need to write only a number.");
                    scn.next();
                }
                else {
                    course = scn.nextInt();
                }
            }


            System.out.println("Write food name:");
            scn.nextLine();
            String foodName = scn.nextLine();
            System.out.println("Write quantity:");
            int qnt = 0;

            while (qnt ==0){
                if (!scn.hasNextInt()) {
                    System.out.println("Sorry you need to write only a number.");
                    scn.next();
                }
                else {
                    qnt = scn.nextInt();
                }
            }


            switch (course){
                case 1 :
                    antipastoFood.add(new FoodItem(qnt,foodName));
                    break;
                case 2 :
                    mainFood.add(new FoodItem(qnt,foodName));
                    break;
                case 3 :
                    desertFood.add(new FoodItem(qnt,foodName));
                    break;
            }

            switch (course){
                case 1 : table.setAntipasto(new Order(antipastoFood));
                    break;
                case 2 : table.setMain(new Order(mainFood));
                    break;
                case 3 : table.setDesert(new Order(desertFood));
                    break;
            }

            index++;
            System.out.println("Write \"more\" to add more food or \"quit\" to finish.");
            if(scn.next().equals("quit")){
                break;
            }
        }



    }

    private static int getTableNumber(){
        System.out.println("Which table number you need to insert order?");

            if (!scn.hasNextInt()){
                System.out.println("Sorry you need to write only the number of the table.");
                scn.next();
            }
            else{
                return scn.nextInt();
            }
        return getTableNumber();
    }
}
