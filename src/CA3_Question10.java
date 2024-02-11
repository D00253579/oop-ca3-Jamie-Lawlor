import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name:Jamie Lawlor
 *  Class Group: SD2B
 */
public class CA3_Question10
{

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("City.txt");
        //link Scanner object with the File

        Scanner input = new Scanner(inputFile);
        String line;
        String city1="";
        String city2="";
        int distance=0;

        while (input.hasNext()) {
            line = input.nextLine();
        String[]str1=line.split(",");
        city1=str1[0];
        city2=str1[1];
        distance=Integer.parseInt(str1[2]);
            System.out.println(city1);
            System.out.println(city2);
            System.out.println(distance+"\n");
        }

        Scanner key=new Scanner(System.in);
        String from;
        System.out.println("Starting point: ");
        //Getting the starting point
        from=key.next();
        //Creating the priority queue
        PriorityQueue<DistanceTo>queue=new PriorityQueue<DistanceTo>();
        //Adding the class to the queue
        queue.add(new DistanceTo(from,0));

Map <String,TreeSet<DistanceTo>> shortestKnownDistance=new HashMap<>();
//Adding values to the map
shortestKnownDistance.put("Pendleton",new TreeSet<>());
        shortestKnownDistance.put("Pierre",new TreeSet<>());
        shortestKnownDistance.put("Pueblo",new TreeSet<>());
        shortestKnownDistance.put("Peoria",new TreeSet<>());
        shortestKnownDistance.put("Pittsburgh",new TreeSet<>());
        shortestKnownDistance.put("Princeton",new TreeSet<>());
        shortestKnownDistance.put("Pensacola",new TreeSet<>());
        shortestKnownDistance.put("Phoenix",new TreeSet<>());

while(!queue.isEmpty()){
    //Getting the smallest element
    DistanceTo value= queue.peek();
    //Checking if the map contains the key attached to the smallest value in the queue
    if (!shortestKnownDistance.containsKey(value.getTarget())){
//Creating a TreeSet and adding target value and the distance to the target into the map.
        TreeSet<DistanceTo>d=new TreeSet<>();
d.add(new DistanceTo(value.getTarget(), value.getDistance()));
shortestKnownDistance.put(value.getTarget(),d);
    }
}
    }
}
