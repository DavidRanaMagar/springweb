
package com.spring.stock.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Roles> roles;

    public Users() {
    }
    
    public Users(Users user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }

    public Users(int id, String email, String password, Set<Roles> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    

    public Users(String email, String password, Set<Roles> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    
    
    
}
