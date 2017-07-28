package me.zhangzhen.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import me.zhangzhen.domian.UserPlus;
import me.zhangzhen.mapper.UserMapperPlus;
import me.zhangzhen.service.UserServicePlus;

/**
*
* User 表数据服务层接口实现类
*
*/
@Service
public class UserServicePlusImpl extends ServiceImpl<UserMapperPlus, UserPlus> implements UserServicePlus{
   public Page<UserPlus> selectUserPage(Page<UserPlus> page, String state) {
       page.setRecords(baseMapper.selectUserList(page,state));
       return page;
   }

   public List<UserPlus> selectList(EntityWrapper<UserPlus> ew){
	   RowBounds rowBounds = new RowBounds();
	List<UserPlus> selectList = baseMapper.selectList(rowBounds , ew);
	   return selectList;
   };

}