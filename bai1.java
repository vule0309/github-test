package Try_catch;
import java.util.Scanner;
import java.util.InputMismatchException;
public class bai1 {

	public static void main(String[] args) {
 Scanner sc=new Scanner (System.in);
     try{
    	 double number1=sc.nextDouble();
     double number2=sc.nextDouble();
     if(number2==0)
     {
    	 throw new ArithmeticException("lỗi 0");
     }
     double result=number1/number2;
     System.out.println(result);
 
     }
     catch (ArithmeticException e)
     {
    	 System.out.println("lỗi chia số 0");
     }catch (InputMismatchException e)
     {
    	 System.out.println("lỗi nhập số");
     }
   
     finally
     {
    	 sc.close();
     }
     System.out.println("tiep tuc");
    

     
	}

}
