/*
ID: mathboy6
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;
public class gift1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("gift1.in"));
        PrintStream out = new PrintStream(new File("gift1.out"));
        HashMap<String, Integer> moneyVals = new HashMap<String, Integer>();
        int numFriends = in.nextInt();
        String[] orderedNames = new String[numFriends];
        for (int i = 0; i < numFriends; i++) {
            String s = in.next();
            moneyVals.put(s, 0);
            orderedNames[i] = s;
        }
        for(int i = 0; i < numFriends; i++){
            String curFriend = in.next();
            int totalMoney = in.nextInt();
            int totalFriends = in.nextInt();
            if(totalFriends == 0){
                continue;
            }
            for(int j = 0; j < totalFriends; j++){
                String s = in.next();
                moneyVals.put(s, moneyVals.get(s) + totalMoney/totalFriends);
            }
            moneyVals.put(curFriend, moneyVals.get(curFriend) - (totalFriends * (totalMoney/totalFriends)));
        }
        for(int i = 0; i < numFriends; i++){
            out.println(orderedNames[i] + " " + moneyVals.get(orderedNames[i]));
        }
        in.close();
        out.close();
    }
}
