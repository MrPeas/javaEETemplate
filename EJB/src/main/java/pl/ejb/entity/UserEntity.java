package pl.ejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "myfinance")
@NamedQueries({
        @NamedQuery(name="user.findByName",
                query="SELECT u FROM UserEntity u WHERE u.username = :username"),
        @NamedQuery(name="user.findAll",
                query="SELECT u FROM UserEntity u"),
        @NamedQuery(name="user.findByEmail",
                query="SELECT u FROM UserEntity u WHERE  u.email= :email")

})
public class UserEntity {
    private int userId;
    private String username;
    private String email;
    private String password;
    private Timestamp createTime;
    private byte banned;
    private Timestamp bannedTime;
    private byte[] bannedReason;
//    private Collection<ExpenseEntity> expensesByUserId;
//    private Collection<ExpenseCategoryEntity> expenseCategoriesByUserId;
//    private Collection<IncomeEntity> incomesByUserId;
//    private Collection<IncomeCategoryEntity> incomeCategoriesByUserId;
//    private UserRoleEntity userRoleByUserRoleIdRole;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false,unique=true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
               // Objects.equals(userRoleByUserRoleIdRole, that.userRoleByUserRoleIdRole) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, email, password, createTime);
    }

    @Basic
    @Column(name = "banned", nullable = false)
    public byte getBanned() {
        return banned;
    }

    public void setBanned(byte banned) {
        this.banned = banned;
    }

    @Basic
    @Column(name = "banned_time", nullable = true)
    public Timestamp getBannedTime() {
        return bannedTime;
    }

    public void setBannedTime(Timestamp bannedTime) {
        this.bannedTime = bannedTime;
    }

    @Basic
    @Column(name = "banned_reason", nullable = true)
    public byte[] getBannedReason() {
        return bannedReason;
    }

    public void setBannedReason(byte[] bannedReason) {
        this.bannedReason = bannedReason;
    }

//    @OneToMany(mappedBy = "userByUserUserId")
//    public Collection<ExpenseEntity> getExpensesByUserId() {
//        return expensesByUserId;
//    }
//
//    public void setExpensesByUserId(Collection<ExpenseEntity> expensesByUserId) {
//        this.expensesByUserId = expensesByUserId;
//    }
//
//    @OneToMany(mappedBy = "userByUserUserId")
//    public Collection<ExpenseCategoryEntity> getExpenseCategoriesByUserId() {
//        return expenseCategoriesByUserId;
//    }
//
//    public void setExpenseCategoriesByUserId(Collection<ExpenseCategoryEntity> expenseCategoriesByUserId) {
//        this.expenseCategoriesByUserId = expenseCategoriesByUserId;
//    }
//
//    @OneToMany(mappedBy = "userByUserUserId")
//    public Collection<IncomeEntity> getIncomesByUserId() {
//        return incomesByUserId;
//    }
//
//    public void setIncomesByUserId(Collection<IncomeEntity> incomesByUserId) {
//        this.incomesByUserId = incomesByUserId;
//    }
//
//    @OneToMany(mappedBy = "userByUserUserId")
//    public Collection<IncomeCategoryEntity> getIncomeCategoriesByUserId() {
//        return incomeCategoriesByUserId;
//    }
//
//    public void setIncomeCategoriesByUserId(Collection<IncomeCategoryEntity> incomeCategoriesByUserId) {
//        this.incomeCategoriesByUserId = incomeCategoriesByUserId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "user_role_id_role", referencedColumnName = "id_role", nullable = false)
//    public UserRoleEntity getUserRoleByUserRoleIdRole() {
//        return userRoleByUserRoleIdRole;
//    }
//
//    public void setUserRoleByUserRoleIdRole(UserRoleEntity userRoleByUserRoleIdRole) {
//        this.userRoleByUserRoleIdRole = userRoleByUserRoleIdRole;
//    }
}
