package by.it.ikasabutskaya.at06;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        Var v1=new Scalar(3.14);

        double[] array={1.0, 2.0, 4.0};
        Var v2=new Vector(array);

        System.out.println(v1);
        System.out.println(v2);

    }


}