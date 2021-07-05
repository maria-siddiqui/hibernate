import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println("Enter String to reverse");
		Scanner sc = new Scanner(System.in);
		String string =sc.nextLine();
		
		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < string.length(); i++) {
			sb.append(string.charAt(string.length()-1-i));
		}
		System.out.println(sb.toString());
	}
}
