package ex41;

import java.util.ArrayList;
import java.util.Collections;

public class NameSorter {
    public static void main(String[] args) {
        ArrayList<String> names = FileOps.readFile("src/main/java/ex41/exercise41_input.txt");
        if (names != null) {
            String sortedNames = sort(names);
            FileOps.writeFile("exercise41_output.txt", sortedNames);
            System.out.println("Total of " + names.size() + " names\n--------------------------");
            System.out.println(sortedNames);
            System.out.println("Wrote to " + System.getProperty("user.dir") + "/exercise41_output.txt");
        }
    }
    public static String sort(ArrayList<String> names){
        Collections.sort(names);
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            builder.append(name).append("\n");
        }
        return builder.toString();
    }
}
