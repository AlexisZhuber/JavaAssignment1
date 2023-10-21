package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEventWindow {
    private int selectedRadioButton = 1; // Default to the first radio button

    public SwingEventWindow() {
        // Create a JFrame (main application window)
        JFrame frame = new JFrame("Swing Events Assignment");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Create and configure various panels and components
        JPanel mainPanel = new JPanel();
        JPanel panel1 = new JPanel(); // Contains the main label
        JPanel panel2 = new JPanel(); // Contains the input label
        JPanel panel3 = new JPanel(); // Contains the input text field
        JPanel panel4 = new JPanel(); // Contains radio buttons
        JPanel panel5 = new JPanel(); // Provides vertical spacing
        JPanel panel6 = new JPanel(); // Contains the calculation button, result label, and output field

        JLabel lblMain = new JLabel("Excel Functions");
        JLabel lblRequest = new JLabel("Enter your numbers separated by spaces");
        JTextField txtNum = new JTextField(20);

        JRadioButton rdoTotal = new JRadioButton("Total");
        JRadioButton rdoAvg = new JRadioButton("Average");
        JRadioButton rdoMax = new JRadioButton("Max");
        JRadioButton rdoMin = new JRadioButton("Min");
        ButtonGroup buttonGroup = new ButtonGroup();
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultOutput = new JTextField(20);

        buttonGroup.add(rdoTotal);
        buttonGroup.add(rdoAvg);
        buttonGroup.add(rdoMax);
        buttonGroup.add(rdoMin);

        // Set up layout managers for panels
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        panel5.setLayout(new FlowLayout());
        panel6.setLayout(new FlowLayout());

        // Add components to panels
        panel1.add(lblMain);
        panel2.add(lblRequest);
        panel3.add(txtNum);

        // Add radio buttons to panel4
        panel4.add(rdoTotal);
        panel4.add(rdoAvg);
        panel4.add(rdoMax);
        panel4.add(rdoMin);

        // Define vertical spacing
        int verticalSpacing = 10;

        // Add vertical spacers for spacing between panels
        panel5.add(Box.createVerticalStrut(verticalSpacing));

        // Add the calculation button
        panel5.add(calculateButton);

        // Add vertical space between the calculation button and panel6
        panel6.add(Box.createVerticalStrut(verticalSpacing));

        // Add result label and its output field
        panel6.add(resultLabel);
        panel6.add(resultOutput);

        // Configure the main panel with a BoxLayout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add the panels to the main panel
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Set the "Total" radio button as the default
        rdoTotal.setSelected(true);

        // Add action listeners for radio buttons
        rdoTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRadioButton = 1; // Total option selected
            }
        });

        rdoAvg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRadioButton = 2; // Average option selected
            }
        });

        rdoMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRadioButton = 3; // Max option selected
            }
        });

        rdoMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRadioButton = 4; // Min option selected
            }
        });

        // Add an action listener for the calculation button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtNum.getText();
                if (!input.isEmpty()) {
                    Excel excel = new Excel(input);

                    // Determine the selected radio button and perform the corresponding calculation
                    if (selectedRadioButton == 1) {
                        double total = excel.findTotal();
                        resultOutput.setText(Double.toString(total));
                    } else if (selectedRadioButton == 2) {
                        double avg = excel.findAvg();
                        resultOutput.setText(Double.toString(avg));
                    } else if (selectedRadioButton == 3) {
                        double max = excel.findMax();
                        resultOutput.setText(Double.toString(max));
                    } else if (selectedRadioButton == 4) {
                        double min = excel.findMin();
                        resultOutput.setText(Double.toString(min));
                    }
                } else {
                    resultOutput.setText("Input is empty"); // Display an error message
                }
            }
        });
    }
}
