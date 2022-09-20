package day4;

public class QuestionFive {
    public static void main(String[] args) {
        double pennie = 0.01;
        double dime = 0.1;
        double quarter = 0.25;
        double loonie = 1;
        double toonie = 2;


        int numpennies = 10;
        int numdime = 20;
        int numquarter = 30;
        int numloonie = 40;
        int numtoonie = 50;

        double totalmoney = (numpennies * pennie) + (numdime * dime) + (numquarter * quarter) + (numloonie + loonie) + (numtoonie + toonie);

        System.out.println("$" + totalmoney);
    }
}
