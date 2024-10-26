package Week4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Week4CodingProject {

	public static void main(String[] args) {
		
		
		// 1. Created an array of int called ages
		
        int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
        
        // 1.(a) Subtract the value of the first element from the value of the last & print
        
        int diffrence = ages[ages.length - 1] - ages[0];
        
        System.out.println(diffrence);
        
        //1.(b)New array, ages 2, with 9 elements & repeat subtraction.
        
        int[] ages2 = {3, 9, 23, 64, 2, 8, 28, 93, 45};
        
        int diffrence2 = ages2[ages2.length - 1] - ages2[0];
        
        System.out.println(diffrence2);
        
        // because we use the length property it will remain dynamic.
        //The code with always select the 1st and last value.
        
        int[] ages3 = {10, 20, 30, 40};
        int[] ages4 = {5, 15, 25};

        System.out.println(ages3[ages3.length - 1] - ages3[0]);
        System.out.println(ages4[ages4.length - 1] - ages4[0]);
        
        //1.(c) Enhanced for loop to calculate average & print result
        
        int sum = 0;
        
        for (int age : ages) {
            sum += age;
        }
        
        System.out.println((double) sum / ages.length);
        
        //2. Create new string array of names
        
        String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
        
        //2a. Used enhanced for loop to calculate average & print average.
        
        int sumOfLetters = 0;
        
        for (String name : names) {
        	 sumOfLetters += name.length();
        }
        
         System.out.println((double) sumOfLetters / names.length);
         
         //2b. Used loop to concatenate name separated by spaces & print.
         
         String concatenatedNames = "";
         
         for (int i = 0; i < names.length; i++) {
             concatenatedNames += names[i];
             if (i < names.length - 1) {
                 concatenatedNames += " ";
             }
         }

         System.out.println(concatenatedNames);
         
         //3. array[array.length - 1]. This works because arrays in Java are zero-indexed, 
         //so the last element is always at the position
         
         //4. array[0]. This works because indexing in Java starts at 0, 
         // therefore the first element always located at index 0.
         
         //5. Created new array nameLength & loop to add the length of names to the array.
         
         int[] nameLengths = new int[names.length];

         for (int i = 0; i < names.length; i++) {
             nameLengths[i] = names[i].length();
         }
         
         //6. Created loop to calculate sum of names & print results.
         
         int sum2 = 0;
         
         for (int length : nameLengths) {
             sum2 += length;
         }

         System.out.println(sum2);
         
         //7. Example of method in action. Method is called to return concatenated word/# of times.
         
         System.out.println(repeatWord("Coding", 5));
         
         //8. Example of method in action. Method takes 2 strings concatenates them and returns with a space.
         
         String fullName = getFullName("Trent", "Lell");
         System.out.println(fullName);
         
         /*9. Example of method in action. Method determines if sum is greater that 100 (true) or less
          * than (false) and returns the boolean value.		 
          */
         
         int[] numbers = {0, 0, 25};
         boolean result = sumGreaterThan100(numbers);
         System.out.println(result);
         
         //10.Example of method. Method takes an array of doubles and returns the average.
         
         double[] numbers2 = {10.5, 20.37, 3.45, 71.5};
         double average = calculateAverage(numbers2);
         System.out.println(average);
         
         //11. Method takes the averages of 2 arrays and returns true if the average of the 1st array is
         //greater than the average of the 2nd array.
         
         double[] array1 = {5.0, 15.0, 25.0};
         double[] array2 = {10.5, 20.0, 30.0};
         
         boolean result2 = compareAverages(array1, array2);
         System.out.println(result2);
         
         //12. Method uses a boolean to return whether or not to buy a drink if it is hot outside
         //AND if money in pocket is greater than $10.50.
         
         boolean isHotOutside = true;
         double moneyInPocket = 4.99;
         
         boolean result3 = willBuyDrink(isHotOutside, moneyInPocket);
         System.out.println(result3);
         
         //13. I devised a method to take input from the user and calculate the number of days remaining
         // to the next new year. It will also give an error message if the input is not in the correct
         //style and loop the input request until it is correct.
         
         Scanner scanner = new Scanner(System.in);
         
         LocalDate currentDate = null;
         
         while (currentDate == null) {
             System.out.print("Enter a date (YYYY-MM-DD): ");
             String inputDate = scanner.nextLine();
             try {
                 currentDate = LocalDate.parse(inputDate);
             } catch (DateTimeParseException e) {
                 System.out.println("Invalid date format. Please use YYYY-MM-DD.");
             }
         }

         String countdownMessage = countdownToNewYear(currentDate);
         System.out.println(countdownMessage);
         
         scanner.close();
         
	   }
	
	/*
	 * The countdownToNewYear method calculates the remaining time until the next New Year based on a 
	 * given date. It accepts a LocalDate object representing the current date and checks if this date 
	 * is before January 1st of the current year. If so, it sets nextNewYear to January 1st of the current 
	 * year, otherwise, it sets it to January 1st of the following year. The method then uses Period.between 
	 * to compute the difference in months and days between the current date and nextNewYear. Lastly, 
	 * it returns a string that summarizes the countdown, providing the user with the exact months and days 
	 * remaining until the next New Year.
	 */

    public static String countdownToNewYear(LocalDate currentDate) {
        LocalDate nextNewYear;
        if (currentDate.isBefore(LocalDate.of(currentDate.getYear(), 1, 1))) {
            nextNewYear = LocalDate.of(currentDate.getYear(), 1, 1);
        } else {
            nextNewYear = LocalDate.of(currentDate.getYear() + 1, 1, 1);
        }
        Period period = Period.between(currentDate, nextNewYear);
        return "Countdown to New Year: " + period.getMonths() + " months, and " + 
               period.getDays() + " days remaining until January 1.";
         
	}

    /*
     * This method takes two parameters: a boolean isHotOutside that indicates the weather condition and a 
     * double moneyInPocket representing the available funds. The method returns true if both conditions 
     * are satisfied, allowing for a drink purchase; otherwise, it returns false. 
     * This code encapsulates the decision-making process for buying a drink under 
     * specified conditions.
     */
    
    public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
        return isHotOutside && moneyInPocket > 10.50;
         
	}
    
    /*
     * The compareAverages method compares the averages of two arrays of doubles, array1 and array2. 
     * It first calculates the average of each array by calling the calculateAverage method for both inputs. 
     * The method then evaluates whether the average of array1 is greater than that of array2. 
     * It returns true if this condition is met, indicating that the first array's average is higher, 
     * otherwise, it returns false.
     */
	
	
    public static boolean compareAverages(double[] array1, double[] array2) {
        double average1 = calculateAverage(array1);
        double average2 = calculateAverage(array2);
        return average1 > average2;
         
	}

   /*
    * The calculateAverage method computes the average of all elements in a given array of doubles. 
    * It takes a single parameter, numbers, which is the array whose average is to be calculated. 
    * The method initializes a variable to accumulate the sum of the elements and uses a loop to iterate 
    * through the array, adding each element to the sum. After summing all the elements, 
    * it divides the total sum by the length of the array to obtain the average. 
    * The method returns this average value.
    */
   
    public static double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
         
                  
	 }
    
    /*
     * The sumGreaterThan100 method determines whether the sum of the integers in a given array exceeds 100.
     * It accepts a single parameter, numbers, which is an array of integers. The method initializes a 
     * variable to keep track of the total sum and uses a loop to iterate through each element in the array, 
     * adding each integer to the sum. After completing the loop, the method checks if the total sum is 
     * greater than 100 and returns true if this condition is met; otherwise, it returns false.
     */

    
    public static boolean sumGreaterThan100(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum > 100;
         
	}
    
    /*
     * The getFullName method constructs a full name by concatenating a given first name and last name. 
     * It takes two parameters: firstName and lastName, both of which are strings. The method combines 
     * these two strings with a space in between to form a single string representing the full name. 
     * Finally, it returns this concatenated string.
     */

   
    public static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
         
                  
	}
    
    /*
     * The repeatWord method generates a string that repeats a specified word a given number of times. 
     * It takes two parameters: word, which is the string to be repeated, and n, which is an integer 
     * indicating how many times the word should be repeated. The method initializes an empty string called 
     * result and uses a loop that iterates n times, appending the word to the result string during each 
     * iteration. After the loop completes, the method returns the concatenated string.
     */

    public static String repeatWord(String word, int n) {
        String result = "";        
        for (int i = 0; i < n; i++) {
            result += word;
        }        
        return result;

    }

}
