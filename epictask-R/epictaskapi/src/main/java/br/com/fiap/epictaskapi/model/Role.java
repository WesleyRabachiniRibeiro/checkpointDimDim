package br.com.fiap.epictaskapi.model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Table(name = "TB_ROLE")
@SequenceGenerator(name = "SQ_ROLE", sequenceName = "SQ_ROLE", allocationSize = 1)
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "CD_ROLE", nullable = false, length = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ROLE")
    private Long id;

    @Column(name = "NM_ROLE", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }


}

