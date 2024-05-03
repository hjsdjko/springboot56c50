package com.dao;

import com.entity.ShangpinzujieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangpinzujieVO;
import com.entity.view.ShangpinzujieView;


/**
 * 商品租借
 * 
 * @author 
 * @email 
 * @date 2021-02-23 17:06:02
 */
public interface ShangpinzujieDao extends BaseMapper<ShangpinzujieEntity> {
	
	List<ShangpinzujieVO> selectListVO(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
	
	ShangpinzujieVO selectVO(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
	
	List<ShangpinzujieView> selectListView(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);

	List<ShangpinzujieView> selectListView(Pagination page,@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
	
	ShangpinzujieView selectView(@Param("ew") Wrapper<ShangpinzujieEntity> wrapper);
	
}
