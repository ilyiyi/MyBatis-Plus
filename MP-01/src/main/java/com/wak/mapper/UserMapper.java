package com.wak.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wak.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wak
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
