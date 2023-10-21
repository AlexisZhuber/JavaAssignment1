// Import the 'gui_swing_events' package where the SwingEventWindow class is located.
package gui_swing_events;

// Main class that contains the 'main' method.
public class Main {
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure that the creation
        // of the Swing GUI happens in the Swing event thread, where GUI-related
        // operations should take place.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create a new instance of the SwingEventWindow class,
                // representing the main graphical user interface window.
                new SwingEventWindow();
            }
        });
    }
}
