package utils;

public interface Constant {
    String SELECT_ALL = "select ba.id, ba.nameBenhAn,ba.ngayNhapVien,ba.ngayXuatVien, bn.idBenhNhan,bn.nameBenhNhan\n" +
            "from benh_an ba join benh_nhan bn on ba.idBenhNhan = bn.idBenhNhan;";
    String UPDATE_ALL = ""
}
