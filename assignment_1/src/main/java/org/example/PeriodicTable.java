package org.example;

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

    private final int GROUP_COLUMN_OFFSET = 4;

    private final int LANTHANIDE_SEPERATOR_START = -25;
    private final int LANTHANIDE_SEPERATOR_END = -11;

    private final int ACTINIDE_SEPERATOR_START = -45;
    private final int ACTINIDE_SEPERATOR_END = -31;

    private final int LANTHANUM_ATOMIC_NUMBER = 57;
    private final int ACTINIUM_ATOMIC_NUMBER = 89;

    private final String[][] MAIN_PERIODIC_TABLE = new String[118][2];

    private final int TABLE_WIDTH = 18;

    private final String[][] LANTHANIDE_TABLE = new String[18][2];
    private final String[][] ACTINIDE_TABLE = new String[18][2];

    private boolean displayGroup = false;
    private int starting_number = 1;
    private int end_number = 118;

    String element;
    String periodic_number;

    protected final String[][] RAW_ATOMIC_TABLE = {

            {"H","1"},{"He","18"},{"Li","1"},{"Be","2"},{"B","13"},{"C","14"},{"N","15"},{"O","16"},{"F","17"},
            {"Ne","18"},{"Na","1"},{"Mg","2"},{"Al","13"},{"Si","14"},{"P","15"},{"S","16"},{"Cl","17"},{"Ar","18"},{"K","1"},{"Ca","2"},
            {"Sc","3"},{"Ti","4"},{"V","5"},{"Cr","6"},{"Mn","7"},{"Fe","8"},{"Co","9"},{"Ni","10"},{"Cu","11"},{"Zn","12"},{"Ga","13"},
            {"Ge","14"},{"As","15"},{"Se","16"},{"Br","17"},{"Kr","18"},{"Rb","1"},{"Sr","2"},{"Y","3"},{"Zr","4"},{"Nb","5"},{"Mo","6"},
            {"Tc","7"},{"Ru","8"},{"Rh","9"},{"Pd","10"},{"Ag","11"},{"Cd","12"},{"In","13"},{"Sn","14"},{"Sb","15"},{"Te","16"},
            {"I","17"},{"Xe","18"},{"Cs","1"},{"Ba","2"},

            {"La","-11"},{"Ce","-12"},{"Pr","-13"},{"Nd","-14"},{"Pm","-15"},{"Sm","-16"},{"Eu","-17"},{"Gd","-18"},
            {"Tb","-19"},{"Dy","-20"},{"Ho","-21"},{"Er","-22"},{"Tm","-23"},{"Yb","-24"},{"Lu","-25"},

            {"Hf","4"},{"Ta","5"},{"W","6"},{"Re","7"},{"Os","8"},{"Ir","9"},{"Pt","10"},{"Au","11"},{"Hg","12"},{"Tl","13"},{"Pb","14"},
            {"Bi","15"},{"Po","16"},{"At","17"},{"Rn","18"},{"Fr","1"},{"Ra","2"},

            {"Ac","-31"},{"Th","-32"},{"Pa","-33"},{"U","-34"},{"Np","-35"},{"Pu","-36"},{"Am","-37"},{"Cm","-38"},
            {"Bk","-39"},{"Cf","-40"},{"Es","-41"},{"Fm","-42"},{"Md","-43"},
            {"No","-44"},{"Lr","-45"},

            {"Rf","4"},{"Db","5"},{"Sg","6"},{"Bh","7"},{"Hs","8"},{"Mt","9"},{"Ds","10"},{"Rg","11"},{"Cn","12"},{"Uut","13"},{"Fl","14"},{"Uup","15"},{"Lv","16"},{"Uus","17"},{"Uuo","18"}};



    public PeriodicTable()
    {

        String user_input = null;
        readTable();

        System.out.println("Display lanthinides and actinides? y/n?");
        user_input=INPUT.nextLine();

        if (user_input == "y"){
            displayGroup = true;
        }

        starting_number = promptForInt("Enter starting element number:");
        end_number = promptForInt("Enter ending element number:");
    }


    /**
     * Converts the hardcoded table data into three arrays:
     * MAIN_PERIODIC_TABLE
     * LANTHANIDE_TABLE
     * ACTINIDE_TABLE
     */
    private void readTable()
    {
        for (int selected_atomic_number = 0; selected_atomic_number < RAW_ATOMIC_TABLE.length; selected_atomic_number++) {

            int selected_atomic_group  = Integer.parseInt(RAW_ATOMIC_TABLE[selected_atomic_number][1]);


            //Normal case
            if (selected_atomic_group > 0){
                MAIN_PERIODIC_TABLE[selected_atomic_number] = RAW_ATOMIC_TABLE[selected_atomic_number];
            }

            //Lanthanide case
            else if (
                    selected_atomic_group >= LANTHANIDE_SEPERATOR_START
                            &&
                            LANTHANIDE_SEPERATOR_END >= selected_atomic_group)
            {
                insertIntoGroup(
                        selected_atomic_group,
                        selected_atomic_number,
                        LANTHANIDE_TABLE,
                        LANTHANIDE_SEPERATOR_END);
            }

            //Actinide case
            else if (
                    selected_atomic_group >= ACTINIDE_SEPERATOR_START
                            &&
                            ACTINIDE_SEPERATOR_END >= selected_atomic_group)
            {
                insertIntoGroup(
                        selected_atomic_group,
                        selected_atomic_number,
                        ACTINIDE_TABLE,
                        ACTINIDE_SEPERATOR_END);
            }
        }
    }

    /**
     * Used to take the negatively grouped hard coded lanthanide/actinide data and
     * correct and store its information
     * @param selected_atomic_group the initial, negative value
     * @param selected_atomic_number the correct atomic number
     * @param selected_group_array the target array
     * @param offset_value the correction to be applied to the initial negative value
     */
    private void insertIntoGroup(
            int selected_atomic_group,
            int selected_atomic_number,
            String[][] selected_group_array,
            int offset_value)
    {
        selected_group_array[offset_value - selected_atomic_group] =

                new String[]{
                        RAW_ATOMIC_TABLE[selected_atomic_number][0],


                        String.valueOf(
                                Integer.parseInt(
                                        RAW_ATOMIC_TABLE[selected_atomic_number][1])
                                        + offset_value)


                };
    }

    /**
     * Safely get an int from the user
     * @param prompt
     * @return
     */
    private int promptForInt(String prompt)
    {
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


    /**
     * Add spaces to a string to make it meet a minimum length
     * @param input the string to be modified
     * @param length the length to be achieved
     * @return the modified string
     */
    private String padString(String input, int length){
        StringBuilder pad_buffer = new StringBuilder().append(input);
        pad_buffer.append(input);

        if (input.length() < length){
            pad_buffer.append(" ".repeat(length - input.length()));

            return pad_buffer.toString();
        }
        else return input;
    }

    /**
     * Prints either groups table or the main periodic table
     * @param table the table to print
     */
    private void printTable(String[][] table){
        StringBuilder render_buffer = new StringBuilder();
        int desired_position = starting_number;
        int position = 0;


        while(position <= end_number){

            int row = position % TABLE_WIDTH;

            while(position % TABLE_WIDTH == row) {

                if (desired_position == position) {
                    render_buffer
                            .append(padString(table[position][0], 2))
                            .append(" ")
                            .append(padString(table[position][1], 2))
                            .append(" ");

                }
                else
                {
                    render_buffer.append("      ");
                }

                position++;
            }
        }



        System.out.println(render_buffer);
    }


    @Override
    public void printTables() {
        printTable(MAIN_PERIODIC_TABLE);

    }

    @Override
    public void printGroups() {
    }
}
