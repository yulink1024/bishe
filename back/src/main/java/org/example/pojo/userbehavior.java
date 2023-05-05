package org.example.pojo;

public class userbehavior {
    private String uid;
    private String gid;
    private String leiig;
    private String xingwei;
    private String time;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getLeiig() {
        return leiig;
    }

    public void setLeiig(String leiig) {
        this.leiig = leiig;
    }

    public String getXingwei() {
        return xingwei;
    }

    public void setXingwei(String xingwei) {
        this.xingwei = xingwei;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "userbehavior{" +
                "uid='" + uid + '\'' +
                ", gid='" + gid + '\'' +
                ", leiig='" + leiig + '\'' +
                ", xingwei='" + xingwei + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
