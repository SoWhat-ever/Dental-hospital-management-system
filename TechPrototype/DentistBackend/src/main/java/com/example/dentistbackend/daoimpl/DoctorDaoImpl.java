package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.*;
import com.example.dentistbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    private DoctorRepository DoctorRepository;
    @Autowired
    private Process_p_Repository patientProcessRepository;
    @Autowired
    private RegRepository regRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ArrangeRepository arrangeRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Doctor findOne(Integer id){
        return DoctorRepository.getOne(id);
    }

    @Override
    public List<Doctor> getDoctors() {
        return DoctorRepository.getDoctors();
    }

    @Override
    public Doctor checkUser(String username, String password)
    {
        return DoctorRepository.checkUser(username, password);
    }

    @Override
    public Doctor getDoctorByName(String name)
    {
        List<Doctor> list = DoctorRepository.getDoctorByName(name);
        Integer id = -1;
        Iterator<Doctor> iter = list.iterator();
        while(iter.hasNext()){
            Doctor d = iter.next();
            id = d.getDoctorId();
            break;
        }
        if(id == -1){
            System.out.println("Not Found!");
            return null;
        }
        System.out.println("Success!");
        Doctor doctor = findOne(id);
        System.out.println(doctor.getDoctorId());
        System.out.println(doctor.getDeptName());
        System.out.println(doctor.getUsername());
        return doctor;
    }

    @Override
    public Doctor updateDoctor(String doctorName, String username, String password,
                               String title, String description, String image)
    {
        List<Doctor> list = DoctorRepository.getDoctorByName(doctorName);
        Iterator<Doctor> iter = list.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        Doctor doctor = iter.next();
        int doctorId = doctor.getDoctorId();
        String sql = "update doctor set username = ?, " +
                "password = ?, title = ?, description = ?, image = ? where ID_d = ?";
        Object[] args = {
                (!Objects.equals(username, "")) ? username : doctor.getUsername(),
                (!Objects.equals(password, "")) ? password : doctor.getPassword(),
                (!Objects.equals(title, "")) ? title : doctor.getTitle(),
                (!Objects.equals(description, "")) ? description : doctor.getDescription(),
                (!Objects.equals(image, "")) ? image : doctor.getImage(),
        doctorId};
        jdbcTemplate.update(sql, args);//????????????
        System.out.println("Successfully update the doctor information!");
        if(!Objects.equals(username, "")) doctor.setUsername(username);
        if(!Objects.equals(password, "")) doctor.setPassword(password);
        if(!Objects.equals(title, "")) doctor.setTitle(title);
        if(!Objects.equals(description, "")) doctor.setDescription(description);
        if(!Objects.equals(image, "")) doctor.setImage(image);//?????????????????????????????????
        return doctor;
    }

    @Override
    public Doctor addDoctor(String doctorName, String username, String password,
                            String title, String description, String deptName, String image)
    {
        List<Doctor> allList = DoctorRepository.getDoctors();
        for(Doctor d : allList){
            if(Objects.equals(d.getUsername(), username)){
                System.out.println("????????????????????????????????????");
                return null;
            }
        }//???????????????????????????????????????
        Doctor doctor = new Doctor();
        doctor.setName(doctorName);
        doctor.setUsername(username);
        doctor.setPassword(password);
        doctor.setTitle(title);
        doctor.setDescription(description);
        doctor.setDeptName(deptName);
        doctor.setImage(image);
        DoctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public Doctor deleteDoctor(String doctorName)
    {
        List<Doctor> list = DoctorRepository.getDoctorByName(doctorName);
        Iterator<Doctor> iter = list.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        Doctor doctor = iter.next();//??????????????????
        int doctorId = doctor.getDoctorId();
        List<Process_p> process = patientProcessRepository.getProcessByDoctor(doctorId);
        patientProcessRepository.deleteAll(process);//???????????????????????????????????????
        List<Orders> order = orderRepository.getDoctorOrder(doctorId);
        orderRepository.deleteAll(order);//???????????????????????????????????????
        List<Arrangement> arrange = arrangeRepository.getDoctorArrangement(doctorId);
        arrangeRepository.deleteAll(arrange);
        List<Registration> reg = regRepository.getDoctorOrders(doctorId);
        regRepository.deleteAll(reg);//???????????????????????????????????????
        DoctorRepository.delete(doctor);//?????????????????????????????????????????????
        return doctor;
    }
}
