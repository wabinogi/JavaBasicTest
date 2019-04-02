import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//1.default V getOrDefault(Object key, V defaultValue) 
		//接口默认实现非线程安全
		//返回KEY所对应的V，如果不存在返回defaultValue，key如果为空会抛异常
		
		//2.forEach(BiConsumer<? super K, ? super V> action) 
		//接口默认实现非线程安全
		//每条entrySet执行action操作，按迭代器顺序执行
		
		//3.replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
		//接口默认实现非线程安全
		//每条 entrySet 执行function操作，且将每条 entrySet 执行function结果的值替换原值
		
		//4.V putIfAbsent(K key, V value) 
		//如果key对应的值不存在，则使用value更新，返回的V为旧值（应该是NULL）
		//如果key对应的值存在，不更新，直接返回该值
		
		//5.boolean remove(Object key, Object value)
		//使用key取得的值如果和value相等，则执行remove，返回true
	    //如果取得的值和value不等，不执行remove，返回false
		
		//6. V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction)
		//如果key对应的值不存在，使用mappingFunction（key）函数算出新值，更新并返回
		//如果key对应的值存在，直接返回该值
		
		//7.V compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction) 
		//使用remappingFunction（key）算出新值，更新并返回
		//如果新值为空，可以简单的认为执行remove(key)
		
		//8.V merge(K key, V value,BiFunction<? super V, ? super V, ? extends V> remappingFunction) 
	}

}
