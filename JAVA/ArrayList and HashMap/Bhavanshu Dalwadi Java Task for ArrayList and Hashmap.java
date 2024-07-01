// Collection Methods - add, set, size, remove, removeFirst, removeLast, iterate, addAll, removeAll, clear

import java.text.SimpleDateFormat;
import java.util.*;

class Student {
    public int id;
    public int en_no;
    public String name;
    public String email;
    public String phone;

    Student(int id, String name, int en_no, String email, String phone) {
        this.id = id;
        this.name = name;
        this.en_no = en_no;
        this.email = email;
        this.phone = phone;
    }
}

class StudentId {
    int id;
    String name;

    StudentId(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentDetails {
    String email;
    String phone;
    String address;

    StudentDetails(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}

class SortingAlgo {
    private static void merge(ArrayList<Student> arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;

        Student[] temp = new Student[end - start + 1];

        while ((i <= mid) && (j <= end)) {
            if (arr.get(i).en_no < arr.get(j).en_no)
                temp[k++] = arr.get(i++);
            else
                temp[k++] = arr.get(j++);
        }

        while (i <= mid) {
            temp[k++] = arr.get(i++);
        }

        while (j <= end) {
            temp[k++] = arr.get(j++);
        }

        for (i = start; i <= end; i++) {
            arr.remove(i);
            Student e = temp[i - start];
            arr.add(i, e);
        }
    }

    public static void mergeSort(ArrayList<Student> arr, int start, int end) {
        if (start != end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static int partition(ArrayList<Student> a, int start, int end) {
        int pivot = a.get(end).en_no;
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            if (a.get(j).en_no < pivot) {
                i++;
                Student t = a.get(i);
                a.set(i, a.get(j));
                a.set(j, t);
            }
        }

        Student t = a.get(i + 1);
        a.set(i + 1, a.get(end));
        a.set(end, t);

        return (i + 1);
    }

    public static void quickSort(ArrayList<Student> a, int start, int end) {
        if (start < end) {
            int p = partition(a, start, end);
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }
    }

    public static Student getMax(ArrayList<Student> a, int n) {
        Student max = a.get(0);
        for (int i = 1; i < n; i++) {
            if (a.get(i).en_no > max.en_no)
                max = a.get(i);
        }
        return max;
    }

    public static void selectionSort(ArrayList<Student> arr) {
        long start_time = new Date().getTime();
        for (int i = 0; i < arr.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).en_no < arr.get(index).en_no) {
                    index = j;
                }
            }
            Student smaller = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, smaller);
        }
        long end_time = new Date().getTime();
        System.out.println("Selection Sort Take: "+(end_time-start_time));
    }

    public static void bubbleSort(ArrayList<Student> arr) {
        long start_time = new Date().getTime();
        int n = arr.size();
        Student temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr.get(j - 1).en_no > arr.get(j).en_no) {
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        long end_time = new Date().getTime();
        System.out.println("Bubble Sort Take: "+(end_time-start_time));
    }

    public static void bogoSort(ArrayList<Student> a) {
        long start_time = new Date().getTime();
        while (isSorted(a) == false)
            shuffle(a);
        long end_time = new Date().getTime();
        System.out.println("Bogo Sort Take: "+(end_time-start_time));
    }

    public static void shuffle(ArrayList<Student> a) {
        for (int i = 0; i < a.size(); i++)
            swap(a, i, (int) (Math.random() * i));
    }

    public static void swap(ArrayList<Student> a, int i, int j) {
        Student temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static boolean isSorted(ArrayList<Student> a) {
        for (int i = 1; i < a.size(); i++)
            if (a.get(i).en_no < a.get(i - 1).en_no)
                return false;
        return true;
    }

    public static void insertionSort(ArrayList<Student> arr) {
        long start_time = new Date().getTime();
        int n = arr.size();
        for (int j = 1; j < n; j++) {
            Student key = arr.get(j);
            int i = j - 1;
            while ((i > -1) && (arr.get(i).en_no > key.en_no)) {
                arr.set(i + 1, arr.get(i));
                i--;
            }
            arr.set(i + 1, key);
        }
        long end_time = new Date().getTime();
        System.out.println("Insertion Sort Take: "+(end_time-start_time));
    }

    public static void heapify(ArrayList<Student> a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && a.get(left).en_no > a.get(largest).en_no)
            largest = left;
        if (right < n && a.get(right).en_no > a.get(largest).en_no)
            largest = right;
        if (largest != i) {
            Student temp = a.get(i);
            a.set(i, a.get(largest));
            a.set(largest, temp);

            heapify(a, n, largest);
        }
    }

    public static void heapSort(ArrayList<Student> a, int n) {
        long start_time = new Date().getTime();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            Student temp = a.get(0);
            a.set(0, a.get(i));
            a.set(i, temp);

            heapify(a, i, 0);
        }
        long end_time = new Date().getTime();
        System.out.println("Heap Sort Take: "+(end_time-start_time));
    }

    public static void oddEvenSort(ArrayList<Student> arr, int n) {
        long start_time = new Date().getTime();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            Student temp;

            for (int i = 1; i <= n - 2; i = i + 2) {
                if (arr.get(i).en_no > arr.get(i + 1).en_no) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    isSorted = false;
                }
            }
            for (int i = 0; i <= n - 2; i = i + 2) {
                if (arr.get(i).en_no > arr.get(i + 1).en_no) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
        long end_time = new Date().getTime();
        System.out.println("OddEven Sort Take: "+(end_time-start_time));
    }

    public static void cocktailSort(ArrayList<Student> a) {
        long start_time = new Date().getTime();
        boolean swapped = true;
        int start = 0;
        int end = a.size();

        while (swapped == true) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (a.get(i).en_no > a.get(i + 1).en_no) {
                    Student temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (a.get(i).en_no > a.get(i + 1).en_no) {
                    Student temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swapped = true;
                }
            }

            start = start + 1;
        }
        long end_time = new Date().getTime();
        System.out.println("Cocktail Sort Take: "+(end_time-start_time));
    }

    public static void flip(ArrayList<Student> arr, int i) {
        int start = 0;
        Student temp;
        while (start < i) {
            temp = arr.get(start);
            arr.set(start, arr.get(i));
            arr.set(i, temp);
            start++;
            i--;
        }
    }

    public static void pancakeSort(ArrayList<Student> arr, int n) {
        long start_time = new Date().getTime();
        for (int curr_size = n; curr_size > 1; --curr_size) {
            int mi, i;
            for (mi = 0, i = 0; i < curr_size; ++i)
                if (arr.get(i).en_no > arr.get(mi).en_no)
                    mi = i;

            if (mi != curr_size - 1) {
                flip(arr, mi);
                flip(arr, curr_size - 1);
            }
        }
        long end_time = new Date().getTime();
        System.out.println("Pancack Sort Take: "+(end_time-start_time));
    }
}

class SearchingAlgo {
    public static int linearSearch(ArrayList<Student> list, int en_no) {
        long start_time = new Date().getTime();
        int n = list.size();

        for (int i = 0; i < n; i++) {
            if (list.get(i).en_no == en_no) {
                long end_time = new Date().getTime();
                System.out.println("linearSearch Take: "+(end_time-start_time));
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(ArrayList<Student> list, int en_no) {
        long start_time = new Date().getTime();
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).en_no == en_no) {
                long end_time = new Date().getTime();
                System.out.println("binarySearch Take: "+(end_time-start_time));
                return mid;
            } else if (list.get(mid).en_no < en_no) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

public class AL {
    public static void addRecords(ArrayList<Student> arr, int n) {
        for (int i = 1; i <= n; i++) {
            arr.add(new Student(i, "Student " + i, (int) (Math.random() * 99999), "Student" + i + "@gmail.com",
                    (long) (Math.random() * 999999999) + ""));
        }
    }

    public static void main(String[] args) {
        // -------------------- ArrayList Searching and Sorting -----------------------
        ArrayList<Student> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

        int n = 15000;
        System.out.printf("Algorithms Times For %d records: \n", n);

        System.out.println(formatter.format(new Date()));

        addRecords(list, n);
        long start_time = new Date().getTime();
        SortingAlgo.mergeSort(list, 0, list.size() - 1);
        long end_time = new Date().getTime();
        System.out.println("Merge Sort Take: "+(end_time-start_time));

        list.clear();
        addRecords(list, n);
        start_time = new Date().getTime();
        SortingAlgo.quickSort(list, 0, list.size() - 1);
        end_time = new Date().getTime();
        System.out.println("Quick Sort Take: "+(end_time-start_time));

        list.clear();
        addRecords(list, n);
        SortingAlgo.selectionSort(list);

        list.clear();
        addRecords(list, n);
        SortingAlgo.bubbleSort(list);

        list.clear();
        addRecords(list, n);
        SortingAlgo.insertionSort(list);

        list.clear();
        addRecords(list, n);
        SortingAlgo.heapSort(list, list.size());

        list.clear();
        addRecords(list, n);
        SortingAlgo.oddEvenSort(list, list.size());

        list.clear();
        addRecords(list, n);
        SortingAlgo.cocktailSort(list);

        list.clear();
        addRecords(list, n);
        SortingAlgo.pancakeSort(list, list.size());

        System.out.println(formatter.format(new Date()));

        System.out.println("Sorted First 50 Records: ");
        System.out.println("Id - Name - En. No. - Email - Phone");
        for (int i = 0; i < 50; i++) {
            System.out.println(list.get(i).id + " - " + list.get(i).name + " - " + list.get(i).en_no + " - "
                    + list.get(i).email + " - " + list.get(i).phone);
        }

        System.out.println(list.get(5).en_no+" Found At: "+SearchingAlgo.linearSearch(list, list.get(5).en_no));
        System.out.println(list.get(5).en_no+" Found At: "+SearchingAlgo.binarySearch(list, list.get(5).en_no));

        // ------------------ ArrayList ------------------------
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(5);
        arrList.add(1,10);
        arrList.add(15);
        arrList.add(20);
        arrList.add(25);
        System.out.println(arrList);
        arrList.set(1, 30);
        System.out.println(arrList);
        System.out.println("Size: "+arrList.size());
        arrList.remove(3);
        System.out.println(arrList);
        arrList.removeFirst();
        arrList.removeLast();
        System.out.println(arrList);
        
        for(Integer item: arrList) {
            System.out.println(item);
        }

        Iterator<Integer> it = arrList.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+", ");
        }

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(35);
        l.add(40);
        l.add(45);
        l.add(50);
        System.out.println(l);

        arrList.addAll(l);
        System.out.println(arrList);
        arrList.removeAll(l);
        System.out.println(arrList);
        arrList.clear();
        System.out.println(arrList);

        // ---------------------------- HashMap -------------------------------------
        HashMap<StudentId, StudentDetails> hm = new HashMap<StudentId, StudentDetails>();
        StudentId id = new StudentId(1, "Henil");
        StudentDetails value = new StudentDetails("henil123@gmail.com", "1234567890", "dvajfgvahgd hdasjfg");
        hm.put(id, value);
        System.out.println(hm.get(id).email);
        System.out.println(hm.size());
        hm.clear();
    }
}