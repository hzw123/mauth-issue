package cn.mauth.issue.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * 队列属性复制
 * 
 * @author mauth
 * @param <T>
 */
public final class ArrayListUtil<T extends Serializable> {

	private ArrayListUtil() {
	}

	/**
	 * @param source
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static <T> List<T> copy(List<?> source, Class<T> clazz)  {
		if (source.size() == 0) {
			return Collections.emptyList();
		}
		List<T> res = new ArrayList<>(source.size());
		for (Object o : source) {
			T t = null;
			try {
				t = clazz.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			BeanUtils.copyProperties(o, t);
			res.add(t);
		}
		return res;
	}

}
