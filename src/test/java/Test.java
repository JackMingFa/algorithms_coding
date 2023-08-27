public class Test {
    public static void main(String[] args) {

        new Test().test1(0,9);
    }

    public void test1(int i, int j) {
        if (j <= i) return;
        int mid = i + (j - i)/2;
        test1(i,mid);
        test1(mid +1, j);
        print(i, mid, j);
    }
    public void print(int i, int mid,int j) {

        System.out.println("i: " + i + " mid: "+mid +" j: " +j);
    }
}
