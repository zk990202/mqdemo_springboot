package top.kaisir.mq_in_spring.middleware.body;

import java.io.Serializable;

// 实体类需要实现序列化接口（将一个实现了Serializable接口的对象可以转换成一个字节序列，保存对象的状态）
public class User implements Serializable {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
