package learn.features;

import learn.features.java20.Position;
import learn.features.java20.PositionInJava11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Position pos19 = new Position(4,5);
        System.out.println("Print in Java 19 " + pos19.x() + pos19.y());


        PositionInJava11 pos11 = new PositionInJava11(4,5);
        System.out.println("Position in Java11 " + pos11.getX() + " " + pos11.getY());


        List<Position> positions = new ArrayList<>();
        positions.add(pos19);

        // JAVA 20
        for (Position p : positions) {
            System.out.printf("(%d, %d)%n", p.x(), p.y());
        }

    }
}