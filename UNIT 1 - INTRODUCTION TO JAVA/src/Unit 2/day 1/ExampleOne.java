

public class ExampleOne {
    public static void main(String[] args) {
        String club = "DECA";
        String name = "Michael";

        System.out.println(club);
        System.out.println(name);

        String s1 = new String("Alphabet");
        String s2 = new String("Nolan Ryan");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("The length of s2 is " + s2.length());
        System.out.println("The length of s1 is " + name.length());

        System.out.println(s1.substring(2, 5)); // "Phe"

        System.out.println("Bayview Glen".substring(8)); // "Glen"

        System.out.println(s1.substring(0, s1.length() / 2));
        System.out.println(s1.substring(s1.length() / 2));

        System.out.println("Hello".indexOf("11")); // 2
        System.out.println("Alphabet".indexOf("et")); // 6
        System.out.println("banana".indexOf("an")); // 1
        System.out.println("eye".indexOf("contact")); // -1
        
       

    }
}
