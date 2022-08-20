package io.github.nginx.ops.server.conf.controller;

import io.github.nginx.ops.server.comm.domain.vo.R;
import io.github.nginx.ops.server.conf.domain.dto.ConfInfoServerDTO;
import io.github.nginx.ops.server.conf.domain.dto.ConfInfoUpstreamDTO;
import io.github.nginx.ops.server.conf.domain.query.ConfInfoUpstreamQuery;
import io.github.nginx.ops.server.conf.service.ConfInfoUpstreamService;
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
@Api(tags = "nginx 负载均衡配置管理")
@Slf4j
@RestController
@RequestMapping("conf/info/upstream")
@RequiredArgsConstructor
public class ConfInfoUpstreamController {

  private final ConfInfoUpstreamService service;

  @PostMapping
  @ApiOperation("新增接口")
  public R save(@RequestBody ConfInfoUpstreamDTO dto) {
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
  public R update(@PathVariable String id, @RequestBody ConfInfoUpstreamDTO dto) {
    service.updateById(id, dto);
    return R.success("修改成功!");
  }

  @GetMapping
  @ApiOperation("查询列表接口")
  public R<List<ConfInfoServerDTO>> list(@ModelAttribute ConfInfoUpstreamQuery query) {
    List<ConfInfoServerDTO> list = service.list(query);
    return R.success("查询成功!", list);
  }
}