package model;

public class BenhNhan {
    private String code;
    private int id;
    private String nameBN;

    public BenhNhan(int id, String nameBN) {
        this.id = id;
        this.nameBN = nameBN;
        if (this.id <10) {
            this.code = "BN" + "00"+this.id;
        } else if (this.id < 100) {
            this.code = "BN"+"0"+this.id;
        } else {
            this.code = "BN" +this.id;
        }
    }

    public BenhNhan() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBN() {
        return nameBN;
    }

    public void setNameBN(String nameBN) {
        this.nameBN = nameBN;
    }
}
