import java.util.*; 

class FiftyTwo {
    public static void main(String args[]) {
        String days[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" }; 

        int date = 01;
        int month = 12;
        int year = 2023;

        Date d = new Date(year - 1901, month, date);

        Calendar c = Calendar.getInstance();
        c.setTime(d);

        for(int i=0; i<c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            int mon = (c.get(Calendar.MONTH) == 0)?12:c.get(Calendar.MONTH);
            System.out.println(days[c.get(Calendar.DAY_OF_WEEK) - 1]+" "+c.get(Calendar.DATE)+" "+mon+" "+c.get(Calendar.YEAR));
            c.add(Calendar.DATE, 1);
        }
    }
}