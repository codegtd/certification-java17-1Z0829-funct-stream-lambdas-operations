package reduction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Reduce_Identity {
  private static void writeRandomNumbersToFile(String fileName) throws IOException {

    Random r = new Random();
    String numbersList;

    try (FileWriter stream = new FileWriter(fileName)) {
      for (int i = 0; i < 10; i++) {
        numbersList = r.ints(7, 1, 9)
                       .mapToObj((s) -> String.valueOf(s))
                       .reduce("->", (string, element) -> String.join(" <> ", string, element));
        System.out.println(numbersList);
        stream.write(numbersList + "\n");
      }
    }
  }

  public static void main(String[] args) throws IOException {

    writeRandomNumbersToFile("characterData.txt");

  }
}