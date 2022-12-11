package repository.impl;

import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import repository.itf_service.ServiceRepository;
import utils.ConnectionUtils;
import utils.ConstantService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    @Override
    public List<RentType> findAllRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.SELECT_ALL_RENT_TYPE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_kieu_thue");
                String name = rs.getString("ten_kieu_thue");
                RentType rentType = new RentType(id,name);
                rentTypeList.add(rentType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rentTypeList;
    }

    @Override
    public RentType findRentTypeById(int id) {
        return null;
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.SELECT_ALL_SERVICE_TYPE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_loai_dich_vu");
                String name = rs.getString("ten_loai_dich_vu");
                ServiceType serviceType = new ServiceType(id,name);
                serviceTypeList.add(serviceType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypeList;
    }

    @Override
    public ServiceType findServiceTypeById(int id) {
        return null;
    }

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.SELECT_ALL_SERVICE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idService = rs.getInt("dv.ma_dich_vu");
                String nameService = rs.getString("dv.ten_dich_vu");
                int area = rs.getInt("dv.dien_tich");
                long costService = rs.getLong("dv.chi_phi_thue");
                int maxPeople = rs.getInt("dv.so_nguoi_toi_da");
                String roomStandard = rs.getString("dv.tieu_chuan_phong");
                String des = rs.getString("dv.mo_ta_tien_nghi_khac");
                double areaPool = rs.getDouble("dv.dien_tich_ho_boi");
                int numFloor = rs.getInt("dv.so_tang");
                int idRentType = rs.getInt("kt.ma_kieu_thue");
                String nameRentType = rs.getString("kt.ten_kieu_thue");
                int idServiceType = rs.getInt("ldv.ma_loai_dich_vu");
                String nameServiceType = rs.getString("ldv.ten_loai_dich_vu");
                Service service = new Service(idService,nameService,area,costService,maxPeople,roomStandard,des,areaPool,numFloor,new RentType(idRentType,nameRentType), new ServiceType(idServiceType,nameServiceType));
                serviceList.add(service);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void insert(Service service) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.INSERT_SERVICE);
            statement.setString(1,service.getNameService());
            statement.setInt(2,service.getAreaService());
            statement.setLong(3, service.getCostService());
            statement.setInt(4, service.getMaxPeople());
            statement.setString(5,service.getRoomStandard());
            statement.setString(6,service.getDescriptionOtherConvenience());
            statement.setDouble(7,service.getPoolArea());
            statement.setInt(8,service.getNumOfFloors());
            statement.setInt(9,service.getRentType().getIdRentType());
            statement.setInt(10,service.getServiceType().getIdServiceType());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.DELETE_SERVICE);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void edit(Service service) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.UPDATE_SERVICE);
            statement.setString(1,service.getNameService());
            statement.setInt(2,service.getAreaService());
            statement.setLong(3, service.getCostService());
            statement.setInt(4, service.getMaxPeople());
            statement.setString(5,service.getRoomStandard());
            statement.setString(6,service.getDescriptionOtherConvenience());
            statement.setDouble(7,service.getPoolArea());
            statement.setInt(8,service.getNumOfFloors());
            statement.setInt(9,service.getRentType().getIdRentType());
            statement.setInt(10,service.getServiceType().getIdServiceType());
            statement.setInt(11,service.getIdService());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Service findServiceById(int id) {
        Service service = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantService.SELECT_SERVICE_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idService = rs.getInt("dv.ma_dich_vu");
                String nameService = rs.getString("dv.ten_dich_vu");
                int area = rs.getInt("dv.dien_tich");
                long costService = rs.getLong("dv.chi_phi_thue");
                int maxPeople = rs.getInt("dv.so_nguoi_toi_da");
                String roomStandard = rs.getString("dv.tieu_chuan_phong");
                String des = rs.getString("dv.mo_ta_tien_nghi_khac");
                double areaPool = rs.getDouble("dv.dien_tich_ho_boi");
                int numFloor = rs.getInt("dv.so_tang");
                int idRentType = rs.getInt("kt.ma_kieu_thue");
                String nameRentType = rs.getString("kt.ten_kieu_thue");
                int idServiceType = rs.getInt("ldv.ma_loai_dich_vu");
                String nameServiceType = rs.getString("ldv.ten_loai_dich_vu");
                service = new Service(idService,nameService,area,costService,maxPeople,roomStandard,des,areaPool,numFloor,new RentType(idRentType,nameRentType), new ServiceType(idServiceType,nameServiceType));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }
}
