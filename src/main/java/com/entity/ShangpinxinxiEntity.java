package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 商品信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-02-23 17:06:02
 */
@TableName("shangpinxinxi")
public class ShangpinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShangpinxinxiEntity() {
		
	}
	
	public ShangpinxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 卖家号
	 */
					
	private String maijiahao;
	
	/**
	 * 卖家名
	 */
					
	private String maijiaming;
	
	/**
	 * 商品
	 */
					
	private String shangpin;
	
	/**
	 * 类型
	 */
					
	private String leixing;
	
	/**
	 * 种类
	 */
					
	private String zhonglei;
	
	/**
	 * 售价
	 */
					
	private Integer shoujia;
	
	/**
	 * 租价
	 */
					
	private Integer zujia;
	
	/**
	 * 库存
	 */
					
	private Integer kucun;
	
	/**
	 * 成色
	 */
					
	private String chengse;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 介绍
	 */
					
	private String jieshao;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：卖家号
	 */
	public void setMaijiahao(String maijiahao) {
		this.maijiahao = maijiahao;
	}
	/**
	 * 获取：卖家号
	 */
	public String getMaijiahao() {
		return maijiahao;
	}
	/**
	 * 设置：卖家名
	 */
	public void setMaijiaming(String maijiaming) {
		this.maijiaming = maijiaming;
	}
	/**
	 * 获取：卖家名
	 */
	public String getMaijiaming() {
		return maijiaming;
	}
	/**
	 * 设置：商品
	 */
	public void setShangpin(String shangpin) {
		this.shangpin = shangpin;
	}
	/**
	 * 获取：商品
	 */
	public String getShangpin() {
		return shangpin;
	}
	/**
	 * 设置：类型
	 */
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
	/**
	 * 设置：种类
	 */
	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}
	/**
	 * 获取：种类
	 */
	public String getZhonglei() {
		return zhonglei;
	}
	/**
	 * 设置：售价
	 */
	public void setShoujia(Integer shoujia) {
		this.shoujia = shoujia;
	}
	/**
	 * 获取：售价
	 */
	public Integer getShoujia() {
		return shoujia;
	}
	/**
	 * 设置：租价
	 */
	public void setZujia(Integer zujia) {
		this.zujia = zujia;
	}
	/**
	 * 获取：租价
	 */
	public Integer getZujia() {
		return zujia;
	}
	/**
	 * 设置：库存
	 */
	public void setKucun(Integer kucun) {
		this.kucun = kucun;
	}
	/**
	 * 获取：库存
	 */
	public Integer getKucun() {
		return kucun;
	}
	/**
	 * 设置：成色
	 */
	public void setChengse(String chengse) {
		this.chengse = chengse;
	}
	/**
	 * 获取：成色
	 */
	public String getChengse() {
		return chengse;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：介绍
	 */
	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}
	/**
	 * 获取：介绍
	 */
	public String getJieshao() {
		return jieshao;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
