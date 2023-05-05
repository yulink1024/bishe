package org.example.pojo;

public class groupby {
    private long uid;
    private double count;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "groupby{" +
                "uid=" + uid +
                ", count=" + count +
                '}';
    }
}
