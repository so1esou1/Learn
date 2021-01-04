public class HomeWork4 {
    public static void main(String[] args) {
    //创建对象1
        Number number = new Number(10,3);
        //计算
        number.addition();
        number.substration();
        number.multiplication();
        number.division();
    }
}

class Number{
    private int n1;
    private int n2;

    public Number() {
    }

    public Number(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    public void addition(){
        //System.out.println(n1 + "+" + n2 + "=" + (n1 + n2));
        System.out.println(this.getN1()+ "+" + this.getN2() + "=" + (this.getN1() + this.getN2()));
    }
    public void substration(){
        int result = n1 - n2;
        //int result = this.getN1() - this.getN2();
        System.out.println(n1 + "-" + n2 + "=" + result);
    }
    public void multiplication(){
        int result = n1 * n2;
        System.out.println(n1 + "+" + n2 + "=" + result);

    }
    public void division(){
        //除法分子不能等于0，要做安全控制
        if(n2 == 0){
            return;
        }
        int result = n1/n2;
        System.out.println(n1 + "/" + n2 + "=" + result);
    }
}