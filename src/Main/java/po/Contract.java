package po;

import java.util.Date;

/**
 * Created by tiang on 2018/7/16.
 * 合同实体对象
 */
public class Contract {
    private Integer orgID;
    private Date expireAt;
    private int id;

    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
