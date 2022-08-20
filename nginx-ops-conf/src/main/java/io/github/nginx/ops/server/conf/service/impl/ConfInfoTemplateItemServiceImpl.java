package io.github.nginx.ops.server.conf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.nginx.ops.server.conf.domain.ConfInfoTemplateItem;
import io.github.nginx.ops.server.conf.mapper.ConfInfoTemplateItemMapper;
import io.github.nginx.ops.server.conf.service.ConfInfoTemplateItemService;
import org.springframework.stereotype.Service;

/**
 * @author 24709
 * @description 针对表【conf_info_template_item(nginx配置模板表)】的数据库操作Service实现
 * @createDate 2022-08-20 14:35:15
 */
@Service
public class ConfInfoTemplateItemServiceImpl
    extends ServiceImpl<ConfInfoTemplateItemMapper, ConfInfoTemplateItem>
    implements ConfInfoTemplateItemService {}
