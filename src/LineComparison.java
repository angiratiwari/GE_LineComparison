import java.util.Scanner;

// Point class to represent coordinates (x, y)
class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// Line class to represent a line and implement comparison logic
class Line implements Comparable<Line> {
    private final Point start, end;

    // Constructor to initialize line with two points
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Method to calculate the length of the line
    public double calculateLength() {
        return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow((end.getY() - start.getY()), 2));
    }

    // UC-2: Check equality of two lines
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        return Double.compare(this.calculateLength(), other.calculateLength()) == 0;
    }

    // UC-3 & UC-4: Compare two lines using compareTo method
    @Override
    public int compareTo(Line other) {
        return Double.compare(this.calculateLength(), other.calculateLength());
    }
}

public class LineComparison {
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");
        Scanner scanner = new Scanner(System.in);

        // UC-1: Input for the first line
        System.out.println("Enter coordinates of Line 1 (x1 y1 x2 y2): ");
        Point start1 = new Point(scanner.nextInt(), scanner.nextInt());
        Point end1 = new Point(scanner.nextInt(), scanner.nextInt());
        Line line1 = new Line(start1, end1);
        System.out.printf("Length of Line 1: %.2f%n", line1.calculateLength());

        // Input for the second line
        System.out.println("Enter coordinates of Line 2 (x1 y1 x2 y2): ");
        Point start2 = new Point(scanner.nextInt(), scanner.nextInt());
        Point end2 = new Point(scanner.nextInt(), scanner.nextInt());
        Line line2 = new Line(start2, end2);
        System.out.printf("Length of Line 2: %.2f%n", line2.calculateLength());

        // UC-2: Check equality of the two lines
        if (line1.equals(line2)) {
            System.out.println("Line 1 and Line 2 are Equal");
        } else {
            System.out.println("Line 1 and Line 2 are Not Equal");
        }

        // UC-3 & UC-4: Compare the two lines
        int comparisonResult = line1.compareTo(line2);
        if (comparisonResult > 0) {
            System.out.println("Line 1 is Greater than Line 2");
        } else if (comparisonResult < 0) {
            System.out.println("Line 1 is Less than Line 2");
        } else {
            System.out.println("Line 1 and Line 2 are Equal in Length");
        }

        scanner.close();
    }
}
