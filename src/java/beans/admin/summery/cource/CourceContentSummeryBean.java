/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery.cource;
import entity.CourceContent;
import java.io.Serializable;
import library.FacesUtilities;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.CourceContentRepository;

/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class CourceContentSummeryBean implements Serializable{

    List<CourceContent> courceContentList;
    private long classRoomId;

    public CourceContentSummeryBean() {
        selectCourceContentList();
    }

    public List<CourceContent> getCourceContentList() {
        return courceContentList;
    }

    public void setCourceContentList(List<CourceContent> courceContentList) {
        this.courceContentList = courceContentList;
    }

    public long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(long classRoomId) {
        this.classRoomId = classRoomId;
    }

  
    public void selectCourceContentList() {
        try {
             classRoomId = FacesUtilities.getRequestParameter("classRoomId", 0);
            CourceContentRepository courceContentRepository = new CourceContentRepository();
            if (classRoomId != 0) {
                courceContentList = courceContentRepository.listByClasRoomId(classRoomId);
            } else {
                courceContentList = courceContentRepository.list();
            }

            courceContentRepository.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filter() {
        selectCourceContentList();
    }

}
