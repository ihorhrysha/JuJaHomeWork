package ua.juja.lesson02;

public class Main {

    public static void main(String[] args) {

        //System.out.println(printPurchases(false, true));

        //System.out.println(getMonthOfYear(-1));
        //System.out.println(getMonthOfYear(8));
        //System.out.println(getMonthOfYear(12));

        //System.out.println(getDayOfTheWeek(-1));
        //System.out.println(getDayOfTheWeek(7));
        //System.out.println(getDayOfTheWeek(2));

        //int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        //int[] res = filterEven(arr);
        //for (int i = 0; i < res.length; i++) System.out.println(res[i]);

        //int[] arr = new int[]{1,3,5,7};
        //int[] res = filterEven(arr);
        //for (int i = 0; i < res.length; i++) System.out.println(res[i]);

        //System.out.println(lookFor(14));

        int[] res = lookFor(new int[]{1000});

        for (int i = 0; i < res.length; i++) System.out.println(res[i]);

    }

    public static String printPurchases(boolean hasEggs, boolean hasBread) {
        if (hasEggs && !hasBread) return "Eggs";
        else if (!hasEggs && hasBread) return "Bread";
        else if (hasEggs && hasBread) return "Eggs,Bread";
        else return "";
    }

    public static String getMonthOfYear(int number) {
        String month[] = new String[] {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        if (number<1 || number>12) return "";
        return month[number-1];
    }

    public static String getDayOfTheWeek(int dayNum) {
        String month[] = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (dayNum<1 || dayNum>7) return "";
        return month[dayNum-1];
    }

    public static int [] filterEven(int [] nums){

        int[] arr = new int[nums.length];

        int j=0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 0) arr[j++]=nums[i];

        return arr;
    }

    public static int lookFor(int max) {
        int maxSqrt=(int)Math.sqrt(max);
        int k = 0;
        for (int i = 1; i <= maxSqrt; i++)
            for (int j = 1; j <= maxSqrt; j++)
                if ((i*i+j*j)<=max) k++;

        return k;
    }

    public static int[] lookFor(int[] array) {
        int maxRangeLenght=0, minRangeBorder = 0, maxRangeBorder = 0;
        int[] res = new int[0];

        if (array.length==0) return res;
        if (array.length==1 && array[0]>0) return new int[]{0, 0};

        for (int i = 0; i < array.length-1; i++) {

            if (array[i] <= 0) continue;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] <= 0) break;

                //if (j - i >= maxRangeLenght) {
                if (j - i > maxRangeLenght) {
                    maxRangeLenght = j - i;
                    minRangeBorder = i;
                    maxRangeBorder = j;
                }
            }
        }

        if (maxRangeLenght!=0)
            res = new int[]{minRangeBorder,maxRangeBorder};

        return res;

    }
}
