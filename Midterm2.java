
public class Midterm2 {

    public static void main(String[] args) {
//        String s1 = args[0];
//        String s2 = args[1];
        String s1 = "aaabbababaa";
        String s2 = "aababaabbaa";

        System.out.println( getLongestCommonSubstring(s1, s2) );

//        // subs of s1
//        String [] subs = new String[s1.length()];
//        int count = 0;
//
//        for (int i = 0; i < s1.length(); i++) {
//           for (int j = i+1; j <= s1.length(); j++) {
//               String sub = s1.substring(i, j);
//               if (Arrays.binarySearch(subs, sub) < 0)
//                   subs[count++] = sub;
//           }
//        }

    }

    public static String getLongestCommonSubstring(String a, String b){
        int m = a.length();
        int n = b.length();

        int max = 0, start = 0;

        int[][] howlong = new int[m][n];

        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                if (a.charAt(i) == b.charAt(j)){
                    // special case: last letter, auto set to 1
                    if (i == m-1 || j == n-1)
                        howlong[i][j] = 1;
                    // rest: get the beforehand
                    else
                        howlong[i][j] = howlong[i+1][j+1] + 1;

                    // update max
                    if (max < howlong[i][j]) {
                        max = howlong[i][j];
                        start = i;
                    }
                }

            }
        }
        return a.substring(start, start + max);
    }
}
