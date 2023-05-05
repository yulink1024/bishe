package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("dianji")
public class dianji {
    @TableId(type=IdType.AUTO)
    private long id;
    private long uid;
    private long gid;
    private long clicknum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public long getClicknum() {
        return clicknum;
    }

    public void setClicknum(long clicknum) {
        this.clicknum = clicknum;
    }

    @Override
    public String toString() {
        return "dianji{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", clicknum=" + clicknum +
                '}';
    }
}
