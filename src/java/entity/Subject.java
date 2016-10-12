/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import library.BaseEntity;

/**
 *
 * @author macintoshhd
 */
@Entity
public class Subject extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;
    private String subjectName;
    private boolean mandatory;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<CourceContent> courceContentList;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Subject(long subjectId, String subjectName, boolean mandatory) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.mandatory = mandatory;
    }

    public Subject() {
    }

    public List<CourceContent> getCourceContentList() {
        return courceContentList;
    }

    public void setCourceContentList(List<CourceContent> courceContentList) {
        this.courceContentList = courceContentList;
    }

}
