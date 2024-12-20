/**
 * The gradeCalculator class represents student's names, grades, types of courses,
 * and calculates GPA decided by data given from gradeCalculatorTester.
 * @author jEbreo
 * @author sLuyun
 * @version Semantic Versioning 2.0.0
 */
public class gradeCalculator {
    String name;
    String grade;
    String type;
    double unWeightedGrade;
    double weightedGrade;

    /**
     * Makes a gradeCalculator object
     *
     * @param name  the name of student
     * @param grade the grade a student gets (A, B, C, D, F)
     * @param type  the type of course (Honors, AP, etc.)
     */
    public gradeCalculator(String name, String grade, String type) {
        this.name = name;
        this.grade = grade;
        this.type = type;
    }

    /**
     * Returns the name of the student
     *
     * @return student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets unweighted GPA depending on inputs
     *
     * @return the unweighted GPA
     * @throws IllegalArgumentException depending on user input
     */
    public double getUnweightedGrade() {
        switch (grade) {
            case "A":
            case "a":
                return 4.0;
            case "B":
            case "b":
                return 3.0;
            case "C":
            case "c":
                return 2.0;
            case "D":
            case "d":
                return 1.0;
            case "F":
            case "f":
                return 0.0;
            default:
                throw new IllegalArgumentException("Please reenter your grade.");

        }
    }

    /**
     * Sets the unweighted grade for student
     *
     * @param unWeightedGrade to set to weighted GPA
     * @return the unweighted GPA it was set to
     */
    public double setUnWeightedGrade(double unWeightedGrade) {
        this.unWeightedGrade = unWeightedGrade;
        return unWeightedGrade;
    }

    /**
     * Calculates GPA depending on course type
     *
     * @return the weighted GPA
     */
    public double getWeightedGrade() {
        if (grade.equals("F")) {
            return getUnweightedGrade();
        }

        switch (type) {
            case "AP":
            case "IB":
                return getUnweightedGrade() + 1.0;
            case "Honors":
            case "Dual Enrollment":
                return getUnweightedGrade() + 0.5;
            default:
                return getUnweightedGrade();
        }
    }

    /**
     * Sets the weighted grade for student
     *
     * @param weightedGrade to set to weighted GPA
     * @return the weighted GPA it was set to
     */
    public double setWeightedGrade(double weightedGrade) {
        this.weightedGrade = weightedGrade;
        return weightedGrade;
    }

    /**
     * Returns a string based on the user inputs from the gradeCalculator object
     *
     * @return prints user name, user unweighted GPA, and user weighted GPA
     */
    public String toString() {
        return "Name: " + name + ", Unweighted GPA: " + getUnweightedGrade() + ", Weighted GPA: " + getWeightedGrade();
    }
}

