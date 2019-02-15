import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void Test1()
	{ 
		ProxyTest pt = new ProxyTest();
		InvocationHandler ih = pt.new ProxyHandler(10);
		
		Class[] interfaces = new Class[]{Comparable.class};
		
		Object ob = Proxy.newProxyInstance(null, interfaces, ih);
		System.out.println(((Comparable)ob).compareTo(4));
	}
	public static void Test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{ 
		Wabinogi wi = new Wabinogi();
				
		//1.代理必须定义Classloader、接口方法、和代理对象
	    //2.接口方法interfaces有下面定义
		Class[] interfaces = new Class[]{WabinogiIN.class};
		//3.代理对象由A.需要代理的对象wi 和B 实现InvocationHandler接口的代理类组成
		InvocationHandler ih = new ProxyTest().new ProxyHandler(wi);
		//代理Proxy调用
		Object ob = Proxy.newProxyInstance(WabinogiIN.class.getClassLoader(), interfaces, ih);
		//调用后代理人ob通过接口调用行为方法
		((WabinogiIN)ob).GetName();
		//ob.hashCode();
		
		//代理类其他应用见，太复杂了！https://blog.csdn.net/lovejj1994/article/details/78080124
		Class proxyclass = Proxy.getProxyClass(WabinogiIN.class.getClassLoader(), interfaces);
		//判断一个对象是否为代理
		System.out.println(Proxy.isProxyClass(proxyclass));
	
		
	}
	
	public static void main(String... args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{ 
		//Test1();
		Test2();
	}
	
	//ProxyHandler为代理类，必须实现InvocationHandler和重写方法
	public class ProxyHandler implements InvocationHandler
	{
        private Object proxyedOb;
        //代理类获得传入的代理对象，通用写法
        public ProxyHandler(Object proxyedOb)
        {
        	this.proxyedOb = proxyedOb;
        }
        
        public Object GetPrivateObject()
        {
        	return proxyedOb;
        }
        
		@Override //重写方法
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			//代理前做点儿啥
			System.out.println("Proxy invoked !");
			System.out.println("Proxy Ob is: " + GetPrivateObject());
			Class<?>[] cl = null;
			if(method.equals(WabinogiIN.class.getMethod("GetName", cl)))
			{
				System.out.println("Wabinogi method GetName() invoked  !");
			}
			//最后调用原始方法
			return method.invoke(proxyedOb, args);
		}
		
		
	}
	
	
}
