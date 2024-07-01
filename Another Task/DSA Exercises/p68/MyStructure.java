package p68;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyStructure {

	private ArrayList<Integer> arr;
	private Map<Integer, Integer> map;
	public MyStructure() {
		arr = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}
	public void add(int x) {

		if (!map.containsKey(x)) {
			int index = arr.size();
			arr.add(x);
			map.put(x, index);
		}
	}
	public void remove(int x) {
		if (map.containsKey(x)) {
			int index = map.get(x);
			map.remove(x);
			int last = arr.size() - 1;
			arr.set(index, arr.get(last));
			arr.remove(last);
			map.put(arr.get(index), index);
		}
	}
	public int search(int x) {
		if (map.containsKey(x)) {
			return map.get(x);
		}
		return -1;
	}
	public int getRandom() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(arr.size());
		return arr.get(randomIndex);
	}

	public static void main(String[] args) {
		MyStructure ds = new MyStructure();
		ds.add(10);
		ds.add(20);
		ds.add(30);
		ds.add(40);
		System.out.println(ds.search(30));
		ds.remove(20);
		ds.add(50);
		System.out.println(ds.search(50));
		System.out.println(ds.getRandom());
	}
}
