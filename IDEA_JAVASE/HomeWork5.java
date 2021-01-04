public class HomeWork5 {
    public static void main(String[] args) {

    }
}
class Person {
    public void display(){
        System.out.println("姓名是：" + this.getName() + ",年龄是：" + this.getAge());
    }

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

