import java.util.Random;
import java.util.Scanner;

/**
 * gradeCalculatorTester class collects the user input and calculates the
 * user's GPA while comparing it to random students GPAs
 * @author jEbreo
 * @author sLuyun
 * @version Semantic Versioning 2.0.0
 */
public class gradeCalculatorTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("How many courses are you taking?");
        int courseNumber = input.nextInt();
        input.nextLine(); // Removes the leftover newline from when the input was entered

        System.out.println("How many IB or AP classes are you taking?");
        int numberOfIBAndAP = input.nextInt();
        input.nextLine(); // Removes the leftover newline from when the input was entered

        System.out.println("How many Honors or Dual Enrollment classes are you taking?");
        int numberOfHAndDE = input.nextInt();
        input.nextLine(); // Removes the leftover newline from when the input was entered

        int onLevelCourses = courseNumber - numberOfIBAndAP - numberOfHAndDE;

        double totalUnweightedGrade = 0.0;
        double totalWeightedGrade = 0.0;

        // Collects grades for on level classes
        if (onLevelCourses > 0) {
            for (int i = 1; i <= onLevelCourses; i++) {
                System.out.println("What is your grade for your on level class? (A, B, C, D, or F)");
                String onLevelGrade = input.nextLine();
                gradeCalculator gradeCalc = new gradeCalculator("User", onLevelGrade, "" );
                totalUnweightedGrade += gradeCalc.getUnweightedGrade();
                totalWeightedGrade += gradeCalc.getWeightedGrade();
            }
        }

        // Collects grades for IB and AP classes
        if (numberOfIBAndAP > 0) {
            for (int i = 1; i <= numberOfIBAndAP; i++) {
                System.out.println("What is your grade for your AP/IB class? (A, B, C, D, or F)");
                String onePointBoost = input.nextLine();
                gradeCalculator gradeCalc = new gradeCalculator("User", onePointBoost, "AP");
                totalUnweightedGrade += gradeCalc.getUnweightedGrade();
                totalWeightedGrade += gradeCalc.getWeightedGrade();
            }
        }

        // Collects grade for Honors and Dual Enrollment classes
        if (numberOfHAndDE > 0) {
            for (int i = 1; i <= numberOfHAndDE; i++) {
                System.out.println("What is your grade for your Honors/Dual Enrollment class? (A, B, C, D, or F)");
                String onePointFiveBoost = input.nextLine();
                gradeCalculator gradeCalc = new gradeCalculator("User", onePointFiveBoost, "Honors");
                totalUnweightedGrade += gradeCalc.getUnweightedGrade();
                totalWeightedGrade += gradeCalc.getWeightedGrade();
            }
        }

        // Calculates unweighted and weighted GPAs
        double averageUnweightedGrade = totalUnweightedGrade / courseNumber;
        double averageWeightedGrade = totalWeightedGrade / courseNumber;

        // Displays GPAs
        System.out.println("Your Average Unweighted GPA: " + averageUnweightedGrade);
        System.out.println("Your Average Weighted GPA: " + averageWeightedGrade);

        // Generates random classmates and GPAs
        String nameOne = "Danny ";
        double unweightedGPAOne = 2.0 + (random.nextDouble() * 2.0);
        double weightedGPAOne = unweightedGPAOne + (random.nextDouble() * (5.0 - unweightedGPAOne));

        String nameTwo = "Ethan ";
        double unweightedGPATwo = 2.0 + (random.nextDouble() * 2.0);
        double weightedGPATwo = unweightedGPATwo + (random.nextDouble() * (5.0 - unweightedGPATwo));

        String nameThree = "Lucas ";
        double unweightedGPAThree = 2.0 + (random.nextDouble() * 2.0);
        double weightedGPAThree = unweightedGPAThree + (random.nextDouble() * (5.0 - unweightedGPAThree));

        String nameFour = "Jason ";
        double unweightedGPAFour = 2.0 + (random.nextDouble() * 2.0);
        double weightedGPAFour = unweightedGPAFour + (random.nextDouble() * (5.0 - unweightedGPAFour));

        String nameFive = "Avery ";
        double unweightedGPAFive = 2.0 + (random.nextDouble() * 2.0);
        double weightedGPAFive = unweightedGPAFive + (random.nextDouble() * (5.0 - unweightedGPAFive));

        int classRank = 1;

        // Compares user GPA with students GPA to determine class rank
        System.out.println("\nOther Students: ");
        if (weightedGPAOne > averageWeightedGrade) {
            classRank++;
        }
        System.out.printf("Name: %s, Unweighted GPA: %.2f, Weighted GPA: %.2f%n", nameOne, unweightedGPAOne, weightedGPAOne);

        if (weightedGPATwo > averageWeightedGrade) {
            classRank++;
        }
        System.out.printf("Name: %s, Unweighted GPA: %.2f, Weighted GPA: %.2f%n", nameTwo, unweightedGPATwo, weightedGPATwo);

        if (weightedGPAThree > averageWeightedGrade) {
            classRank++;
        }
        System.out.printf("Name: %s, Unweighted GPA: %.2f, Weighted GPA: %.2f%n", nameThree, unweightedGPAThree, weightedGPAThree);

        if (weightedGPAFour > averageWeightedGrade) {
            classRank++;
        }
        System.out.printf("Name: %s, Unweighted GPA: %.2f, Weighted GPA: %.2f%n", nameFour, unweightedGPAFour, weightedGPAFour);

        if (weightedGPAFive > averageWeightedGrade) {
            classRank++;
        }
        System.out.printf("Name: %s, Unweighted GPA: %.2f, Weighted GPA: %.2f%n", nameFive, unweightedGPAFive, weightedGPAFive);

        // Prints user class rank
        System.out.println("\nYour Class Rank: " + classRank);

        input.close();
    }
}
