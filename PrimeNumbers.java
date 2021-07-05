import java.util.Scanner;

public class PrimeNumbers {
public static void main(String[] args) {
	System.out.println("Enter prime number 1");
	Scanner sc = new Scanner(System.in);
	int num1=sc.nextInt();
	System.out.println("Enter prime number 2");
	int num2=sc.nextInt();
	for (int i = num1; i <=num2; i++) {
		boolean isPrime=true;
	for (int j = 2; j < i; j++) {
		if(i%j==0) {
			isPrime=false;
			break;
		}
	}
		if(isPrime)System.out.print(i+" ");
	}
}
}
