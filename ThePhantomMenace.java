import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ThePhantomMenace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] doors = new int[n];
		for(int a = 0; a < n; a++){
			doors[a] = input.nextInt();
		}
		int m = input.nextInt();
		int[] droids = new int[m];
		for(int b = 0; b < m; b++){
			droids[b] = input.nextInt();
		}
		System.out.println(find(doors, droids));
	}
	   public static int find(int[] doors, int[] droids){
	     	Arrays.sort(droids);
	    	Arrays.sort(doors);
	    	int max = -1;
	        for(int a = 0; a < doors.length; a++){
	         	int distance = getDistanceToNearestDroid(doors[a], droids);
	         	if(distance > max){
	         		max = distance;
	         	}
	        }
	        return max;
	    }    
	   public static int getDistanceToNearestDroid(int doorLocation, int[] droids){
		
		   int location = Arrays.binarySearch(droids, doorLocation); 
		   int temp = Math.abs(location);
		   ArrayList<Integer> possibilities = new ArrayList<Integer>();
		   for(int a = temp-2; a <= temp; a++){
			   if(a >= 0 && a < droids.length){
				   possibilities.add(droids[a]);
			   }
		   }
		   int min = Integer.MAX_VALUE;
		   for(Integer a: possibilities){
			   if(min > Math.abs(doorLocation-a)){
				   min =  Math.abs(doorLocation-a);
			   }
		   }
		   return min;
	   }
}
