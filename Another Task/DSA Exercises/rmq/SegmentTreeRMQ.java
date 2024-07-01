package rmq;

public class SegmentTreeRMQ {
	int st[];
	int minVal(int x, int y) { 
		return (x < y) ? x : y; 
	} 

	int getMid(int s, int e) { 
		return s + (e - s) / 2; 
	} 

	int RMQUtil(int ss, int se, int qs, int qe, int index) 
	{
		if (qs <= ss && qe >= se) 
			return st[index];
		if (se < qs || ss > qe) 
			return Integer.MAX_VALUE;
		int mid = getMid(ss, se); 
		return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), 
				RMQUtil(mid + 1, se, qs, qe, 2 * index + 2)); 
	}
	int RMQ(int n, int qs, int qe) 
	{
		if (qs < 0 || qe > n - 1 || qs > qe) { 
			System.out.println("Invalid Input"); 
			return -1; 
		} 

		return RMQUtil(0, n - 1, qs, qe, 0); 
	}
	int constructSTUtil(int arr[], int ss, int se, int si) 
	{
		if (ss == se) { 
			st[si] = arr[ss]; 
			return arr[ss]; 
		}
		int mid = getMid(ss, se); 
		st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), 
				constructSTUtil(arr, mid + 1, se, si * 2 + 2)); 
		return st[si]; 
	}
	void constructST(int arr[], int n) 
	{
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 

		int max_size = 2 * (int) Math.pow(2, x) - 1; 
		st = new int[max_size];

		constructSTUtil(arr, 0, n - 1, 0); 
	}
	public static void main(String args[]) 
	{ 
		int arr[] = {1, 3, 2, 7, 9, 11}; 
		int n = arr.length; 
		SegmentTreeRMQ tree = new SegmentTreeRMQ(); 

		tree.constructST(arr, n); 

		int qs = 1;
		int qe = 5;
		System.out.println("Minimum of values in range [" + qs + ", "
						+ qe + "] is = " + tree.RMQ(n, qs, qe)); 
	} 
}
