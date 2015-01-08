import java.util.Arrays;

public class Sort{

	/*SORT ARRAY AND RETURN AS STRING*/
	public static String SortArrayToString(int unsorted[]){
		String sortedArray = Arrays.toString(SortArray(unsorted));		//converting sorted array to string
		sortedArray = sortedArray.replace("[", "").replace("]", "");		//the string contained "[" at the beginning of array and "]" on the end, but we have removed it
		return sortedArray;													//returning sorted array
	}
	
	/*SORT ARRAY AND RETURN AS INT ARRAY*/
	public static int[] SortArray(int unsorted[]){
		for (int i = 0; i < unsorted.length - 1; i++){				//implementing method array length times
			for (int j = 0; j < unsorted.length - 1; j++){			//going through array
				if (unsorted[j] < unsorted[j + 1]){			//checking if array on j is less then array on j+1
					int current = unsorted[j];			//saves number
					unsorted[j] = unsorted[j + 1];			//swaps spots
					unsorted[j + 1] = current;			//still swapping
				}
			}													
		}
		return unsorted;							//returning sorted array
	}
}
