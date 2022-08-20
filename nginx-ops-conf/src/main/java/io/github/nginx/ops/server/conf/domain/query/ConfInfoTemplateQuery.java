package io.github.nginx.ops.server.conf.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lihao3
 * @date 2022/8/20
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ConfInfoTemplateQuery implements Serializable {

  /** 类型 */
  private String type;
  /** 名称 */
  private String name;
  /** 备注 */
  private String remark;
}
