package assignment;

import java.util.Scanner;

public class BayviewGlenPools {
    public static void main(String[] args) {
      
        Scanner in = new Scanner(System.in);

            //prompts

        System.out.print("Please enter the length of the pool");
        int length = in.nextInt();

        System.out.println("Please enter the width of the pool");
        int width = in.nextInt();

        System.out.println("Please enter the depth of the shallow end");
        int shallowdepth = in.nextInt(); 

        System.out.println("Please enter the depth of the deep end");
        int deepdepth = in.nextInt();

        System.out.println("Please enter the length of the transition between the shallow and deep end");
        int transitionlength = in.nextInt();

        System.out.println("Please enter the length of the shallow end");
        int shallowlength = in.nextInt();

        System.out.println("Please enter the price per meter squared of the liner that they can get for the pool");
        int priceliner = in.nextInt();

        //calculations for surface area 

        double shallowendarea = shallowdepth*width;
        double shallowsidearea = (shallowdepth*shallowlength)*2;
        double shallowbottomarea = shallowlength*width;
        double transitionarea = transitionlength*width;
        double transitionsidearea = (transitionlength*deepdepth)-(((0.625*deepdepth)*transitionlength)/2);
        double deepbottomarea = (0.4*(length))*width;
        double deependsidearea = deepdepth*(0.4*(length))*2;
        double deependarea = width*deepdepth;

        //calculations for liner cost

        double totallinerarea = shallowendarea+shallowsidearea+shallowbottomarea+transitionarea+transitionsidearea+deepbottomarea+deependsidearea+deependarea;
        double totallinercost = totallinerarea*priceliner;

        //calculations for volume

        double volumedeepend = (0.4*(length)*width)*deepdepth;
        double volumeshallowend = (shallowdepth*width*shallowdepth);
        double volumetransition = (transitionlength*deepdepth*width)-((transitionlength*width*deepdepth)/2);
        double totalvolume = volumedeepend+volumeshallowend+volumetransition;
        double ninetypercentvolume = totalvolume*0.9;

        //final sentences presenting the volume, liner needed and liner cost

        System.out.println("The amount of water needed to keep the pool 90% full is " + ninetypercentvolume + " cubic metres");
        System.out.println("The total meters squared of liner need to complete the pool is " + totallinerarea);
        System.out.println("The cost of the liner needed to complete the pool is $" + totallinercost);

        in.close();
    }
}
