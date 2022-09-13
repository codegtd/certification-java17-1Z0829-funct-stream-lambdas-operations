package collector;

import entity.CollectStudent;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector_Average {
  public static void main(String[] args) {

    double average = new
         Random().ints(1, 100_000)
                 .limit(1000)
                 .boxed()
                 .collect(Collectors.averagingInt((s) -> s));

    show("average of random integers = " + average);

    double AverageGPA =
         Stream.of(new CollectStudent("Jeff", 2.7f),
                   new CollectStudent("Carol", 3.5f))
               .collect(Collectors.averagingDouble(CollectStudent::getGpa));

    show(String.format("Average GPA = %.2f", AverageGPA));
  }

  private static void show(String text) {

    System.out.println(text);
  }
}