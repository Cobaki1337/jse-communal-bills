package by.gsu.course_project;

public class Converter {
    public static String convertIn(int x){
        return x/100 + "." + (x%100)/10 + x%10;
    }
    public static int convertOut(double x){
        return (int) (x * 100);
    }
}
