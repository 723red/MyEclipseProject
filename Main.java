import java.util.Scanner;

public class Main{
	
	
	
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
	int index=0;
		int count=0;
		int N = scanner.nextInt();
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum = sum + (i+1);
			
		
			//2345
			while(sum < N) {
				
				sum = sum + (i+1);
			}
		
			
	
		while(sum >= N) {
			
			sum = sum - (i+1);
		}
			if(sum == N) {
				count++;
				
				
			}
			
			
			
		}
		System.out.println(count);
		
	}
}