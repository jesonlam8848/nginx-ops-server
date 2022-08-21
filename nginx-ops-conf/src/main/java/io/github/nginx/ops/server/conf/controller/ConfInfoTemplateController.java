package io.github.nginx.ops.server.conf.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.nginx.ops.server.comm.domain.vo.R;
import io.github.nginx.ops.server.conf.domain.ConfInfoTemplate;
import io.github.nginx.ops.server.conf.domain.dto.ConfInfoTemplateDTO;
import io.github.nginx.ops.server.conf.domain.query.ConfInfoTemplateQuery;
import io.github.nginx.ops.server.conf.service.ConfInfoTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lihao3
 * @date 2022/8/20
 */
@Api(tags = "nginx参数模板接口")
@Slf4j
@RestController
@RequestMapping("conf/info/template")
@RequiredArgsConstructor
public class ConfInfoTemplateController {

  private final ConfInfoTemplateService service;

  @PostMapping
  @ApiOperation("新增接口")
  public R save(@RequestBody ConfInfoTemplateDTO dto) {
    service.save(dto);
    return R.success("新增成功!");
  }

  @DeleteMapping("{id}")
  @ApiOperation("删除接口")
  public R delete(@PathVariable String id) {
    service.delete(id);
    return R.success("删除成功!");
  }

  @PutMapping("{id}")
  @ApiOperation("修改接口")
  public R update(@PathVariable String id, @RequestBody ConfInfoTemplateDTO dto) {
    service.updateById(id, dto);
    return R.success("修改成功!");
  }

  @GetMapping
  @ApiOperation("查询列表接口")
  public R<List<ConfInfoTemplate>> list(@ModelAttribute ConfInfoTemplateQuery query) {
    List<ConfInfoTemplate> list = service.list(query);
    return R.success("查询成功!", list);
  }

  @GetMapping("page")
  @ApiOperation("分页查询列表接口")
  public R<ConfInfoTemplate> pageList(@ModelAttribute ConfInfoTemplateQuery query) {
    Page<ConfInfoTemplate> page = PageHelper.startPage(query);
    List<ConfInfoTemplate> list = service.list(query);
    return R.success("查询成功!", page);
  }

  @GetMapping("{id}")
  @ApiOperation("根据ID查询模板信息")
  public R<ConfInfoTemplateDTO> getOne(@PathVariable String id) {
    ConfInfoTemplateDTO confInfoTemplateDTO = service.getOne(id);
    return R.success("查询成功!", confInfoTemplateDTO);
  }
}
