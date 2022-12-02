package controller;

import models.customer.Customer;
import models.customer.CustomerType;
import models.employee.Department;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;
import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.ServiceOfServiceImpl;
import service.itf_customer.CustomerService;
import service.itf_customer.CustomerTypeService;
import service.itf_employee.DepartmentService;
import service.itf_employee.EducationDegreeService;
import service.itf_employee.EmployeeService;
import service.itf_employee.PositionService;
import service.itf_service.RentTypeService;
import service.itf_service.ServiceOfService;
import service.itf_service.ServiceTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/furama")
public class Servlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private PositionService positionService = new EmployeeServiceImpl();
    private DepartmentService departmentService = new EmployeeServiceImpl();
    private EducationDegreeService educationDegreeService = new EmployeeServiceImpl();
    private ServiceOfService serviceOfService = new ServiceOfServiceImpl();
    private RentTypeService rentTypeService = new ServiceOfServiceImpl();
    private ServiceTypeService serviceTypeService = new ServiceOfServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            doGet(request,response);
            return;
        }
        switch (action) {
            case "createCustomer" :
                createNewCustomer(request,response);
                break;
            case "deleteCustomer" :
                deleteCustomer(request,response);
                break;
            case "editCustomer" :
                editCustomer(request,response);
                break;
            case "createEmployee" :
                createNewEmployee(request,response);
                break;
            case "createService" :
                createNewService(request,response);
                break;
            case "deleteEmployee" :
                deleteEmployee(request,response);
                break;
            case "editEmployee" :
                editEmployee(request,response);
                break;
            case "editService" :
                editService(request,response);
                break;
            default:
                doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            action = "home";
        }
        switch (action) {
            case "createCustomer" :
                showFormCreateCustomer(request,response);
                break;
            case "deleteCustomer" :
                deleteCustomer(request,response);
                break;
            case "editCustomer" :
                showFormUpdateCustomer(request,response);
                break;
            case "listCustomer" :
                showListCustomer(request,response);
                break;
            case "listEmployee" :
                showListEmployee(request,response);
                break;
            case "listService" :
                showListService(request,response);
                break;
            case "createEmployee" :
                showFormCreateEmployee(request,response);
                break;
            case "createService" :
                showFormCreateService(request,response);
                break;
            case "deleteEmployee" :
                deleteEmployee(request,response);
                break;
            case "editEmployee" :
                showFormUpdateEmployee(request,response);
                break;
            case "editService" :
                showFormUpdateService(request,response);
                break;
            default:
                showHome(request,response);
                break;
        }
    }
    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = null;
        customerList = customerService.findAll();
        request.setAttribute("listCustomer",customerList);
        try {
            request.getRequestDispatcher("WEB-INF/views/customer/list_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = null;
        serviceList = serviceOfService.findAll();
        request.setAttribute("listService",serviceList);
        try {
            request.getRequestDispatcher("WEB-INF/views/service/list_service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showListRentType(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = null;
        rentTypeList = rentTypeService.findAllRentType();
        request.setAttribute("rentTypeList",rentTypeList);
    }
    private void showListServiceType(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypeList = null;
        serviceTypeList = serviceTypeService.findAllServiceType();
        request.setAttribute("serviceTypeList",serviceTypeList);
    }
    private void showListCusType(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = null;
        customerTypeList = customerTypeService.findAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
    }
    private void showListPosition(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = null;
        positionList = positionService.findAllPosition();
        request.setAttribute("positionList",positionList);
    }
    private void showListEduDegree(HttpServletRequest request, HttpServletResponse response) {
        List<EducationDegree> degreeList = null;
        degreeList = educationDegreeService.findAllDegree();
        request.setAttribute("degreeList",degreeList);
    }
    private void showListDepartment(HttpServletRequest request, HttpServletResponse response) {
        List<Department> departmentList = null;
        departmentList = departmentService.findAllDepartment();
        request.setAttribute("departmenList",departmentList);
    }
    private void showFormCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        showListCusType(request,response);
        try {
            request.getRequestDispatcher("WEB-INF/views/customer/create_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        showListPosition(request,response);
        showListDepartment(request,response);
        showListEduDegree(request,response);
        try {
            request.getRequestDispatcher("WEB-INF/views/employee/create_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormCreateService(HttpServletRequest request, HttpServletResponse response) {
        showListRentType(request,response);
        showListServiceType(request,response);
        try {
            request.getRequestDispatcher("WEB-INF/views/service/create_service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        Customer customer = customerService.findCustomerByID(idCustomer);
        request.setAttribute("customer",customer);
        List<CustomerType> customerTypeList = customerTypeService.findAllCustomerType();
        List<CustomerType> typeCustomer = new ArrayList<>();
        typeCustomer.add(customer.getType());
        for (CustomerType ct : customerTypeList) {
            if (ct.getId() != customer.getType().getId()) {
                typeCustomer.add(ct);
            }
        }
        request.setAttribute("customerTypeList",typeCustomer);
        try {
            request.getRequestDispatcher("WEB-INF/views/customer/edit_customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
        Employee employee = employeeService.findEmployeeByID(idEmployee);
        request.setAttribute("employee",employee);
        List<Position> positionList = positionService.findAllPosition();
        List<Position> listPos = new ArrayList<>();
        listPos.add(employee.getPosition());
        for (Position p : positionList) {
            if (p.getIdPosition() != employee.getPosition().getIdPosition()) {
                listPos.add(p);
            }
        }
        request.setAttribute("positionList",listPos);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAllDegree();
        List<EducationDegree> degreeList = new ArrayList<>();
        degreeList.add(employee.getEducationDegree());
        for (EducationDegree ed:educationDegreeList) {
            if (ed.getIdEduDegree()!=employee.getEducationDegree().getIdEduDegree()) {
                degreeList.add(ed);
            }
        }
        request.setAttribute("degreeList",degreeList);
        List<Department> departmentList = departmentService.findAllDepartment();
        List<Department> depList = new ArrayList<>();
        depList.add(employee.getDepartment());
        for (Department department : departmentList) {
            if (department.getIdDepartment()!=employee.getDepartment().getIdDepartment()) {
                depList.add(department);
            }
        }
        request.setAttribute("departmenList",depList);
        try {
            request.getRequestDispatcher("WEB-INF/views/employee/edit_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormUpdateService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idService"));
        Service service = serviceOfService.findServiceById(id);
        request.setAttribute("service",service);
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        List<RentType> listRent = new ArrayList<>();
        listRent.add(service.getRentType());
        for (RentType rt : rentTypeList) {
            if (rt.getIdRentType() != service.getRentType().getIdRentType()) {
                listRent.add(rt);
            }
        }
        request.setAttribute("rentType",listRent);
        List<ServiceType> serviceTypeList = serviceTypeService.findAllServiceType();
        List<ServiceType> list = new ArrayList<>();
        list.add(service.getServiceType());
        for (ServiceType st : serviceTypeList) {
            if (st.getIdServiceType() != service.getServiceType().getIdServiceType()) {
                list.add(st);
            }
        }
        request.setAttribute("serviceType",list);
        try {
            request.getRequestDispatcher("WEB-INF/views/service/edit_service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameCustomer");
        String dob = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        long idCard = Long.parseLong(request.getParameter("idenCard"));
        String phoneNumber = request.getParameter("phoneNum");
        String mail = request.getParameter("email");
        String address = request.getParameter("address");
        int idTypeCus = Integer.parseInt(request.getParameter("customerType"));
        CustomerType type = customerTypeService.findCustomerTypeByID(idTypeCus);
        Customer customer = new Customer(name,dob,gender,idCard,phoneNumber,mail,address,id,type.getId(),type.getNameTypeOfCustomer());
        customerService.edit(customer);
        showListCustomer(request,response);
    }
    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameEmployee");
        String dob = request.getParameter("dob");
        long idCard = Long.parseLong(request.getParameter("idenCard"));
        long salary = Long.parseLong(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNum");
        String mail = request.getParameter("email");
        String address = request.getParameter("address");
        int idPos = Integer.parseInt(request.getParameter("position"));
        int idEduDegree = Integer.parseInt(request.getParameter("degree"));
        int idDep = Integer.parseInt(request.getParameter("department"));
        Position position = positionService.findPositionByID(idPos);
        EducationDegree educationDegree = educationDegreeService.findDegreeByID(idEduDegree);
        Department department = departmentService.findDepartmentByID(idDep);
        Employee employee = new Employee(name,dob,idCard,phoneNumber,mail,address,id,salary,position,educationDegree,department);
        employeeService.edit(employee);
        showListEmployee(request,response);
    }
    private void editService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameService");
        int area = Integer.parseInt(request.getParameter("area"));
        long cost = Long.parseLong(request.getParameter("cost"));
        int max = Integer.parseInt(request.getParameter("maxPeople"));
        String roomStandard = request.getParameter("standardRoom");
        String des = request.getParameter("des");
        double poolArea = Double.parseDouble(request.getParameter("areaPool"));
        int numFloor = Integer.parseInt(request.getParameter("numFloor"));
        int idRentType = Integer.parseInt(request.getParameter("rentType"));
        int idServiceType = Integer.parseInt(request.getParameter("serviceType"));
        Service service = new Service(id,name,area,cost,max,roomStandard,des,poolArea,numFloor,idRentType,idServiceType);
        serviceOfService.edit(service);
        showListService(request,response);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameCustomer");
        String dob = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        long idCard = Long.parseLong(request.getParameter("idenCard"));
        String phoneNumber = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idTypeCus = Integer.parseInt(request.getParameter("customerType"));
        CustomerType type = customerTypeService.findCustomerTypeByID(idTypeCus);
        Customer customer = new Customer(name,dob,gender,idCard,phoneNumber,email,address,type);
        customerService.insert(customer);
        showListCustomer(request,response);
    }
    private void createNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameEmployee");
        String dob = request.getParameter("dob");
        long idCard = Long.parseLong(request.getParameter("idenCard"));
        String phoneNumber = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        long salary = Long.parseLong(request.getParameter("salary"));
        int idPos = Integer.parseInt(request.getParameter("position"));
        int idEduDegree = Integer.parseInt(request.getParameter("degree"));
        int idDep = Integer.parseInt(request.getParameter("department"));
        Position position = positionService.findPositionByID(idPos);
        EducationDegree educationDegree = educationDegreeService.findDegreeByID(idEduDegree);
        Department department = departmentService.findDepartmentByID(idDep);
        Employee employee = new Employee(name,dob,idCard,phoneNumber,email,address,salary,position,educationDegree,department);
        employeeService.insert(employee);
        showListEmployee(request,response);
    }
    private void createNewService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameService");
        int area = Integer.parseInt(request.getParameter("area"));
        long cost = Long.parseLong(request.getParameter("cost"));
        int max = Integer.parseInt(request.getParameter("maxPeople"));
        String roomStandard = request.getParameter("standardRoom");
        String des = request.getParameter("des");
        double poolArea = Double.parseDouble(request.getParameter("areaPool"));
        int numFloor = Integer.parseInt(request.getParameter("numFloor"));
        int idRentType = Integer.parseInt(request.getParameter("rentType"));
        int idServiceType = Integer.parseInt(request.getParameter("serviceType"));
        Service service = new Service(name,area,cost,max,roomStandard,des,poolArea,numFloor,idRentType,idServiceType);
        serviceOfService.insert(service);
        showListService(request,response);
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idCustomer"));
        customerService.deleteById(id);
        showListCustomer(request,response);
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idEmployee"));
        employeeService.deleteById(id);
        showListEmployee(request,response);
    }
    private void showHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("WEB-INF/views/home/home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = null;
        employeeList = employeeService.findAll();
        request.setAttribute("listEmployee",employeeList);
        try {
            request.getRequestDispatcher("WEB-INF/views/employee/list_employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
