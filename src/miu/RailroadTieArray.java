package miu;

public class RailroadTieArray {
    public static void main(String[] args) {

        int[] a = {1,2};

        System.out.println(isRailroadTie(a));
    }

    public static int isRailroadTie(int[] a) {
        if (a.length <= 1 || a[0] == 0 || a[a.length - 1] == 0) {
            return 0;
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] != 0 && ((a[i - 1] != 0 && a[i + 1] != 0) || (a[i - 1] == 0 && a[i + 1] == 0))) {
                return 0;
            } else if (a[i] == 0 && (a[i - 1] == 0 || a[i + 1] == 0)) {
                return 0;
            }
        }
        return 1;
    }

}
