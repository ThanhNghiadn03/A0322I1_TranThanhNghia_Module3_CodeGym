package repository.impl;

import models.customer.Customer;
import models.customer.CustomerType;
import repository.itf_customer.CustomerRepository;
import utils.ConnectionUtils;
import utils.ConstantCustomerEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.SELECT_ALL_CUSTOMER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idCustomer = rs.getInt("kh.ma_khach_hang");
                String name = rs.getString("kh.ho_ten");
                String dob = rs.getString("kh.ngay_sinh");
                boolean gender = true;
                if (rs.getInt("kh.gioi_tinh") == 0) {
                    gender = false;
                }
                long so_cmnd = rs.getLong("kh.so_cmnd");
                String sdt = rs.getString("kh.so_dien_thoai");
                String email = rs.getString("kh.email");
                String diachi = rs.getString("kh.dia_chi");
                int idCusType = rs.getInt("kh.ma_loai_khach");
                String nameCusType = rs.getString("lk.ten_loai_khach");
                Customer customer = new Customer(name,dob,gender,so_cmnd,sdt,email,diachi,idCustomer,idCusType,nameCusType);
                customerList.add(customer);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void insert(Customer t) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.INSERT_CUSTOMER);
            statement.setString(1, t.getFullName());
            statement.setString(2,t.getDob());
            statement.setBoolean(3,t.isGender());
            statement.setLong(4,t.getIdentityCardNum());
            statement.setString(5,t.getPhoneNumber());
            statement.setString(6,t.getMail());
            statement.setString(7,t.getAddress());
            statement.setInt(8,t.getType().getId());
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
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.DELETE_CUSTOMER);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void edit(Customer t) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.UPDATE_CUSTOMER);
            statement.setString(1,t.getFullName());
            statement.setString(2,t.getDob());
            statement.setInt(3, t.isGender() ? 1:0);
            statement.setLong(4, t.getIdentityCardNum());
            statement.setString(5,t.getPhoneNumber());
            statement.setString(6,t.getMail());
            statement.setString(7,t.getAddress());
            statement.setInt(8,t.getType().getId());
            statement.setInt(9, t.getIdCustomer());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.SELECT_ALL_CUS_TYPE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_loai_khach");
                String name = rs.getString("ten_loai_khach");
                CustomerType customerType = new CustomerType(id,name);
                customerTypeList.add(customerType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

    @Override
    public CustomerType findCustomerTypeById(int id) {
        CustomerType customerType = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.SELECT_CUSTYPE_BYID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idType = rs.getInt("ma_loai_khach");
                String nameType = rs.getString("ten_loai_khach");
                customerType = new CustomerType(idType,nameType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerType;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer customer = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.SELECT_CUSTOMER_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idCus = rs.getInt("kh.ma_khach_hang");
                String name = rs.getString("kh.ho_ten");
                String dob = rs.getString("kh.ngay_sinh");
                boolean gender = false;
                if (rs.getInt("kh.gioi_tinh") != 0) {
                    gender = true;
                }
                long cmnd = rs.getLong("kh.so_cmnd");
                String phoneNum = rs.getString("kh.so_dien_thoai");
                String email = rs.getString("kh.email");
                String address = rs.getString("kh.dia_chi");
                int idTypeCus = rs.getInt("kh.ma_loai_khach");
                String nameTypeCus = rs.getString("lk.ten_loai_khach");
                customer = new Customer(name,dob,gender,cmnd,phoneNum,email,address,idCus,idTypeCus,nameTypeCus);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customer;
    }
}
