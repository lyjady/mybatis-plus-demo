package org.augustus.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.augustus.plus.entity.User;

/**
 * @author linyongjin
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
