/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.admin.summery.cource;
import entity.Cource;
import java.io.Serializable;
import library.FacesUtilities;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import repository.admin.CourceRepository;
/**
 *
 * @author macintoshhd
 */
@ManagedBean
@RequestScoped
public class CourceSummeryBean implements Serializable{

    List<Cource> classList;
    private long selectedCourceContentId;

    public CourceSummeryBean() {
        selectCourceList();
    }

    public List<Cource> getCourceList() {
        return classList;
    }

    public void setCourceList(List<Cource> classList) {
        this.classList = classList;
    }

    public long getselectedCourceContentId() {
        return selectedCourceContentId;
    }
    public void setselectedCourceContentId(long selectedCourceContentId) {
        this.selectedCourceContentId = selectedCourceContentId;
    }
    public void selectCourceList() {
        long courceContentId = FacesUtilities.getRequestParameter("courceContentId", 0);
        CourceRepository courceRepository = new CourceRepository();
           if (courceContentId != 0) {
                classList = courceRepository.listByClasRoomId(courceContentId);
            } else {
                classList = courceRepository.list();
            } 
        courceRepository.close();
    }

    public void filter() {
        selectCourceList();
    }

}
