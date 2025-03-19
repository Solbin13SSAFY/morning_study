package week09.hyunji;

import java.util.Arrays;
import java.util.Comparator;

class MyObject {
    String s;
    int i;
    double d;

    MyObject(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return s + " " + i + " " + d;
    }

}

class MyObjectComparator implements Comparator<MyObject> {

    @Override
    public int compare(MyObject obj1, MyObject obj2) {

        // 1. int끼리 비교
        if(Integer.compare(obj1.i, obj2.i) != 0) {
            return Integer.compare(obj1.i, obj2.i);
        }

        // 2. double끼리 비교
        if(Double.compare(obj1.d, obj2.d) != 0) {
            return Double.compare(obj1.d, obj2.d);
        }

        // 3. String끼리 비교
        else return obj1.s.compareTo(obj2.s);
    }
}

class thu_정렬연습 {
    public static void main(String[] args) {
        Object[][] obj = {
            {"String0", 42, 13.75},
            {"String1", 58, 92.43},
            {"String2", 7, 44.12},
            {"String3", 90, 66.21},
            {"String4", 33, 15.56},
            {"String5", 81, 28.99},
            {"String6", 14, 76.43},
            {"String7", 53, 80.34},
            {"String8", 26, 12.85},
            {"String9", 69, 47.20},
            {"String10", 5, 9.78},
            {"String11", 74, 38.67},
            {"String12", 39, 61.11},
            {"String13", 88, 48.56},
            {"String14", 11, 29.42},
            {"String15", 64, 72.89},
            {"String16", 37, 17.94},
            {"String17", 95, 83.45},
            {"String18", 2, 55.37},
            {"String19", 47, 22.14},
            {"String20", 18, 31.65},
            {"String21", 50, 14.78},
            {"String22", 21, 40.26},
            {"String23", 60, 8.94},
            {"String24", 83, 63.57},
            {"String25", 6, 19.23},
            {"String26", 71, 88.61},
            {"String27", 32, 45.18},
            {"String28", 9, 33.74},
            {"String29", 56, 70.03},
            {"String30", 84, 26.40},
            {"String31", 13, 57.12},
            {"String32", 41, 49.76},
            {"String33", 89, 61.33},
            {"String34", 28, 36.28},
            {"String35", 72, 20.90},
            {"String36", 15, 11.52},
            {"String37", 96, 42.83},
            {"String38", 3, 78.69},
            {"String39", 65, 25.11},
            {"String40", 19, 62.47},
            {"String41", 55, 43.15},
            {"String42", 22, 18.32},
            {"String43", 73, 87.94},
            {"String44", 8, 53.21},
            {"String45", 40, 34.18},
            {"String46", 90, 29.56},
            {"String47", 36, 76.02},
            {"String48", 77, 81.45},
            {"String49", 10, 64.32}
        };

        MyObject[] tobeSort = new MyObject[obj.length];
        for (int i=0; i<obj.length; i++) {
            tobeSort[i] = new MyObject((String) obj[i][0], (int) obj[i][1], (double) obj[i][2]);
        }

        Arrays.sort(tobeSort, new MyObjectComparator());

        for (MyObject m : tobeSort) {
            System.out.println(m);
        }
    }
}

