


public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point (2.0,3.0);
        Point p2 = new Point (4.0,5.0);


       // Функция
       // System.out.println("Расстояние от точки до точки равно: " + distance(p1,p2));

        System.out.println("Расстояние от точки до точки равно: " + p2.countDistance(p1));


    }


  /*
    //Функция
    public static double distance (Point p1, Point p2) {
        double distance = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
        return distance;

    }
*/


/*

        Triangle tr = new Triangle(10.0, 15.0);
        System.out.println("Площадь треугольника равна " + tr.sayArea());


        //  System.out.println("Hello, world!!");
        //  System.out.println("Площадь квадарата равна " + square(15));

*/




}


