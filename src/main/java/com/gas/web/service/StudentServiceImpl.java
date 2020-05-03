package com.gas.web.service;

import com.gas.web.entity.Student;
import com.gas.web.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Map<String, Object> studentFindAll() {
        //构造返回的 JSON 注意有格式要求   参见  resources/static/api/table.json
        Map<String, Object> res = new HashMap<>();
        List<Student> studentData = studentDao.findAll();
        String resCode = "0";
        if (studentData == null)
            resCode = "1";
        res.put("code", resCode);
        res.put("msg", "");
        res.put("count", studentData.size());
        res.put("data", studentData);
        return res;
    }

    @Override
    public List<Student> studentFindByAge(String enrollmentTime) {
        return studentDao.findByEnrollmentTime(enrollmentTime);
    }

    @Override
    public Student studentAdd(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student studentUpdate(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void studentDelete(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void studentDeleteBatch(List<Integer> stuList) {
        studentDao.deleteBatch(stuList);
    }
}
