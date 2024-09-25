package colours;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Colours {
  public static void main(String[] args) {
    // Create a scanner to read user input
    Scanner scanner = new Scanner(System.in);

    // Get the number of names and colors from the user
    int numNames = getPositiveInteger(scanner, "Enter the number of names and colors: ");

    // Create lists to store the names and colors
    List<String> names = new ArrayList<>();
    List<String> colors = new ArrayList<>();

    // Get the names from the user
    System.out.println("Enter the names:");
    for (int i = 0; i < numNames; i++) {
      String name = getNonEmptyString(scanner, "Name " + (i + 1) + ": ");
      names.add(name);
    }

    // Get the colors from the user
    System.out.println("Enter the colors:");
    for (int i = 0; i < numNames; i++) {
      String color = getNonEmptyString(scanner, "Color " + (i + 1) + ": ");
      colors.add(color);
    }

    // Shuffle the colors to randomize the pairing
    Collections.shuffle(colors);

    // Print the pairs of names and colors with their descriptions
    for (int i = 0; i < numNames; i++) {
      String colorDescription = getColorDescription(colors.get(i));
      System.out.println(names.get(i) + " - " + colors.get(i) + ": " + colorDescription);
    }
  }

  // Helper method to get a positive integer from the user
  private static int getPositiveInteger(Scanner scanner, String prompt) {
    // Loop until the user enters a positive integer
    while (true) {
      try {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (value > 0) {
          return value;
        } else {
          System.out.println("Please enter a positive integer.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
        scanner.nextLine(); // Consume invalid input
      }
    }
  }

  // Helper method to get a non-empty string from the user
  private static String getNonEmptyString(Scanner scanner, String prompt) {
    // Loop until the user enters a non-empty string
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      if (!value.isEmpty()) {
        return value;
      } else {
        System.out.println("Please enter a non-empty string.");
      }
    }
  }

  // Helper method to get a color description based on the color
  private static String getColorDescription(String color) {
    // Use a switch statement to return a description based on the color
    switch (color.toLowerCase()) {
      case "red":
        return "You are fury";
      case "yellow":
        return "You are golden";
      case "white":
        return "You are angelic";
      case "black":
      default:
        return "You are bold";
    }
  }
}
