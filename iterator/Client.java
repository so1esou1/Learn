package com.csu.iterator;

import java.util.ArrayList;
import java.util.List;

//依赖Iterator接口
public class Client {
    public static void main(String[] args) {
        //创建学院
        List<College> collegeList = new ArrayList<>();

        ComputeCollege computeCollege = new ComputeCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computeCollege);
        collegeList.add(infoCollege);

        //创建输出的对象:
        OutputImpl output = new OutputImpl(collegeList);
        output.printCollege();
    }
}
