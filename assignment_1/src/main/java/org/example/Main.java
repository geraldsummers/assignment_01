package org.example;
/**
 * KIT107 Assignment 1
 *
 * Periodic Table Printer
 *
 * @author J. Dermoudy
 * @version 30/7/2024
 *
 * This file is COMPLETE.
 *
 */


/**
 * Table handling:
 * each element specifies it's column
 * each row must have 18 entries
 * if none specified blank
 *
 * function 1 reads table into second table based upon column positions specified unless the column is negative which
 * specifies that it is a lanthanide or actinide in which case it is read into a lanthanide or actinide array
 * to be appended once the initial array has been finished
 *
 */

public class Main
{
    /**
     * main() -- entry point
     *
     * @param args -- command line arguments
     */
    public static void main(String args[])
    {
        PeriodicTable p;

        // create PeriodicTable object
        p=new PeriodicTable();

        System.out.println("\t\t\t\t\t\t\t\t Periodic Table");
        System.out.println("\t\t\t\t\t\t\t\t ==============");
        // show (portion of) periodic table
        p.printTables();
        p.printGroups();
    }
}