package com.csu.springcloud.pojo;

import lombok.experimental.Accessors;

import java.io.Serializable;

//所有实体类必须先实现序列化，不然传输时会报错
@Accessors(chain = true)     //链式写法
public class Dept implements Serializable {                   //Dept 实体类:   orm类表关系映射   mysql-dept
    private Long deptno;    //主键
    private String dname;
    private String db_source;       //看一下这个数据是存在哪个数据库的字段    微服务~一个服务对应一个数据库,同一个信息可能存在于不同的数据库

    public Dept() {
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    public Dept(String dname) {
        this.dname = dname;
    }

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}

/*
链式写法:
  Dept dept = new Dept();

  dept.setDeptNo(11).setDname('sss').setDb_source('001');
 */
