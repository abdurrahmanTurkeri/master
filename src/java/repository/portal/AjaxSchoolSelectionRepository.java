/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.portal;

import entity.ClassRoom;
import entity.School;
import java.util.ArrayList;
import java.util.List;
import repository.admin.ClassRoomRepository;
import repository.admin.SchoolRepository;

/**
 *
 * @author macintoshhd
 */
public class AjaxSchoolSelectionRepository {

    private List<School> schoolList;
    private List<ClassRoom> classRoomList;

    public AjaxSchoolSelectionRepository() {

        schoolList = new ArrayList<>();
        SchoolRepository schoolRepository = new SchoolRepository();
        schoolList = schoolRepository.list();
        ClassRoomRepository classRoomRepository = new ClassRoomRepository();
        classRoomList = classRoomRepository.list();

    }

    public List<School> selectSchoolList() {
        return schoolList;

    }

    public School selectSchool(long schoolId) {

        if (schoolId == 0) {
            return null;
        }
        for (School school : schoolList) {
            if (school.getSchoolId() == schoolId) {
                return school;
            }
        }
        return null;
    }
    public ClassRoom selectClassRoom(long classRoomId) {
        if (classRoomId == 0) {
            return null;
        }
        for (School school : schoolList) {
            for (ClassRoom classRoom : school.getClassRoomList()) {
                if (classRoom.getClassRoomId()== classRoomId) {
                    return classRoom;
                }
            }
        }
        return null;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public List<ClassRoom> getClassRoomList() {
        return classRoomList;
    }

    public void setClassRoomList(List<ClassRoom> classRoomList) {
        this.classRoomList = classRoomList;
    }

}
