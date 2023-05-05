package org.example.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("interestlist")
public class interestList {
    @TableId(type= IdType.AUTO)
    private long id;
    private String interest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "interestList{" +
                "id=" + id +
                ", interest=" + interest +
                '}';
    }
}
