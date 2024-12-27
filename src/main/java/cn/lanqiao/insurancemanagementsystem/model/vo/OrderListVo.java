package cn.lanqiao.insurancemanagementsystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListVo {
  private Integer order_id;
  private String order_name;
  private String order_cost;
  private String order_time;
  private String order_uname;
  private String order_uid;
  private String order_state;
  private Integer product_id;
  private String name;

}
