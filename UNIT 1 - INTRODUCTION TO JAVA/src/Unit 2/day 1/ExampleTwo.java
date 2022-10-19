import javax.swing.event.SwingPropertyChangeSupport;

public class ExampleTwo {
    public static void main(String[] args) {


        /*  s1, s2, s3 were declared using the string constructor */
        String s1 = new String("happy");
        String s2 = new String("happy");
        String s3 = new String("Happy");
        /* s4, s5 were declared using String literals */
        String s4 = "happy";
        String s5 = "happy";
        int x = 7;
        int y = 7;

        System.out.println(s1 == s2); // false
        System.out.println(x == y);   // true

        System.out.println(s1.equals(s2)); // true equals method compares the actual objects

        System.out.println(s2.equals(s3)); // false 

        System.out.println(s4 == s5); // true (String literals are special and have the same address)

        System.out.println(s1 == s4);

    }
}
