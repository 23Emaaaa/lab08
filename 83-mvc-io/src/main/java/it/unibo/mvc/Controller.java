package it.unibo.mvc;

import java.util.List;

//THIS IS A JAVADOC --> u can see it through the the use of /** */

/**
 * The controller considers the standard output (able to print on it):
 */
public interface Controller {
    /**
    * #1 --> setting the next string to print:
    * @param printNextString is the String to print "next"
    */
    void set_next_string_print(String printNextString);
    /**
    * #2 --> getting the next string to print:
    * @return next String to print
    */
    String get_next_string_print();
    /**
    * #3 --> getting the history of printed strings (List and Strings form):
    * @return the printed String history into the form of "List of String" 
    */
    List<String> get_history_printed_string();
    /**
    * #4 --> prints the current string:
    */
    void print_current_string();
}