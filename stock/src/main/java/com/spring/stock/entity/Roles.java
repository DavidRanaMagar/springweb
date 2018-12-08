
package com.spring.stock.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String role;
    @ManyToMany(mappedBy="roles",fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Users> users;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }

    public Roles(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }  

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    
    
}
