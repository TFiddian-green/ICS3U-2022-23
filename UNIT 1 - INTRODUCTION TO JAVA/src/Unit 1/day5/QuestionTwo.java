package day5;

public class QuestionTwo {
    public static void main(String[] args) {
       double length = 4.5;
       double width = 2.3; 

       double perimeter = (2 * length) + (2 * width);
        double area = length * width;
      double finalarea = Math.round(area*10)/10;
      double finalperimeter = Math.round(perimeter*10)/10;
        
        
        System.out.println(finalperimeter);
       System.out.println(finalarea);
    }
}
