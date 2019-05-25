package hello;

import lombok.Data;

import javax.persistence.*;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "role_id")
    private Integer id;

    private Integer userId;

    private String role;


    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
