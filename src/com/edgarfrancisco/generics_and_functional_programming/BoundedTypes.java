package com.edgarfrancisco.generics_and_functional_programming;

public class BoundedTypes <T extends Number> {
    T[] nums;

    public BoundedTypes(T[] nums) {
        this.nums = nums;
    }
    
    public double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum / nums.length;
    }

    boolean sameAvg(BoundedTypes<?> ob) {
        if(average() == ob.average())
            return true;
        return false;
    }
}

class BoundedTypesDemo {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5};
        BoundedTypes<Integer> integerArr = new BoundedTypes<>(intArr);
        double average = integerArr.average();
        System.out.println("integerArr average is " + average);

        Double[] doubArr = {1.0, 2.0, 3.0, 4.0, 5.0};
        BoundedTypes<Double> doubleArr = new BoundedTypes<>(doubArr);
        double average2 = doubleArr.average();
        System.out.println("doubleArr average is " + average2);

        Integer inums[] = { 1, 2, 3, 4, 5 };
        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };

        BoundedTypes<Integer> iob = new BoundedTypes<>(inums);
        BoundedTypes<Double> dob = new BoundedTypes<>(dnums);

        if(iob.sameAvg(dob))
            System.out.println("Averages are the same.");
        else
            System.out.println("Averages differ.");

    }
}
