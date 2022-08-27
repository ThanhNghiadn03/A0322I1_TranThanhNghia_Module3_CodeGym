use case_study;

select *
from khach_hang;

select *
from loai_khach;

-- cau 2
select *
from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' 
or ho_ten like 'K%') and char_length(ho_ten) <= 15;

-- cau 3
select *
from khach_hang
where ((year(now()) - year(ngay_sinh)) between 18 and 50) 
and (dia_chi like '%Quảng Trị' or dia_chi like '%Đà Nẵng');

-- cau 4
select kh.ma_khach_hang , kh.ho_ten , kh.gioi_tinh , 
count(hd.ma_khach_hang) as 'Số lần đặt phòng' , lk.ten_loai_khach
from hop_dong hd join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang 
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond'
group by kh.ma_khach_hang
order by count(hd.ma_khach_hang) asc;

-- cau 5

select kh.ma_khach_hang , kh.ho_ten, lk.ten_loai_khach,hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.ma_dich_vu,
case 
when dvdk.gia is null or hdct.so_luong is null then dv.chi_phi_thue
when dv.chi_phi_thue is null then sum(dvdk.gia*hdct.so_luong)
else dv.chi_phi_thue+sum(dvdk.gia*hdct.so_luong) 
end as 'Tổng tiền'
from khach_hang kh  left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu 
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by kh.ma_khach_hang;

-- cau 6

select dv.ma_dich_vu , dv.ten_dich_vu , dv.dien_tich , dv.chi_phi_thue,
ldv.ten_loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in (select ma_dich_vu 
from hop_dong
where month(ngay_lam_hop_dong) = 1 or month(ngay_lam_hop_dong) = 2 
or month(ngay_lam_hop_dong) = 3);

-- cau 7

select dv.ma_dich_vu , dv.ten_dich_vu , dv.dien_tich , dv.chi_phi_thue,
dv.so_nguoi_toi_da, ldv.ten_loai_dich_vu
from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in (select ma_dich_vu
from hop_dong
where year(ngay_lam_hop_dong) = 2021) and year(hd.ngay_lam_hop_dong) = 2020
group by dv.ma_dich_vu;

-- cau 8

select ho_ten
from khach_hang
group by ho_ten;

select distinct ho_ten 
from khach_hang;

(select ho_ten
from khach_hang) 
union
(select ho_ten
from khach_hang) ;

-- cau 9

select month(ngay_lam_hop_dong) as 'Tháng', count(ma_khach_hang)
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- cau 10

select hd.ma_hop_dong , hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,
hd.tien_dat_coc , sum(hdct.so_luong) as 'so_luong_dich_vu_di_kem'
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- cau 11

select dvdk.ma_dich_vu_di_kem ,kh.ma_khach_hang , kh.ho_ten ,kh.dia_chi , 
dvdk.ten_dich_vu_di_kem , lk.ten_loai_khach 
from khach_hang kh join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi like '%Vinh%' or
kh.dia_chi like '%Quảng Ngãi%');

-- cau 12

select hd.ma_hop_dong ,nv.ho_ten as 'ho_ten_nhan_vien', kh.ho_ten as 'ho_ten_khach_hang' ,
kh.so_dien_thoai , dv.ten_dich_vu ,
case
when hdct.so_luong is null then 0 
else sum(hdct.so_luong) end as 'so_luong_dich_vu_di_kem' ,
sum(hd.tien_dat_coc) as 'tien_dat_coc'
from khach_hang kh left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
left join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien 
where year(hd.ngay_lam_hop_dong) = 2020 and
(month(hd.ngay_lam_hop_dong) between 10 and 12) 
and hd.ma_hop_dong not in(select ma_hop_dong from hop_dong 
where year(hd.ngay_lam_hop_dong) = 2021 and
(month(hd.ngay_lam_hop_dong) between 1 and 6))
group by hd.ma_hop_dong;

-- cau 13

select dvdk.ten_dich_vu_di_kem , dvdk.gia , dvdk.don_vi , dvdk.trang_thai , 
sum(hdct.so_luong) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong) >= all (select sum(so_luong) from hop_dong_chi_tiet group by ma_dich_vu_di_kem);

-- cau 14

select hdct.ma_hop_dong , ldv.ten_loai_dich_vu , dvdk.ten_dich_vu_di_kem,
count(dvdk.ma_dich_vu_di_kem) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
group by dvdk.ma_dich_vu_di_kem
having count(dvdk.ma_dich_vu_di_kem) = 1;

-- cau 15

select nv.ma_nhan_vien , nv.ho_ten , td.ten_trinh_do , bp.ten_bo_phan , nv.so_dien_thoai , nv.diachi
from trinh_do td join nhan_vien nv on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
group by nv.ma_nhan_vien
having count(nv.ma_nhan_vien) <=3 ;

-- cau 16

set SQL_SAFE_UPDATES = 0;

delete from nhan_vien 
where ma_nhan_vien in (select mnv from(select nv.ma_nhan_vien as mnv
from nhan_vien nv left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
group by nv.ma_nhan_vien
having count(hd.ma_hop_dong) = 0) as m);

-- cau 17

create view tong_tien_khach_hang as
select kh.ma_khach_hang , kh.ho_ten, lk.ten_loai_khach,hd.ma_hop_dong,
dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.ma_dich_vu,
case 
when dvdk.gia is null or hdct.so_luong is null then dv.chi_phi_thue
when dv.chi_phi_thue is null then sum(dvdk.gia*hdct.so_luong)
else dv.chi_phi_thue+sum(dvdk.gia*hdct.so_luong) 
end as 'Tổng tiền'
from khach_hang kh  left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu 
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by kh.ma_khach_hang;

select ma_khach_hang
from tong_tien_khach_hang;

set SQL_SAFE_UPDATES = 0;

update khach_hang
set ma_loai_khach = 1
where ma_khach_hang in (select ma_khach_hang 
from tong_tien_khach_hang
where `Tổng tiền` >= 10000000 and year(ngay_lam_hop_dong) = 2021 and ten_loai_khach = 'Platinium');


-- cau 18
create view khach_hang_hop_dong as
select kh.ma_khach_hang,kh.ho_ten , hd.ma_hop_dong , hd.ngay_lam_hop_dong
from khach_hang kh join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang;

select * from khach_hang_hop_dong;

SET FOREIGN_KEY_CHECKS=1; -- to disable them

delete from khach_hang
where ma_khach_hang in (select mkh from (select khhd.ma_khach_hang as mkh
from khach_hang kh left join khach_hang_hop_dong khhd on khhd.ma_khach_hang = kh.ma_khach_hang 
where year(khhd.ngay_lam_hop_dong) < 2021) as m);

-- cau 19

insert into khach_hang
value (1, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(3, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1); 

create view dich_vu_di_kem_chi_tiet as
select dvdk.ma_dich_vu_di_kem , dvdk.ten_dich_vu_di_kem, hd.ngay_lam_hop_dong as 'thoi_gian_su_dung'
from dich_vu_di_kem dvdk join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu;

select * from dich_vu_di_kem_chi_tiet;

update dich_vu_di_kem
set gia = gia*2
where ma_dich_vu_di_kem in (select mdvdkct from (select dvdkct.ma_dich_vu_di_kem as mdvdkct
from dich_vu_di_kem dvdk join dich_vu_di_kem_chi_tiet dvdkct on dvdk.ma_dich_vu_di_kem = dvdkct.ma_dich_vu_di_kem
join hop_dong_chi_tiet hdct on dvdkct.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where year(dvdkct.thoi_gian_su_dung) = 2020
group by dvdkct.ma_dich_vu_di_kem
having count(dvdkct.ma_dich_vu_di_kem) >10) as m);

-- cau 20 

select kh.ma_khach_hang , kh.ho_ten as ho_ten_kh, kh.email as email_kh , 
kh.so_dien_thoai as sdt_khach_hang, kh.ngay_sinh as ngay_sinh_kh , kh.dia_chi as dia_chi_kh,
nv.ma_nhan_vien , nv.ho_ten as ho_ten_nv, nv.email as email_nv , 
nv.so_dien_thoai as sdt_nhan_vien, nv.ngay_sinh as ngay_sinh_nv , nv.diachi as dia_chi_nv
from khach_hang kh
cross join nhan_vien nv;

-- cau 21

