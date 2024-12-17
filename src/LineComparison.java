import java.util.Scanner;

class Line implements Comparable<Line> {
    private final int x1, y1, x2, y2;

    // Constructor to initialize line endpoints
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // UC-1: Method to calculate the length of the line
    public double calculateLength() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // UC-2: Method to compare lengths of two lines for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        return Double.compare(this.calculateLength(), other.calculateLength()) == 0;
    }

    // UC-3: Method to compare two lines (greater, equal, or less)
    @Override
    public int compareTo(Line other) {
        return Double.compare(this.calculateLength(), other.calculateLength());
    }
}
public class LineComparison{
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");

        Scanner scanner = new Scanner(System.in);

        // Input for the first line
        System.out.println("Enter coordinates of Line 1 (x1, y1, x2, y2): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        // UC-1: Calculate the length of a line
        Line line1 = new Line(x1, y1, x2, y2);
        System.out.printf("Length of Line 1: %.2f%n", line1.calculateLength());

        // Input for the second line
        System.out.println("Enter coordinates of Line 2 (x3, y3, x4, y4): ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int x4 = scanner.nextInt();
        int y4 = scanner.nextInt();

        // UC-2: Compare the lengths of Line 1 and Line 2
        Line line2 = new Line(x3, y3, x4, y4);
        System.out.printf("Length of Line 2: %.2f%n", line2.calculateLength());

        if (line1.equals(line2)) {
            System.out.println("Line 1 and Line 2 are Equal");
        } else {
            System.out.println("Line 1 and Line 2 are Not Equal");
        }

        // UC-3: Compare two lines
        int comparisonResult = line1.compareTo(line2);

        if (comparisonResult == 0) {
            System.out.println("Line 1 is equal to Line 3.");
        } else if (comparisonResult > 0) {
            System.out.println("Line 1 is greater than Line 3.");
        } else {
            System.out.println("Line 1 is less than Line 3.");
        }
    }
}


