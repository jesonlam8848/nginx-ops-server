package io.github.nginx.ops.server.conf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.nginx.ops.server.conf.domain.ConfInfoUpstreamItem;

/**
 * @author 24709
 * @description 针对表【conf_info_upstream_item(nginx 负载均衡明细配置表)】的数据库操作Service
 * @createDate 2022-08-20 14:35:15
 */
public interface ConfInfoUpstreamItemService extends IService<ConfInfoUpstreamItem> {}
