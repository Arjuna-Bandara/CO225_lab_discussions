import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class MainApp {

    static LinkedList<Person> list = new LinkedList<>();
    static String[] argsInputs = null;

    public static void main(String[] args) {
        argsInputs = args;          //save args in static variable
        printWelcomeText();         //welcome text
        loadTextFile("sample.csv"); //read csv file and load to linkedlist
        searchPhoneNumber();        //search for the contact
    }

    // search for the phonenumber
    private static void searchPhoneNumber() {
        String[] searchText = null;
        String userConsoleInput = null;

        if (list == null || list.size() == 0) {
            System.out.println("Contact list is not loaded correctly.");

        }

        // when arguments are passed via console
        if (argsInputs != null && argsInputs.length > 0) {
            userConsoleInput = argsInputs[0];
            searchText = userConsoleInput.split(":");
        } else {
            userConsoleInput = promptInput().toLowerCase();
            searchText = userConsoleInput.split(":");
        }

        if (userConsoleInput.equals("quit")) {
            System.out.println("bye!");
            return;
        }
        if (searchText == null || searchText.length <= 1) {
            System.out.println("Invalid input format. Try again!");
            return;
        }

        // search by first name
        if (searchText[0].equalsIgnoreCase("f")) {
            for (Person person : list) {
                if (person.getFirstName().equalsIgnoreCase(searchText[1])) {
                    System.out.println(
                            person.getFirstName() + " " + person.getLastName() + " " + person.getPhoneNumber());
                }
            }
        }
        // search by last name
        if (searchText[0].equalsIgnoreCase("l")) {
            for (Person person : list) {
                if (person.getLastName().equalsIgnoreCase(searchText[1])) {
                    System.out.println(
                            person.getFirstName() + " " + person.getLastName() + " " + person.getPhoneNumber());
                }
            }
        }

    }

    // read commandline inputs
    private static String promptInput() {
        System.out.print("Enter name <F:Name> or <L:Name>: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        return s;

    }

    // initialize person and load object to the list.
    // This use loadToList() method to split data from text line.
    // Assumming that each line has 3 fields for loadToList() method. Otherwise this
    // return null object
    private static void loadTextFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // Person person = null;
            String line = br.readLine();

            while (line != null) {
                Person person = loadToList(line);
                list.add(person);
                line = br.readLine();
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // welcome msg with user instruction
    private static void printWelcomeText() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Phone book");
        System.out.println("To search ---> Enter F:<firstName> or L:<LastName> to search.");
        System.out.println("To quit   ---> Enter quit");
        System.out.println("----------------------------------------------------------------");
    }

    // CSV string with 3 fields for fname,lname and phone.
    // this will return person
    private static Person loadToList(String line) {
        String[] splittedText = line.split(",");

        if (splittedText != null) {
            return new Person(splittedText[0], splittedText[1], splittedText[2]);
        } else {
            return new Person();
        }

    }
}
