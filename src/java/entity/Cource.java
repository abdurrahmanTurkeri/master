package entity;


import entity.CourceContent;
import library.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macintoshhd
 */
@Entity
public class Cource  extends BaseEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long courceId;
    private String courceName;
    private String courseStarDate;
    private String courceEntDate;

 
    
    @ManyToOne 
    @JoinColumn(name = "courceContentId")
    private CourceContent courceContent;
    
    public long getCourceId() {
        return courceId;
    }

    public void setCourceId(long courceId) {
        this.courceId = courceId;
    }

    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String courceName) {
        this.courceName = courceName;
    }

    public String getCourseStarDate() {
        return courseStarDate;
    }

    public void setCourseStarDate(String courseStarDate) {
        this.courseStarDate = courseStarDate;
    }
    public String getCourceEntDate() {
        return courceEntDate;
    }

    public void setCourceEntDate(String courceEntDate) {
        this.courceEntDate = courceEntDate;
    }

    public CourceContent getCourceContent() {
        return courceContent;
    }

    public void setCourceContent(CourceContent courceContent) {
        this.courceContent = courceContent;
    }
    
}
