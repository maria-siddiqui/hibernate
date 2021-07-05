
public class TaskFibonacci {
	public static void main(String[] args) {
		if(args.length>1) {
			System.out.println("Invalid num of arguements ");
			System.exit(1);
		}
		 int n1=0,n2=1,n3,i,count=Integer.parseInt(args[0]);    
		 System.out.print(n1+" "+n2);
		  for(i=2;i<count;++i)   
		 {    
		  n3=n1+n2;    
		  System.out.print(" "+n3);    
		  n1=n2;    
		  n2=n3;    
		 }
	}
}
