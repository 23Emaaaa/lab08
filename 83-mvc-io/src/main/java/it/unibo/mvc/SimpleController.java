package it.unibo.mvc;

import java.util.List;


/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> History_str = new LinkedList()<>;
    private String nextString;

    @Override
    public void set_next_string_print(String nextString) {
        this.nextString = Objects.requireNonNull(nextString, "Cannot use null values");   
    }

    @Override
    public String get_next_string_print() {
        return this.nextString;
    }

    @Override
    public List<String> get_history_printed_string() {
        return null;
    }

    @Override
    public void print_current_string() {
    }

}
