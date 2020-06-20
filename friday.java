/*
ID: mathboy6
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;
public class friday{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("friday.in"));
        PrintStream out = new PrintStream(new File("friday.out"));
        int n = in.nextInt();
        int curDayOfWeek = 1;
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] total13s = new int[7];
        //Sat = 0, Sun = 1, ..., Fri = 6
        for(int i = 1900; i <= 1900 + n - 1; i++){
            if(isLeap(i)){
                daysInMonth[1] = 29;
            } else {
                daysInMonth[1] = 28;
            }
            for(int j = 0; j < 12; j++){
                for(int k = 1; k <= daysInMonth[j]; k++){
                    curDayOfWeek = (curDayOfWeek + 1) % 7;
                    if(k != 13){
                        continue;
                    }
                    total13s[curDayOfWeek]++;
                }
            }
        }
        for(int i = 0; i < 6; i++){
            out.print(total13s[i] + " ");
        }
        out.print(total13s[6]);
        out.println();
        out.close();
        in.close();
    }
    public static boolean isLeap(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return true;
        }
        return false;
    }
}
