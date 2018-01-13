package pl.user.Beans;

import pl.ejb.DAO.UserDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ExampleBean {
    private boolean loggedIn = false;

    @EJB
    private UserDao userDao;

    public String logIn(){
        FacesContext ctx = FacesContext.getCurrentInstance();
        setLoggedIn(true);
        return "/pages/secured/secured-page.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
