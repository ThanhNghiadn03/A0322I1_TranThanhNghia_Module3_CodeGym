package utils;

public interface ConstantCustomerEmployee {
    String SELECT_ALL_CUSTOMER = "select kh.ma_khach_hang,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,\n" +
            "kh.so_dien_thoai,kh.email,kh.dia_chi,kh.ma_loai_khach,lk.ten_loai_khach \n" +
            "from khach_hang kh join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach\n" +
            "order by kh.ma_khach_hang asc;";
    String SELECT_ALL_CUS_TYPE = "select*from loai_khach;";
    String INSERT_CUSTOMER = "insert into khach_hang (ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) value(?,?,?,?,?,?,?,?);";
    String SELECT_CUSTYPE_BYID = "select * from loai_khach where ma_loai_khach = ?;";
    String DELETE_CUSTOMER = "delete from khach_hang where ma_khach_hang = ?;";
    String SELECT_CUSTOMER_BY_ID = "select kh.ma_khach_hang,kh.ho_ten,kh.ngay_sinh,kh.gioi_tinh,kh.so_cmnd,\n" +
            "kh.so_dien_thoai,kh.email,kh.dia_chi,kh.ma_loai_khach,lk.ten_loai_khach \n" +
            "from khach_hang kh join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach\n" +
            "where kh.ma_khach_hang = ?;";
    String UPDATE_CUSTOMER = "update khach_hang\n" +
            "set ho_ten=?,ngay_sinh=?,gioi_tinh=?, so_cmnd=?,so_dien_thoai=?,email=?,dia_chi=?,ma_loai_khach=?\n" +
            "where ma_khach_hang = ?;";

    String EMPLOYEE_SELECT_ALL = "select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,nv.email,nv.diachi,vt.ma_vi_tri,vt.ten_vi_tri,td.ma_trinh_do,td.ten_trinh_do,bp.ma_bo_phan,bp.ten_bo_phan\n" +
            "from nhan_vien nv join vi_tri vt on nv.ma_vi_tri = vt.ma_vi_tri join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan;";
    String POSITION_SELECT_ALL = "select*from vi_tri;";
    String DEPARTMENT_SELECT_ALL = "select*from bo_phan;";
    String EDUCATION_DEGREE_SELECT_ALL = "select*from trinh_do;";
    String EMPLOYEE_INSERT = "insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,diachi,ma_vi_tri,ma_trinh_do,ma_bo_phan)\n" +
            "value(?,?,?,?,?,?,?,?,?,?);";
    String POSITION_SELECT_BY_ID = "select *from vi_tri where ma_vi_tri = ?;";
    String DEPARTMENT_SELECT_BY_ID = "select *from bo_phan where ma_bo_phan = ?;";
    String EDU_DEGREE_SELECT_BY_ID = "select *from trinh_do where ma_trinh_do = ?;";
    String EMPLOYEE_DELETE_BY_ID = "delete from nhan_vien where ma_nhan_vien = ?;";
    String UPDATE_EMPLOYEE = "update nhan_vien\n" +
            "set ho_ten =?,ngay_sinh=?,so_cmnd=?,luong=?,so_dien_thoai=?,email=?,diachi=?,\n" +
            "ma_vi_tri=?,ma_trinh_do=?,ma_bo_phan=?\n" +
            "where ma_nhan_vien = ?;";
    String EMPLOYEE_SELECT_BY_ID = "select nv.ma_nhan_vien,nv.ho_ten,nv.ngay_sinh,nv.so_cmnd,nv.luong,nv.so_dien_thoai,\n" +
            "nv.email,nv.diachi,vt.ma_vi_tri,vt.ten_vi_tri,td.ma_trinh_do,td.ten_trinh_do,\n" +
            "bp.ma_bo_phan,bp.ten_bo_phan\n" +
            "from nhan_vien nv join vi_tri vt on nv.ma_vi_tri = vt.ma_vi_tri join trinh_do td on \n" +
            "nv.ma_trinh_do = td.ma_trinh_do join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan\n" +
            "where ma_nhan_vien =?;";

}
