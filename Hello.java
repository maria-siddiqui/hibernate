
public class Hello {
	public static void main(String[] args) {
		int start=12;
		for (int i = 0; i < start; i++) {
			for (int j = start; j > i; j--)
				System.out.print("-");
			for (int j = 0; j < i; j++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(i%2==0)System.out.print("- ");
				else {
					if(j%2==0)
						System.out.print("* ");
						else
							System.out.print("# ");
				}
				
			}
			System.out.println();
		}
		for (int i = start; i > 0; i--) {
			for (int j = start; j > i; j--)
				System.out.print("-");
			for (int j = 0; j < i; j++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				if(i%2==0)System.out.print("- ");
				else {
					if(j%2==0)
						System.out.print("* ");
						else
							System.out.print("# ");
				}
			}
			System.out.println();
		}
	}
}
