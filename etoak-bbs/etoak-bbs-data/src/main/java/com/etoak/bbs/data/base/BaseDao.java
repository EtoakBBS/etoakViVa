package com.etoak.bbs.data.base ;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bbs.common.pager.Pager;


/**
 * 
 * @ClassName: BaseDao 
 * @Description: dao 底层接口  所有的dao 继承此类  
 * @author 刘林
 * @date 2016年11月25日 下午2:47:17 
 * 
 * @param <T>
 */
public interface BaseDao<T> {
	
	public int add(T t);

	public T queryById(Object id);

	public Integer update(T t);

	public Integer updateBySelect(T t);

	public Integer delete(Object id);

	public Long queryCount(@Param("entity") T t);

	public List<T> queryList(@Param("page") Pager<T> page, @Param("entity") T t);

	public T queryByAny(@Param("entity") T t);
}
