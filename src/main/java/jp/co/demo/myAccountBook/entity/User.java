package jp.co.demo.myAccountBook.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("USERS")
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
}