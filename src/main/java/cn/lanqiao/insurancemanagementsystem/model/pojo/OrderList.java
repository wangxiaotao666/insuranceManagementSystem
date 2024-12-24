package cn.lanqiao.insurancemanagementsystem.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
  private Integer order_id;
  private String order_name;
  private String order_cost;
  private String order_time;
  private String order_uname;
  private String order_uid;
  private String order_state;
  private String product_id;


}
