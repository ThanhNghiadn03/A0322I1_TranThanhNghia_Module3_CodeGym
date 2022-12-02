package utils;

public interface ConstantService {
    String SELECT_ALL_SERVICE = "select dv.ma_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.so_nguoi_toi_da,\n" +
            "dv.tieu_chuan_phong,dv.mo_ta_tien_nghi_khac,dv.dien_tich_ho_boi,dv.so_tang,kt.ma_kieu_thue,\n" +
            "kt.ten_kieu_thue,ldv.ma_loai_dich_vu,ldv.ten_loai_dich_vu\n" +
            "from dich_vu dv join kieu_thue kt on dv.ma_kieu_thue = kt.ma_kieu_thue join loai_dich_vu ldv\n" +
            "on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu;";
    String SELECT_ALL_RENT_TYPE = "select* from kieu_thue;";
    String SELECT_ALL_SERVICE_TYPE = "select*from loai_dich_vu;";
    String INSERT_SERVICE = "insert into dich_vu (ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu)\n" +
            "value(?,?,?,?,?,?,?,?,?,?);";
    String UPDATE_SERVICE = "update dich_vu\n" +
            "set ten_dich_vu=?,dien_tich=?,chi_phi_thue=?,so_nguoi_toi_da=?,tieu_chuan_phong=?,\n" +
            "mo_ta_tien_nghi_khac=?,dien_tich_ho_boi=?,so_tang=?,ma_kieu_thue=?,ma_loai_dich_vu=?\n" +
            "where ma_dich_vu= ?;";
    String SELECT_SERVICE_BY_ID = "select dv.ma_dich_vu, dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,dv.so_nguoi_toi_da,\n" +
            "dv.tieu_chuan_phong,dv.mo_ta_tien_nghi_khac,dv.dien_tich_ho_boi,dv.so_tang,kt.ma_kieu_thue,\n" +
            "kt.ten_kieu_thue,ldv.ma_loai_dich_vu,ldv.ten_loai_dich_vu\n" +
            "from dich_vu dv join kieu_thue kt on dv.ma_kieu_thue = kt.ma_kieu_thue join loai_dich_vu ldv\n" +
            "on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu\n" +
            "where ma_dich_vu = ?;";
    String DELETE_SERVICE = "delete from dich_vu where ma_dich_vu = ?;";
}
