/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.portal.auth;

import entity.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import library.FacesUtilities;
import repository.admin.StudentRepository;
import repository.portal.StudentLoginRepository;

@ManagedBean
@ViewScoped
public class StudentVerifyBean implements Serializable {

    private String sifre;

    public StudentVerifyBean() {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kodu Gir"));
    }

    public void sendGet() throws Exception {
        String url = "http://dokuman.ydspublishing.com.tr/CheckProduct.ashx?ACTIONNAME=CHECKPRODUCT&PRODUCTKEY=" + sifre;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // FacesContext.getCurrentInstance().getExternalContext().redirect("../StudentCourceContentSummery.xhtml");
        System.out.println(response.toString());
        if (response.toString().contains("SUCCES")) {
      
        StudentRepository studentRepository = new StudentRepository();
        Student suStudent = studentRepository.checkStudent(sifre);
        studentRepository.close();
        try {
            if (suStudent == null) {
                 writeSession(sifre);
                  FacesContext.getCurrentInstance().getExternalContext().redirect("StudentRegister.xhtml");
               
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu kod Daha once kullanılmış"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bir sorun oluştu " + e.getMessage() + " " + getClass()));
        }
        } else {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu kod Yanlış"));
        }

    }
      public void writeSession(String code) {
        HttpSession session = FacesUtilities.getSession();
        session.setAttribute("dafCode", "" +code);
      
    }


    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
