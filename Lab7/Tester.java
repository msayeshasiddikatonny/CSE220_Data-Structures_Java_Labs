//import java.util.Scanner;
public class Tester{
  public static void main(String []args){
    //Scanner sc=new Scanner(System.in);
    ListStack l=new ListStack();
    int flag=1;
    //System.out.println("please enter an expression");
   // String s1=sc.nextLine();
     String s="1+2*(3/4]";
    for(int i=0;i<s.length();i++){
      char aChar=s.charAt(i);
      if(aChar=='[' || aChar=='(' || aChar=='{' ){
        l.push(aChar);
      }
      else{
        if(aChar==']' || aChar==')' || aChar=='}' ){
          try{
            char aChar2=l.pop();
            if(!(aChar==']' && aChar2=='[')||!(aChar=='}' && aChar2=='{')||!(aChar=='(' && aChar2==')')){
              flag=0;
              break;
            }
          }
          catch(Exception e){
            flag=0;
            System.err.println("empty");
            break;
          }
        }
        else{
        }
      }
    }
    if(l.isEmpty()==true && flag==1){
      System.out.println(" y");
    }
    else{
      System.out.println(" n");
    }
  }
}
  