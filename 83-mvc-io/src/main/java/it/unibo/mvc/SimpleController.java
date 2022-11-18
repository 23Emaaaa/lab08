package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    @Override
    public void set_next_string_print(String printNextString) {
        
    }

    @Override
    public String get_next_string_print() {
        return null;
    }

    @Override
    public List<String> get_history_printed_string() {
        return null;
    }

    @Override
    public void print_current_string() {
    }

}
