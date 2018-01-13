package pl.ejb.DAO;

import pl.ejb.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {
    private final static String UNIT_NAME = "jsfBudget";

    @PersistenceContext(unitName = UNIT_NAME)
    protected EntityManager em;

    public UserEntity findById(int id) {
        return em.find(UserEntity.class, id);
    }

    public UserEntity findByNameSingleResult(String username) {
        Query query = em.createNamedQuery("user.findByName",UserEntity.class);
        query.setParameter("username",username);
        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
    
    public UserEntity findByEmailSingleResult(String email){
        Query query = em.createNamedQuery("user.findByEmail",UserEntity.class);
        query.setParameter("email",email);
        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<UserEntity> findAll() {
        Query query = em.createNamedQuery("user.findAll",UserEntity.class);
        return query.getResultList();
    }

    public void createUser(UserEntity user){
        em.persist(user);
    }

    public void removeUser(UserEntity user){
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public void editUser(UserEntity user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
}
