package me.zhangzhen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import me.zhangzhen.domian.UserPlus;

/**
 * User 表数据库控制层接口
 */
public interface UserMapperPlus extends BaseMapper<UserPlus> {
//    @Select("selectUserList")
    List<UserPlus> selectUserList(Pagination page,String state);
    
    List<UserPlus> selectList(RowBounds rowBounds, @Param("ew") Wrapper<UserPlus> wrappe);
}