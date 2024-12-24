package cn.lanqiao.insurancemanagementsystem.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList {
  private Integer product_id;
  private String product_name;
  private String product_desc;
  private String product_cost;
  private String product_time;
  private String is_delete;

}
