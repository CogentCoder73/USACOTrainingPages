/*
ID: mathboy6
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;
public class beads {
    public static void main(String[] args) throws FileNotFoundException{
        HashMap<Integer, Integer> beads = new HashMap<Integer, Integer>();
        Scanner in = new Scanner(new File("beads.in"));
        PrintStream out = new PrintStream(new File("beads.out"));
        int numBeads = in.nextInt();
        String chain = in.next();
        for(int i = 1; i <= numBeads; i++){
            int numEnds = 0;
            String brokenchain = chain.substring(i % numBeads, numBeads) + chain.substring(0, i % numBeads);
            String firstColor = Character.toString(brokenchain.charAt(0));
            for(int j = 0; j < numBeads; j++){
                String curColor = Character.toString(brokenchain.charAt(j));
                if(firstColor.equals("w")){
                    firstColor = curColor;
                    numEnds++;
                } else {
                    if(!firstColor.equals(curColor) && !curColor.equals("w")){
                        break;
                    }
                    numEnds++;
                }
            }
            String lastColor = Character.toString(brokenchain.charAt(numBeads - 1));
            /*System.out.println("firstColor: " + firstColor);
            System.out.println("frontBeads: " + numEnds);
            System.out.println("lastColor: " + lastColor);*/
            for(int j = numBeads - 1; j >= 0; j--){
                String curColor = Character.toString(brokenchain.charAt(j));
                if(lastColor.equals("w")){
                    lastColor = curColor;
                    numEnds++;
                } else {
                    if(!lastColor.equals(curColor) && !curColor.equals("w")){
                        //System.out.println("j: " + j);
                        break;
                    }
                    numEnds++;
                }
            }
            //System.out.println(brokenchain + " " + i + " " + numEnds);
            if(numEnds > numBeads){
                numEnds = numBeads;
            }
            beads.put(i, numEnds);
        }
        int maxEnds = 0;
        for(int key : beads.keySet()){
            int val = beads.get(key);
            if(val > maxEnds){
                maxEnds = val;
            }
        }
        out.println(maxEnds);
    }
}
