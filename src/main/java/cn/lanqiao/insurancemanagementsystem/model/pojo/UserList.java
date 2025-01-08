package cn.lanqiao.insurancemanagementsystem.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
  private Integer user_id;
  private String username;
  private String password;
  private String name;
  private String sex;
  private String age;
  private String phone;
  private String address;
  private String type;
  private Integer is_delete;

//  public UserList(String username, String name, String age, String phone, String address) {
//  }

}
