package accidentpack;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class main {
	
	public static TreeMap<String, ArrayList<Report>> reports;

	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		reports = new TreeMap<String, ArrayList<Report>>();
		File f = new File(args[0]);
		Scanner scnr1 = new Scanner(f);
		int reportCount = Report.findReportCount(scnr1);
		scnr1.close();
		Scanner scnr2 = new Scanner(f);
		scnr2.nextLine();
		generateTreeMap(scnr2, reportCount);
		scnr2.close();
		
		ArrayList<Report> givenStateList = reports.get(args[1]);
		System.out.println("State chosen: " + args[1] + ". State data contains " + givenStateList.size() + " reports.");
		
		
		long startTime = System.nanoTime();
		System.out.println("Starting merge/insertion sort");
		ArrayList<Report> mergeSortMOD = SortingAlgorithms.mergeSortMOD(givenStateList);
		long endTime = System.nanoTime();
		System.out.println("merge/insertion sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
		startTime = System.nanoTime();
		System.out.println("Starting insertion sort");
		ArrayList<Report> insertionSorted = SortingAlgorithms.insertionSort(givenStateList);
		endTime = System.nanoTime();
		System.out.println("Insertion sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
		startTime = System.nanoTime();
		System.out.println("Starting merge sort");
		ArrayList<Report> mergeSort = SortingAlgorithms.mergeSort(givenStateList);
		endTime = System.nanoTime();
		System.out.println("merge sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
		startTime = System.nanoTime();
		System.out.println("Starting quick sort");
		ArrayList<Report> quickSort = SortingAlgorithms.quickSort(givenStateList);
		endTime = System.nanoTime();
		System.out.println("quick sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
		startTime = System.nanoTime();
		System.out.println("Starting selection sort");
		ArrayList<Report> selectionSort = SortingAlgorithms.selectionSort(givenStateList);
		endTime = System.nanoTime();
		System.out.println("selection sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
		startTime = System.nanoTime();
		System.out.println("Starting heap sort");
		ArrayList<Report> heapSort = SortingAlgorithms.heapSort(givenStateList);
		endTime = System.nanoTime();
		System.out.println("heap sort took " + (endTime - startTime)/1000000000.00 + " seconds");
		
	
	}
	
	
	public static void generateTreeMap(Scanner scnr, int reportCount){
		for(int i = 0; i < reportCount; i++) {
			Report r = Report.createReport(scnr);
			//if there not is already an arraylist for the state
			if (!(reports.containsKey(r.getState()))) {
				reports.put(r.getState(), new ArrayList<Report>());
			}
			
			reports.get(r.getState()).add(r);
		}
	}

}
