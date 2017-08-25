import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author sachin.srivastava
 *
 */
public class SortingAlgos {

	public static void main(String[] args) {
		Graph g = new Graph();
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    System.out.println(lonelyInteger(new int[]{4,2,2,3,3,6}));
	    
	 
	}
	
	public static int lonelyInteger(int[] arr){
		int result = 0;
		for (int i : arr) {
			result ^= i;
		}
		return result;
	}

	public static void quickSort(int[] arr) {

		// average and best case is Θ(n log(n)) and in the worst case is Θ(n2).
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);

	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			if (arr[left] < pivot) {
				left++;
			}
			if (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void mergeSort(int[] arr) {
		// Mergesort sorts in worst case in O(nlogn) time. Due to the required
		// copying of the collection Mergesort is in the average case slower
		// than Quicksort
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int mid = (leftStart + rightEnd) / 2;
		mergeSort(arr, temp, leftStart, mid);
		mergeSort(arr, temp, mid + 1, rightEnd);
		merge(arr, temp, leftStart, rightEnd);
	}

	private static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int index = leftStart;
		int left = leftStart;
		int right = rightStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);

	}

	public static void heapSort(int[] arr) {

		// Worst case performance : O(n log n)
		// Best case performance : O(n log n)
		// Average case performance : O(n log n)
		// //

		int n = arr.length - 1;
		// building a heap
		for (int i = n / 2; i >= 0; i--) {
			maxHeap(arr, n, i);
		}
		for (int i = n; i >= 0; i--) {
			swap(arr, i, 0);
			maxHeap(arr, i, 0);
		}
	}

	public static void maxHeap(int[] arr, int size, int index) {
		int max = index;
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left < size && arr[left] > arr[max]) {
			max = left;
		}
		if (right < size && arr[right] > arr[max]) {
			max = right;
		}
		if (max != index) {
			swap(arr, max, index);
			maxHeap(arr, size, max);
		}
	}

	public static void selectionSort(int[] arr) {
		// brute force the elements and swap the elememnts gives worst case
		// O(n2)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	public static int binarySearch(int[] arr, int key) {
		// array should be sorted in orde to get the result.
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	static class Graph {
		private   Map<Integer, Node> nodeLookup = new HashMap<>();
		 class Node {
			int data;
			LinkedList<Node> adj = new LinkedList<>();
			public Node(int data) {
				this.data = data;
			}
		}

		private Node getNode(int data) {
			if(nodeLookup.get(data) == null){
				nodeLookup.put(data, new Node(data));
			}
			return nodeLookup.get(data);
		}

		public void addEdge(int src, int dest) {
			Node s = getNode(src);
			Node d = getNode(dest);
			s.adj.add(d);
		}
		boolean hasPathDFS(int src, int dest) {
			if (src == dest) {
				return true;
			}
			Node s = getNode(src);
			Node d = getNode(dest);
			HashSet<Integer> visited = new HashSet<>();
			return hasPathDFS(s, d, visited);
		}

		boolean hasPathDFS(Node src, Node dest, HashSet<Integer> visited) {
			if (visited.contains(src.data)) {
				return false;
			}
			visited.add(src.data);
			if (src.data == dest.data) {
				return true;
			}
			for (Node child : src.adj) {
				if (hasPathDFS(child, dest, visited)) {
					return true;
				}
			}
			return false;
		}
		public boolean hasPathBFS(Node src , Node dest){
			LinkedList<Node> nextToVisit = new LinkedList<>();
			HashSet<Integer> visited  = new HashSet<>();
			nextToVisit.add(src);
			while(!nextToVisit.isEmpty()){
				Node child = nextToVisit.pop();
				if(child.data == dest.data){
					return true;
				}
				if(visited.contains(child.data)){
					continue;
				}
				visited.add(child.data);
				for(Node node : child.adj){
					nextToVisit.add(node);
				}
			}
			return false;
		}
	}
	

}
