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
				
		//1.������붨��Classloader���ӿڷ������ʹ������
	    //2.�ӿڷ���interfaces�����涨��
		Class[] interfaces = new Class[]{WabinogiIN.class};
		//3.���������A.��Ҫ����Ķ���wi ��B ʵ��InvocationHandler�ӿڵĴ��������
		InvocationHandler ih = new ProxyTest().new ProxyHandler(wi);
		//����Proxy����
		Object ob = Proxy.newProxyInstance(WabinogiIN.class.getClassLoader(), interfaces, ih);
		//���ú������obͨ���ӿڵ�����Ϊ����
		((WabinogiIN)ob).GetName();
		//ob.hashCode();
		
		//����������Ӧ�ü���̫�����ˣ�https://blog.csdn.net/lovejj1994/article/details/78080124
		Class proxyclass = Proxy.getProxyClass(WabinogiIN.class.getClassLoader(), interfaces);
		//�ж�һ�������Ƿ�Ϊ����
		System.out.println(Proxy.isProxyClass(proxyclass));
	
		
	}
	
	public static void main(String... args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{ 
		//Test1();
		Test2();
	}
	
	//ProxyHandlerΪ�����࣬����ʵ��InvocationHandler����д����
	public class ProxyHandler implements InvocationHandler
	{
        private Object proxyedOb;
        //�������ô���Ĵ������ͨ��д��
        public ProxyHandler(Object proxyedOb)
        {
        	this.proxyedOb = proxyedOb;
        }
        
        public Object GetPrivateObject()
        {
        	return proxyedOb;
        }
        
		@Override //��д����
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			//����ǰ�����ɶ
			System.out.println("Proxy invoked !");
			System.out.println("Proxy Ob is: " + GetPrivateObject());
			Class<?>[] cl = null;
			if(method.equals(WabinogiIN.class.getMethod("GetName", cl)))
			{
				System.out.println("Wabinogi method GetName() invoked  !");
			}
			//������ԭʼ����
			return method.invoke(proxyedOb, args);
		}
		
		
	}
	
	
}
