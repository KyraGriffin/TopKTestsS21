import java.util.Comparator;
import java.util.Random;
class Siena {
    private String name;
    private double gpa;

    public Siena(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){
        return name;   
    }

    public double getGPA(){
        return gpa;   
    }
    public String toString(){
        return name + "," + gpa;
    }
}
/**
Sample test case implementation for TopK.

@author Jim Teresco
@version Spring 2021
 */   

public class TopKTesterJMHKEG {

    /**
    main method to try out the TopK

    @param args not used
     */
    public static void main(String args[]) {
        TopK<Integer> thebest = new TopKJDTRefSol<Integer>(5, Comparator.naturalOrder());

        Random r = new Random();
        System.out.print("All entries:  ");
        for(int i = 0; i < 25; i++){
            if(!(i == 24)){
                int temp =r.nextInt(150);
                System.out.print(temp + ",");
                thebest.add(temp);
            }else{
                int temp =r.nextInt(150);
                System.out.print(temp );
                thebest.add(temp);
            }

        }

        System.out.println("\nWith 25 entries: " + thebest);

        System.out.print("\nClearing TopK: ");
        thebest.clear();
        System.out.println(thebest);

        TopK<String> thestring = new TopKJDTRefSol<String>(5, Comparator.naturalOrder());

        thestring.add("The");
        thestring.add("last");
        thestring.add("file");
        thestring.add("fork");
        thestring.add("read");
        thestring.add("ask");
        System.out.println("\nWith 6 entries: " + thestring);
        thestring.add("original");
        thestring.add("repositroy");
        thestring.add("too");
        thestring.add("github");
        thestring.add("new");
        thestring.add("step");
        thestring.add("pull");

        System.out.println("With 13 entries: " + thestring);

        Siena s = new Siena("John Hurley", 1.1);
        Siena s2 = new Siena("Barb", 3.1);
        Siena s3 = new Siena("Kyra", 2.4);
        Siena s4 = new Siena("Mick", 2.1);
        Siena s5 = new Siena("Kelly", 4.0);
        
        
        TopK<Siena> thesiena = new TopKJDTRefSol<Siena>(3, new Comparator<Siena>(){
                    public int compare(Siena a, Siena b){
                        if(a.getGPA() - b.getGPA() > 0){
                            return 1;
                        }else if(a.getGPA() - b.getGPA() < 0){
                            return -1;
                        }else{
                            return 0;
                        }

                    }
                });
                thesiena.add(s);
                thesiena.add(s2);
                thesiena.add(s3);
                thesiena.add(s4);
                thesiena.add(s5);
                
                System.out.println("\nWith 5 entries: " + thesiena);
    }

}

