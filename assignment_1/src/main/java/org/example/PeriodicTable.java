// package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * First you should obtain the following information from the user:
 * • whether the ‘Lanthanum’ group (elements 57–71) and ‘Actinium’ group (elements 89–103) should be printed — the default is ‘no’;
 * • the atomic number of the first element to display — the default is ‘1’ and should be used whenever a value less than 1 or greater than
 * 118 is given; and
 * • the atomic number of the last element to display — the default is ‘118’ and should be used whenever a number smaller than the first
 * number or larger than 118 is given.
 */
public class PeriodicTable implements PeriodicTableInterface {

    private final Scanner INPUT = new Scanner(System.in);
    private final String[][] MAIN_PERIODIC_TABLE = new String[7][18];
    private final String[][] GROUP_TABLE = new String[2][18];

    // private final String[] LANTHANIDE_TABLE = new String[18];
    // private final String[] ACTINIDE_TABLE = new String[18];


    private boolean displayGroup = false;
    // private boolean displayActinides = false;
    private int starting_number = -1;
    private int end_number = -1;

    String element;
    String periodic_number;

    public PeriodicTable(){

        String user_input = null;
        
        System.out.println("Display lanthinides? y/n?");
        user_input=INPUT.nextLine();

        if (user_input == "y"){
            displayGroup = true;           
        }

        // System.out.println("Display actinides? y/n?");
        // user_input=INPUT.nextLine();

        // if (user_input == "y"){
        //     displayActinides = true;
        // }

       starting_number = promptForInt("Enter starting element number:");
       end_number = promptForInt("Enter ending element number:");
    }

    private int promptForInt(String prompt){
        Integer number = null;
        System.out.println(prompt);
        //Prompt user until an appropriate input has been achieved
        while (number == null){
            try {
                number = Integer.parseInt(INPUT.nextLine());
            }
            catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input, try again");
            }
        }
        return number;
    }

    protected final String TABLE [] [] = {

            {"H","1"},{"He","18"},{"Li","1"},{"Be","2"},{"B","13"},{"C","14"},{"N","15"},{"O","16"},{"F","17"},
            {"Ne","18"},{"Na","1"},{"Mg","2"},{"Al","13"},{"Si","14"},{"P","15"},{"S","16"},{"Cl","17"},{"Ar","18"},{"K","1"},{"Ca","2"},
            {"Sc","3"},{"Ti","4"},{"V","5"},{"Cr","6"},{"Mn","7"},{"Fe","8"},{"Co","9"},{"Ni","10"},{"Cu","11"},{"Zn","12"},{"Ga","13"},
            {"Ge","14"},{"As","15"},{"Se","16"},{"Br","17"},{"Kr","18"},{"Rb","1"},{"Sr","2"},{"Y","3"},{"Zr","4"},{"Nb","5"},{"Mo","6"},
            {"Tc","7"},{"Ru","8"},{"Rh","9"},{"Pd","10"},{"Ag","11"},{"Cd","12"},{"In","13"},{"Sn","14"},{"Sb","15"},{"Te","16"},
            {"I","17"},{"Xe","18"},{"Cs","1"},{"Ba","2"},

            {"La","-11"},{"Ce","-12"},{"Pr","-13"},{"Nd","-14"},{"Pm","-15"},{"Sm","-16"},
            {"Eu","-17"},{"Gd","-18"},{"Tb","-19"},{"Dy","-20"},{"Ho","-21"},{"Er","-22"},{"Tm","-23"},{"Yb","-24"},{"Lu","-25"},

            {"Hf","4"},{"Ta","5"},{"W","6"},{"Re","7"},{"Os","8"},{"Ir","9"},{"Pt","10"},{"Au","11"},{"Hg","12"},{"Tl","13"},{"Pb","14"},
            {"Bi","15"},{"Po","16"},{"At","17"},{"Rn","18"},{"Fr","1"},{"Ra","2"},
            {"Ac","-31"},{"Th","-32"},{"Pa","-33"},{"U","-34"},
            {"Np","-35"},{"Pu","-36"},{"Am","-37"},{"Cm","-38"},{"Bk","-39"},{"Cf","-40"},{"Es","-41"},{"Fm","-42"},{"Md","-43"},
            {"No","-44"},{"Lr","-45"},

            {"Rf","4"},{"Db","5"},{"Sg","6"},{"Bh","7"},{"Hs","8"},{"Mt","9"},{"Ds","10"},{"Rg","11"},
            {"Cn","12"},{"Uut","13"},{"Fl","14"},{"Uup","15"},{"Lv","16"},{"Uus","17"},{"Uuo","18"}};

    @Override
    public void printTables() {
        
        if(displayGroup == true)
        {
            for(int i = starting_number; i <= end_number; i++)
            {
                //[7][18]

                
                main_table_element = "" + MAIN_PERIODIC_TABLE[i][];
                System.out.print(main_table_element);
                for(int j = 0; j <= 18; j++)
                {
                    MAIN_PERIODIC_TABLE[][]
                    
                }   
            }
        }
    }

    @Override
    public void printGroups() {
        if(displayGroup == true)
        {
            for(int i = 0; i <= 2; i++)
            {
                GROUP_TABLE[i];

                for(int j = 0; j <= 18; j++)
                {
                    
                }   
            }
        }
    }
}
