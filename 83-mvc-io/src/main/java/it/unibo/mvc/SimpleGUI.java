package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final String PRINT = "Print";
    private static final String HISTORY = "History";
    private final Controller controller;

     /**
     * #2 sets up the whole view:
     * #3 sets the graphical interface: 
     */
    public SimpleGUI() {
        
        public SimpleGUI(Controller controller) {
        this.controller = controller;
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setBackground(Color.BLACK);
        canvas.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel canvas2 = new JPanel();
        canvas2.setLayout(new BoxLayout(canvas2, BoxLayout.LINE_AXIS));
        canvas.add(canvas2, BorderLayout.SOUTH); 
        final JButton printButton = new JButton(PRINT);
        final JButton historyButton = new JButton(HISTORY);
        canvas2.add(printButton);
        canvas2.add(historyButton);
        frame.setContentPane(canvas);
    /**
    * #4 Graphic interface closed by default:
    *
    */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /**
     * Handlers:
     */
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                SimpleGUI.this.controller.set_next_string_print(textField.getText());
                SimpleGUI.this.controller.print_current_string();
            }
        });

        historyButton.addActionListener (new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                StringBuilder sBuilder = new StringBuilder();
                List<String> show_history = SimpleGUI.this.controller.get_history_printed_string();
                for (String printStr: show_history) {
                    sBuilder.append(printStr);
                    sBuilder.append("\n");
                }   
                if (!show_history.isEmpty()) {
                    sBuilder.deleteCharAt(sBuilder.length() - 1);
                }
                textArea.setText(sBuilder.toString());
            }
        });
        /**
        * Setting the resolution on the screen and setting the appearence by the platform, 
        * then it chasnges are based on the device OS:
        */
        final Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        final int setHeight = (int) screen_size.getHeight();
        final int setWidth = (int) screen_size.getWidth();
        frame.setSize(setHeight / 2, setWidth / 2);    
        frame.setLocationByPlatform(true);
    }
        //reveals a Component by marking it as visible:
        private void display() {
            frame.setVisible(true);
        }
        /**
         * 
        * @param args 
        * they're not used...
        */
        public static void main(final String[] args) {
            new SimpleGUI(new SimpleController()).display();
        }

}