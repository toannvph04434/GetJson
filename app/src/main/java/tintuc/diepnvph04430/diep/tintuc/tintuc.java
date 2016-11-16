package tintuc.diepnvph04430.diep.tintuc;

/**
 * Created by Joker on 11/16/2016.
 */

public class tintuc {
    int idtt;
    String loaitt;
    String tieudett;
    String anhtt;
    String noidungtt;
    String ngaytt;
    String giott;

    public tintuc(int idtt, String loaitt, String tieudett, String anhtt, String noidungtt, String ngaytt, String giott) {
        this.idtt = idtt;
        this.loaitt = loaitt;
        this.tieudett = tieudett;
        this.anhtt = anhtt;
        this.noidungtt = noidungtt;
        this.ngaytt = ngaytt;
        this.giott = giott;
    }

    public tintuc() {
    }

    public int getIdtt() {
        return idtt;
    }

    public void setIdtt(int idtt) {
        this.idtt = idtt;
    }

    public String getLoaitt() {
        return loaitt;
    }

    public void setLoaitt(String loaitt) {
        this.loaitt = loaitt;
    }

    public String getTieudett() {
        return tieudett;
    }

    public void setTieudett(String tieudett) {
        this.tieudett = tieudett;
    }

    public String getAnhtt() {
        return anhtt;
    }

    public void setAnhtt(String anhtt) {
        this.anhtt = anhtt;
    }

    public String getNoidungtt() {
        return noidungtt;
    }

    public void setNoidungtt(String noidungtt) {
        this.noidungtt = noidungtt;
    }

    public String getNgaytt() {
        return ngaytt;
    }

    public void setNgaytt(String ngaytt) {
        this.ngaytt = ngaytt;
    }

    public String getGiott() {
        return giott;
    }

    public void setGiott(String giott) {
        this.giott = giott;
    }
}
