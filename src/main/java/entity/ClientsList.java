package entity;

import java.util.Arrays;
import java.util.List;

public class ClientsList {


  public static List<Client> getAllClients() {

    return List.of(
         new Client(2, "smith", "sm@gmail.com", Arrays.asList("89", "24")),
         new Client(1, "john", "jo@gmail.com", Arrays.asList("39", "21")),
         new Client(3, "peter", "pe@gmail.com", Arrays.asList("38", "32")),
         new Client(4, "kely", "ke@gmail.com", Arrays.asList("38", "94"))
    );
  }


}