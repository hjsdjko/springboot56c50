package com.dao;

import com.entity.ShangpinzhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinzhongleiVO;
import com.entity.view.ShangpinzhongleiView;


/**
 * 商品种类
 * 
 * @author 
 * @email 
 * @date 2021-02-23 17:06:02
 */
public interface ShangpinzhongleiDao extends BaseMapper<ShangpinzhongleiEntity> {
	
	List<ShangpinzhongleiVO> selectListVO(@Param("ew") Wrapper<ShangpinzhongleiEntity> wrapper);
	
	ShangpinzhongleiVO selectVO(@Param("ew") Wrapper<ShangpinzhongleiEntity> wrapper);
	
	List<ShangpinzhongleiView> selectListView(@Param("ew") Wrapper<ShangpinzhongleiEntity> wrapper);

	List<ShangpinzhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinzhongleiEntity> wrapper);
	
	ShangpinzhongleiView selectView(@Param("ew") Wrapper<ShangpinzhongleiEntity> wrapper);
	
}
