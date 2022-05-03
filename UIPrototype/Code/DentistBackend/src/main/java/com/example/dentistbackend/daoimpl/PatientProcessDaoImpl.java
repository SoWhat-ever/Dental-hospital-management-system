package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.PatientProcessDao;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.entity.Process_p;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.repository.PatientRepository;
import com.example.dentistbackend.repository.Process_p_Repository;
import com.example.dentistbackend.repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class PatientProcessDaoImpl implements PatientProcessDao{
    @Autowired
    private Process_p_Repository patientProcessRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RegRepository regRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getPatientId(String patientName)
    {
        List<Patient> list1 = patientRepository.getPatientByName(patientName);
        Iterator<Patient> iter = list1.iterator();
        if(!iter.hasNext()){//没找到对应的患者
            System.out.println("Can't find the corresponding patient!");
            return -1;
        }
        return (iter.next()).getPatientId();
    }

    @Override
    public List<Process_p> getPatientProcess(String patientName)
    {
        List<Patient> list1 = patientRepository.getPatientByName(patientName);
        Iterator<Patient> iter = list1.iterator();
        if(!iter.hasNext()){//没找到对应的患者
            System.out.println("Can't find the corresponding patient!");
            return null;
        }
        int patientId = (iter.next()).getPatientId();
        List<Registration> list2 = regRepository.getPatientOrders(patientId);//通过患者id获取其所有挂号信息
        List<Process_p> ansList = new ArrayList<>();
        for(Registration reg : list2){
            int regId = reg.getRegisterId();//通过挂号信息来获取对应的挂号id的process
            List<Process_p> process = patientProcessRepository.getProcessById(regId);
            ansList.addAll(process);
        }
        return ansList;//返回所有process构成的集合
    }

    @Override
    public Process_p updateComment(int regId, int step, String comment)
    {
        //int patientId = getPatientId(name);
        List<Process_p> process = patientProcessRepository.getProcessInfo(regId, step);//获取对应的process信息
        Iterator<Process_p> iter = process.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding process information!");
            return null;
        }
        Process_p p = iter.next();
        String sql = "update process_p set comment = ? where ID_r = ? and step = ?";
        Object[] args = {comment, regId, step};
        jdbcTemplate.update(sql, args);//更新数据库内容
        p.setComment(comment);//更新实体类的内容
        return p;
    }
}
