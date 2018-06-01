package com.ugurcanlacin.simple.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ugurcanlacin.simple.model.User;
import com.ugurcanlacin.simple.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value="#{userService}")
    UserService userService;

    private String name;
    private String surname;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String username;
    private String pass;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    private   User selectedUser;
    public User getSelectedUser() {
        return selectedUser;
    }
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    private User addUser;
    public User getAddUser() {
        return addUser;
    }
    public void setAddUser(User addUser) {
        this.addUser = addUser;
    }


    private User usuario;

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void persistUser(){
        User user = new User();
        user.setName(getName());
        user.setSurname(getSurname());
        userService.saveUser(user);
    }

    @PostConstruct
    public void init(){
        users = userService.userList();
        addUser = new User();

    }


    public String controladorLogin(){
        User userEntrada = new User();
        userEntrada.setName(username);
        userEntrada.setSurname(pass);

        try {
            //User user2 = userService.getByUserPass(userEntrada.getName(),userEntrada.getSurname());

            usuario = userService.getByUserPass(userEntrada.getName(),userEntrada.getSurname());

            //System.out.print("username --->"+username+"<--- ");
            //System.out.print("user2.getName --->"+username.getName()+"<--- ");
            //System.out.print("user2.getName --->"+user2.getSurname()+"<--- ");


            if(username!= null) {
                if (username.equals(usuario.getName()) && pass.equals(usuario.getSurname())) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);

                    return "user";
                }
            }

        }catch (Exception e )
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Usuario y/o Clave Incorrectos",
                    "Please Try Again!"));

            return "login";

        }


        return "login";
    }

    public String controladorIndex(){
        //return "index.xhtml";
        return "index";
    }

    public void delete(ActionEvent actionEvent){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Se ha eliminado",  "User: " + selectedUser.getName()) );
        userService.deleteUser(selectedUser);
        init();
    }

    public void update(ActionEvent actionEvent){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Se ha actualizado información en",  "User: " + selectedUser.getName()) );
        userService.updateUser(selectedUser);
        init();
    }

    public void insertarUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Agregado exitosamente",  "User: " + addUser.getName()) );
        //context.addMessage(null, new FacesMessage("Agregado exitosamente",  "User: " + addUser.getId() +addUser.getName()+addUser.getSurname() ) );
        userService.saveUser(addUser);
        init();
    }

    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //Castear profesor
            User user = (User) context.getExternalContext().getSessionMap().get("usuario");

            if(user == null){
                context.getExternalContext().redirect("./permisos.xhtml");
            }

        }catch(Exception e){

        }
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();

        return "login";
    }

}