package bjpowernode.java.bean;

import java.io.Serializable;

public class Student implements Serializable {
        //Java虚拟机看到Serializable接口之后会自动生成一个序列版本号
        //这里没有手动写出来，虚拟机会默认提供版本号
        //序列化版本号作用
        private int no;
        private String name;

        public Student() {
        }

        public Student(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

