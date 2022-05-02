package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.repository.DoctorRepository;
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
                (!Objects.equals(username, "null")) ? username : doctor.getUsername(),
                (!Objects.equals(password, "null")) ? password : doctor.getPassword(),
                (!Objects.equals(title, "null")) ? title : doctor.getTitle(),
                (!Objects.equals(description, "null")) ? description : doctor.getDescription(),
                (!Objects.equals(image, "null")) ? image : doctor.getImage(),
        doctorId};
        jdbcTemplate.update(sql, args);//进行更新
        System.out.println("Successfully update the doctor information!");
        if(!Objects.equals(username, "null")) doctor.setUsername(username);
        if(!Objects.equals(password, "null")) doctor.setPassword(password);
        if(!Objects.equals(title, "null")) doctor.setTitle(title);
        if(!Objects.equals(description, "null")) doctor.setDescription(description);
        if(!Objects.equals(image, "null")) doctor.setImage(image);//更新实体类的实例化对象
        return doctor;
    }
}
