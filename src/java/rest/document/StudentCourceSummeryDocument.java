/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macintoshhd
 */
public class StudentCourceSummeryDocument implements Serializable {

    private List<StudentCourceDetailDocument> studentCourceList;

    public List<StudentCourceDetailDocument> getStudentCourceList() {
        if (studentCourceList == null) {
            studentCourceList = new ArrayList<>();
        }
        return studentCourceList;
    }
    public void setStudentCourceList(List<StudentCourceDetailDocument> studentCourceList) {
        this.studentCourceList = studentCourceList;
    }

}
