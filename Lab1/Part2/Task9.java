import java.util.Scanner;
public class Task9{
  public static double findRoot(int a,int b,int c){
    double r=(-b+(Math.pow(b*b-4*a*c,1/2)))/2.0*a;
    return r;
  }
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    System.out.println("please enter the value of a");
    int a=sc.nextInt();
    System.out.println("please enter the value of b");
    int b=sc.nextInt();
    System.out.println("please enter the value of c");
    int c=sc.nextInt();
    System.out.println("The equation :"+a+"x^2+"+b+"x+"+c);
    System.out.println("1st root is "+findRoot(a,b,c));
  }
}