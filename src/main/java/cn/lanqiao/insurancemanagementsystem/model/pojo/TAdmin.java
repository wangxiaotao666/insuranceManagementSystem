package cn.lanqiao.insurancemanagementsystem.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAdmin {
  private Integer id;
  private String username;
  private String nickname;
  private String gender;
  private Integer age;
  private String phone;
  private String address;
  private Integer is_delete;
  private String password;

}
