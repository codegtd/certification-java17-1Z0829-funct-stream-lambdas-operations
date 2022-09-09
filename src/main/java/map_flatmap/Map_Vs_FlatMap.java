package map_flatmap;

import entity.Client;
import entity.ClientsList;

import java.util.List;
import java.util.stream.Collectors;

public class Map_Vs_FlatMap {
  public static void main(String[] args) {

    List<Client> clients = ClientsList.getAllClients();

/*╔═════════════════════════════════════════════════════════════════╗
  ║                 MAP METHOD - EXAMPLE 01                         ║
  ╠═════════════════════════════════════════════════════════════════╣
  ║ Transformation: List<Client> -> convert -> List<String>         ║
  ║ Mapping: one[input] to one[output]: client -> client.getEmail() ║
  ╠═════════════════════════════════════════════════════════════════╣
  ║HENCE: One item as Input To One item as Output.          use MAP ║
  ║- client[1 item] -> getEmail()[1 item]                           ║
  ╚═════════════════════════════════════════════════════════════════╝*/
    List<String> list_of_emails =
         clients
              .stream()
              .map(client -> client.getEmail())
              .collect(Collectors.toList());
    System.out.println("List: " + list_of_emails);

/*╔═════════════════════════════════════════════════════════════════╗
  ║                    MAP METHOD - EXAMPLE 02                      ║
  ╠═════════════════════════════════════════════════════════════════╣
  ║ Transformation: List<Client> -> convert -> List<List<String>>   ║
  ║ Mapping: one[input] to one[output]: client -> client.getPhones()║
  ╠═════════════════════════════════════════════════════════════════╣
  ║HENCE: One item as Input To One item as Output.          use MAP ║
  ║-client[1 item] -> getPhones()[1 item | "List of List-Phones"]   ║
  ╚═════════════════════════════════════════════════════════════════╝*/
    List<List<String>> list_of_PhoneLists =
         clients.
              stream()
              .map(client -> client.getPhones())
              .collect(Collectors.toList());
    System.out.println("List of Lists: " + list_of_PhoneLists);

/*╔═══════════════════════════════════════════════════════════════════╗
  ║                     FLAT-MAP METHOD - EXAMPLE 03                  ║
  ╠═══════════════════════════════════════════════════════════════════╣
  ║ Transformation: List<Client> -> convert -> List<String>(flatted)  ║
  ║ Mapping: one[input] to many[outputs]: client -> client.getPhones()║
  ╠═══════════════════════════════════════════════════════════════════╣
  ║HENCE: One item as Input To Many items as Outputs.    use FLAT-MAP ║
  ║-client[1 item] -> getPhones()[1 item | Full/Merged List-Phones]   ║
  ╚═══════════════════════════════════════════════════════════════════╝*/
    List<String> list_of_Phones =
         clients.stream()
                .flatMap(client -> client.getPhones().stream())
                .collect(Collectors.toList());
    System.out.println("List: " + list_of_Phones);
  }
}