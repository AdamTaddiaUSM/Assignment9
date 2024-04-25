package accidentpack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class SortingAlgorithms {

	public static void swap(ArrayList<Report> a, int ind1, int ind2) {
		Report ind1Clone = a.get(ind1);
		a.set(ind1, a.get(ind2));
		a.set(ind2, ind1Clone);
	}

	public static ArrayList<Report> selectionSort(ArrayList<Report> a) {
		ArrayList<Report> aCopy = new ArrayList<Report>();
		for (int i = 0; i < a.size(); i++) {aCopy.add(a.get(i));}
		for (int i = 0; i < aCopy.size() - 1; i++) {
			int smallestPos = i;
			for (int j = i + 1; j < aCopy.size(); j++) {
				if (aCopy.get(j).compareTo(aCopy.get(smallestPos)) < 0) {
					smallestPos = j;
				}
			}

			swap(aCopy, i, smallestPos);
		}
		
		return aCopy;
	}

	// this is assuming the array has three items or more but I don't think that's a
	// ridiculous requirement
	public static void sortTopDown(ArrayList<Report> input) {
		for (int localRootIndex = 0; localRootIndex < input.size(); localRootIndex++) {
			int childIndex = localRootIndex;
			while (childIndex > 0) {
				int parentIndex = (childIndex - 1) / 2;
				if (input.get(parentIndex).compareTo(input.get(childIndex)) > 0) {
					swap(input, parentIndex, childIndex);
					childIndex = parentIndex;
				} else {
					break;
				}
			}
		}
	}

	public static Report removeFromHeap(ArrayList<Report> input) throws InterruptedException {
		Report returnedReport = input.get(0);
		input.set(0, input.get(input.size() - 1));
		input.remove(input.size() - 1);

		if (input.size() > 2) {
			sortTopDown(input);
		} else {
			if (input.get(0).compareTo(input.get(1)) > 1) {
				swap(input, 0, 1);
			}
		}

		return returnedReport;

	}

	public static void minHeapify(ArrayList<Report> input)// this is just a modified version of my code from lab 10
	{
		// Your code goes here
		for (int i = input.size() - 1; i > 0; i--) {
			if (i % 2 == 0) {// if index is even
				int parentIndex = (i / 2) - 1;
				if (input.get(parentIndex).compareTo(input.get(i)) > 0) {
					swap(input, i, parentIndex);
					i = input.size() - 1;// every time a swap is made, the loop resets
				}
			} else {// if index is odd
				int parentIndex = ((i + 1) / 2) - 1;
				if (input.get(parentIndex).compareTo(input.get(i)) > 0) {
					swap(input, i, parentIndex);
					i = input.size() - 1;// every time a swap is made, the loop resets
				}
			}
		}
	}

	public static ArrayList<Report> heapSort(ArrayList<Report> input) throws InterruptedException {
		ArrayList<Report> inputCopy = new ArrayList<Report>();
		for (int i = 0; i < input.size(); i++) {inputCopy.add(input.get(i));}
		minHeapify(inputCopy);

		ArrayList<Report> output = new ArrayList<Report>();

		for (int i = 0; i < inputCopy.size(); i++) {
			output.add(removeFromHeap(inputCopy));
		}

		return output;
	}

	public static ArrayList<Report> insertionSort(ArrayList<Report> input) {
		ArrayList<Report> inputCopy = new ArrayList<Report>();
		for (int i = 0; i < input.size(); i++) {inputCopy.add(input.get(i));}
		for (int i = 0; i < inputCopy.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (inputCopy.get(j - 1).compareTo(inputCopy.get(j)) > 0) {
					swap(inputCopy, j, j - 1);
				}
			}
		}

		return inputCopy;

	}
	
	public static ArrayList<Report> mergeSortMOD(ArrayList<Report> input) throws InterruptedException{
		if (input.size() < 7) {
			return insertionSort(input);
		}
		ArrayList<Report> firstHalf = new ArrayList<Report>();
		ArrayList<Report> secondHalf = new ArrayList<Report>();
		//these two ints are in case the arraylist size is odd
		int firstHalfLength = input.size()/2;
		int secondHalfLength = input.size() - firstHalfLength;
		for(int i = 0; i < firstHalfLength; i++){
			firstHalf.add(input.get(i));
		}
		for(int i = firstHalfLength; i < input.size(); i++){
			secondHalf.add(input.get(i));
		}
		
		ArrayList<Report> sortedFirstHalf = mergeSort(firstHalf);
		ArrayList<Report> sortedSecondHalf = mergeSort(secondHalf);
		
		return mergeHelper(sortedFirstHalf, sortedSecondHalf);
	}
	
	public static ArrayList<Report> mergeSort(ArrayList<Report> input) throws InterruptedException{
		if (input.size() == 1) {
			return input;
		}
		ArrayList<Report> firstHalf = new ArrayList<Report>();
		ArrayList<Report> secondHalf = new ArrayList<Report>();
		//these two ints are in case the arraylist size is odd
		int firstHalfLength = input.size()/2;
		int secondHalfLength = input.size() - firstHalfLength;
		for(int i = 0; i < firstHalfLength; i++){
			firstHalf.add(input.get(i));
		}
		for(int i = firstHalfLength; i < input.size(); i++){
			secondHalf.add(input.get(i));
		}
		
		ArrayList<Report> sortedFirstHalf = mergeSort(firstHalf);
		ArrayList<Report> sortedSecondHalf = mergeSort(secondHalf);
		
		return mergeHelper(sortedFirstHalf, sortedSecondHalf);
	}
	
	public static ArrayList<Report> mergeHelper(ArrayList<Report> input1, ArrayList<Report> input2){
		ArrayList<Report> tempArrayList = new ArrayList<Report>();
	
	while (!input1.isEmpty() && !input2.isEmpty()) {
		if (input1.get(0).compareTo(input2.get(0)) > 0) {
			tempArrayList.add(input2.get(0));
			input2.remove(0);
		} else {
			tempArrayList.add(input1.get(0));
			input1.remove(0);
		}
	}
	
	while(!input1.isEmpty()) {
		tempArrayList.add(input1.get(0));
		input1.remove(0);
	}
	
	while(!input2.isEmpty()) {
		tempArrayList.add(input2.get(0));
		input2.remove(0);   
	}
	
	
		return tempArrayList;
	}
	
	//helper method for timsort
	public static ArrayList<LinkedList<Report>> findRuns(ArrayList<Report> input){
		ArrayList<LinkedList<Report>> outputWithRuns = new ArrayList<LinkedList<Report>>();
		LinkedList<Report> currentRun = new LinkedList<Report>();
		currentRun.add(input.get(0));
		for (int i = 1; i < input.size(); i++) {
			Report previousReport = input.get(i-1);
			Report currentReport = input.get(i);
			if(currentReport.compareTo(previousReport) >= 0) {
				currentRun.add(currentReport);
			} else {
				LinkedList<Report> nextRun = new LinkedList<Report>();
				outputWithRuns.add(nextRun);
				nextRun.add(currentReport);
				currentRun = nextRun;
			}
		}
		//FIXME this just for testing
		for (int i = 0; i < outputWithRuns.size(); i++) {
			for (int j = 0; j < outputWithRuns.get(i).size(); j++) {
				outputWithRuns.get(i).get(j).print();
			}
			System.out.println("**********************");
		}
		
		return outputWithRuns;
	}
	
	public static ArrayList<Report> timSort(ArrayList<Report> input){
		ArrayList<Report> inputCopy = new ArrayList<Report>();
		
		for (int i = 0; i < input.size(); i++) {
			inputCopy.add(input.get(i));
		}
		
		return null;//FIXME
	}
	
	public static ArrayList<Report> quickSort(ArrayList<Report> input){
		if (input.size() <= 1) {
			return input;	}
		ArrayList<Report> output = new ArrayList<Report>();
		Report pivotReport = input.get(input.size()/2);//I feel like picking the middle node is best for our data
		ArrayList<Report> lessThanPivot = new ArrayList<Report>();
		ArrayList<Report> moreThanPivot = new ArrayList<Report>();
		for (int i = 0; i < input.size() ; i++) {
			if (pivotReport.compareTo(input.get(i)) > 0 && !input.get(i).equals(pivotReport)) {
				lessThanPivot.add(input.get(i));
			} else if(!input.get(i).equals(pivotReport)) {
				moreThanPivot.add(input.get(i));}}
		lessThanPivot = quickSort(lessThanPivot);
		moreThanPivot = quickSort(moreThanPivot);
		for(int i = 0; i < lessThanPivot.size(); i++) {
		output.add(lessThanPivot.get(i));}
		output.add(pivotReport);
		for(int i = 0; i < moreThanPivot.size(); i++) {
			output.add(moreThanPivot.get(i));}
		return output;	}//there, exactly 19 lines
	
	

	
	 
}
