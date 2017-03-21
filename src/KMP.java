/**
 * kmp算法
 *
 * Created by wing on 3/21/17.
 */
public class KMP {
    public static void main(String[] args){


        String s = "asdnasklhdgooggoogle";
        String t = "google";

        int index = index(s,t);
        System.out.print(index);
    }

    private static int index(String s, String t) {

        if(s.length() < t.length()){
            return -1;
        }

        int i = 0;
        int j = 0;
        int[] next = new int[255];

        getNext(t,next);
        while (i<s.length() && j<t.length()){
            //相等则加
            if( j ==0 || s.charAt(i) == t.charAt(j)){

                i++;
                j++;
            }else {
                //不等则指针回溯
                j = next[j];
            }
        }

        if(i > t.length()){
            return i - t.length();
        }else {
            return -1;
        }


    }

    /**
     * 求next 数组
     * @param t
     * @param next
     */
    private static void getNext(String t, int[] next) {
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i<t.length()){
            if(j == -1 || t.charAt(i) == t.charAt(j)){
                i++;
                j++;
                //匹配 next 赋值
                next[i] = j;
            }else {
                //不匹配 j指针回溯
                j = next[j];
            }
        }
    }
}
