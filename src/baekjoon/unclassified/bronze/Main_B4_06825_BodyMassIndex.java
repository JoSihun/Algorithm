package baekjoon.unclassified.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_06825_BodyMassIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        double bmi = weight / (height * height);
        System.out.println(bmi > 25 ? "Overweight" : bmi < 18.5 ? "Underweight" : "Normal weight");
    }
}
