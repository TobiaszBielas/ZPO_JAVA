package Lab1.zadanie1;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args){
        double levenshtein_distance = LevQWERTY("zxcvbn", "qwerty");
        System.out.print(levenshtein_distance);
    }

    public static double LevQWERTY(String s1, String s2) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "qwertyuiop");
        map.put(2, "asdfghjkl");
        map.put(3, "zxcvbnm");
        s1 = " " + s1;
        s2 = " " + s2;
        double[][] weight = new double[s1.length()][s2.length()];

        for(int i=0; i < s1.length(); ++i){
            weight[i][0] = i;
        }
        for(int i=0; i < s2.length(); ++i){
            weight[0][i] = i;
        }

        for(int i=1; i < s1.length(); ++i){
            for(int j=1; j < s2.length(); ++j){
                double cost = 0;
                if(getKey(map,String.valueOf(s1.charAt(i))) == getKey(map,String.valueOf(s2.charAt(j))) && s1.charAt(i) != s2.charAt(j)){
                    cost += 0.5;
                }else if(s1.charAt(i) != s2.charAt(j)){
                    cost += 1;
                }
                weight[i][j] = min(weight[i-1][j]+1, weight[i][j-1]+1, weight[i-1][j-1]+cost);
            }
        }
        return weight[s1.length()-1][s2.length()-1];
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Entry<K, V> entry : map.entrySet()) {
            if (((String) entry.getValue()).contains((CharSequence) value)) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }
}