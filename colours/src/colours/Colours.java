import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A program to pair names with randomly shuffled colors and provide descriptive comments.
 */
public class Colours {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    // Get the number of names and colors
    int numNames = getPositiveInteger(scanner, "Enter the number of names and colors: ");
    
    // Create lists to store names and colors
    List<String> names = new ArrayList<>();
    List<String> colors = new ArrayList<>();
    
    // Get the names
    System.out.println("Enter the names:");
    for (int i = 0; i < numNames; i++) {
      String name = getNonEmptyString(scanner, "Name " + (i + 1) + ": ");
      names.add(name);
    }
    
    // Get the colors
    System.out.println("Enter the colors:");
    for (int i = 0; i < numNames; i++) {
      String color = getNonEmptyString(scanner, "Color " + (i + 1) + ": ");
      colors.add(color);
    }
    
    // Shuffle the colors to create random pairs
    Collections.shuffle(colors);
    
    // Print the pairs with descriptive comments
    for (int i = 0; i < numNames; i++) {
      String colorDescription = getColorDescription(colors.get(i));
      System.out.println(names.get(i) + " - " + colors.get(i) + ": " + colorDescription);
    }
  }

  /**
   * Helper method to get a positive integer from the user.
   * 
   * @param scanner  the scanner object to read user input
   * @param prompt   the prompt to display to the user
   * @return         a positive integer entered by the user
   */
  private static int getPositiveInteger(Scanner scanner, String prompt) {
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

  /**
   * Helper method to get a non-empty string from the user.
   * 
   * @param scanner  the scanner object to read user input
   * @param prompt   the prompt to display to the user
   * @return         a non-empty string entered by the user
   */
  private static String getNonEmptyString(Scanner scanner, String prompt) {
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

  /**
   * Helper method to get a descriptive comment based on the color.
   * 
   * @param color  the color to get a description for
   * @return       a descriptive comment for the color
   */
  private static String getColorDescription(String color) {
    switch (color.toLowerCase()) {
      case "red":
        return "You are fury";
      case "yellow":
        return "You are golden";
      case "white":
        return "You are angelic";
      case "black":
        return "you are bold";
      default:
        return "I can't figure you out";
    }
  }
}
