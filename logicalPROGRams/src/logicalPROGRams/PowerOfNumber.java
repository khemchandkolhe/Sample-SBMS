package logicalPROGRams;

import java.util.Scanner;

public class PowerOfNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
	int a=sc.nextInt();
	int n=sc.nextInt();
	int ans=1;
	for(int i=1;i<=n;i++) {

		ans=ans*a;
		
	}
	System.out.println(ans);
	}
	

}
