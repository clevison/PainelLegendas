/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bo.TeamBO;
import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.time.LocalDateTime;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import model.User;
 

@ManagedBean
@SessionScoped
public class CreateTeamBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public CreateTeamBean(){
        
    }
    private String nome;
    private Part imagem;
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Part getImagem() {
        return imagem;
    }
    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }
    public String register(){
        TeamBO teamBO = new TeamBO();
        if (teamBO.validateInput(nome)){
                if (teamBO.validateName(nome)){
                    String caminho = processFileUpload();
                    if(caminho != null){
                        User user = SessionUtils.getUser();
                       if(teamBO.insertTeam(nome,caminho,user.getId_User())){
                           return "main"+"?faces-redirect=true";
                       }else{
                            FacesContext.getCurrentInstance().addMessage(
                            null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Um erro interno ocorreu, Tente novamente mais tarde",""));
                       }
                        
                    }else{
                        FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Um erro interno ocorreu, Tente novamente mais tarde",""));
                    }
                }else{
                     FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Nome da Equipe já existe !",""));
                }
        }else{
            FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Nome da Equipe inválido!",""));
        }
        return "";
    }
    
    public void validateFile(FacesContext context, UIComponent component, Object value) {

        Part file = (Part) value;
        if (file == null || file.getSize() <= 0 || file.getContentType().isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Selecione um arquivo válido, PNG ou JPEG!", "");
            throw new ValidatorException(msg);
            
        } else if (file.getContentType().endsWith("png") || file.getContentType().endsWith("jpeg")) {
            //
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tipo de arquivo inválido! Selecione PNG ou JPEG!", "");
            throw new ValidatorException(msg);
        }
    }
    public String processFileUpload(){
 
        try (InputStream input = imagem.getInputStream()) {
            String caminho = "C:\\Users\\Redes\\Documents\\NetBeansProjects\\PainelLegendas\\web\\upload\\images_teams\\";
            String hash = LocalDateTime.now().toString().replace(".", "").replace(":", "").replace("-", "");
             
            Files.copy(input, new File(caminho + hash + imagem.getSubmittedFileName()).toPath());
            return hash + imagem.getSubmittedFileName();
        }catch (Exception e){
            return null;
        }
    }
    
    //code to get the submitted file name from the file part header. 
    public static String getSubmittedFileName(Part filePart)
    {
        String header = filePart.getHeader("content-disposition");
        if(header == null)
            return null;
        for(String headerPart : header.split(";"))
        {
            if(headerPart.trim().startsWith("filename"))
            {
                return headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
