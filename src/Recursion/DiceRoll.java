package Recursion;

import java.util.ArrayList;

public class DiceRoll {
    public static void main(String[] args) {
        System.out.println(diceArr("", 3));
    }
    static void dice(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<=target; i++) {
            dice(p+i, target-i);
        }
    }

    static ArrayList<String> diceArr(String p, int target){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            // if(p.length()==2){
                list.add(p);
            // }
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <=6 && i<=target; i++) {
            ans.addAll(diceArr(p+i, target-i));
        }
        return ans;
    }

    static void diceFace(String p, int target,int face){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=face && i<=target; i++) {
            diceFace(p+i, target-i,face);
        }
    }
}
