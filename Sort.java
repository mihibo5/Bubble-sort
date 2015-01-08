import java.util.Arrays;

public class Sort{

	/*SORT ARRAY AND RETURN AS STRING*/
	public static String SortArrayToString(int unsorted[]){
		String sortedArray = Arrays.toString(SortArray(unsorted));			//converting sorted array to string
		sortedArray = sortedArray.replace("[", "").replace("]", "");		//the string contained "[" at the beginning of array and "]" on the end, but we have removed it
		return sortedArray;													//returning sorted array
	}
	
	/*SORT ARRAY AND RETURN AS INT ARRAY*/
	public static int[] SortArray(int unsorted[]){
		for (int i = 0; i < unsorted.length - 1; i++){						//implementing method array length times
			sort(unsorted);													//calling method
		}
		return unsorted;													//returning sorted array
	}
	
	/*PARTAIL SORT*/
	private static void sort(int unsorted[]){
		for (int i = 0; i < unsorted.length - 1; i++){						//going through array
			if (unsorted[i] < unsorted[i + 1]){								//checking if array on i is less then array on i+1
				int current = unsorted[i];									//saves number
				unsorted[i] = unsorted[i + 1];								//swaps spots
				unsorted[i + 1] = current;									//still swapping
			}
		}
	}
}
