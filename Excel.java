package gui_swing_events;

import java.util.ArrayList;

public class Excel {
    private ArrayList<Double> numbers = new ArrayList<>();

    // Constructor that takes an input string and parses it into numbers
    public Excel(String input) {
        // Split the input string into numbers separated by spaces
        String[] numStrings = input.split(" ");

        // Iterate through the number strings and try to parse them into doubles
        for (String numStr : numStrings) {
            try {
                double num = Double.parseDouble(numStr);
                numbers.add(num); // Add the parsed numbers to the ArrayList
            } catch (NumberFormatException e) {
                // Handle invalid format errors if necessary
                System.err.println("Error parsing number: " + numStr);
            }
        }
    }

    // Calculate and return the total of all numbers in the list
    public double findTotal() {
        double total = 0.0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }

    // Calculate and return the average of all numbers in the list
    public double findAvg() {
        double total = findTotal();
        return total / numbers.size();
    }

    // Find and return the maximum value among the numbers in the list
    public double findMax() {
        double max = Double.MIN_VALUE;
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Find and return the minimum value among the numbers in the list
    public double findMin() {
        double min = Double.MAX_VALUE;
        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
