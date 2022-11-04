package reduction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.join;

public class Reduce_Identity {
  private static void writeRandomNumbersToFile(String fileName) throws IOException {

    Random r = new Random();
    String strList;
    List<Integer> numbers = Arrays.asList(1, 2, 3);

    try (FileWriter stream = new FileWriter(fileName)) {

      strList =
           numbers
                .stream()
                .map(x -> x.toString())
                .reduce(
                     "->",
                     (letters, letterToAdd) ->
                          letters +"$"+ letterToAdd
                );
      show(strList);
      stream.write(strList + "\n");

    }

    numbers = Arrays.asList(1, 2, 3);
    int startValue = 1;

    show(numbers.toString());
    int result =
         numbers
              .stream()
              .reduce(
                   startValue,
                   (subtotal, totalizedItem) -> {
                     return subtotal + totalizedItem; //Integer::sum
                   }
              );
    show(String.valueOf(result));
  }

  public static void main(String[] args) throws IOException {

    writeRandomNumbersToFile("characterData.txt");

  }

  private static void show(String text) {

    System.out.println(text);
  }
}