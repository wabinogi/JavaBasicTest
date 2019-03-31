
public class Singleton {

   public static void main(String...agrs)
   {
	 
	   
   }
	
   private static Singleton sg;
   //锁定用变量
   private static Integer var = 0;
   static public Singleton getInstant()
   {
	   if(sg == null){
		  
		  //如果不锁定var变量，该单例模式是线程不安全的
		   //有可能多个线程同时判断sg == null，初始化对象
	      synchronized(var)
	      {
	        if(sg == null)
	        {
		      sg = new Singleton();
	        }
	      }
	      
	   }
	   return sg;
   }

   public static class subSingleton
   {
	   //jvm一旦加载subSingleton类，静态实例完成初始化
	   //不存在多线程不安全问题
	   //就是理论上加载时会多一步实例化的过程，因此会稍慢？
	   private static subSingleton ssl = new subSingleton();
	   public static subSingleton getSubInstance()
	   {
		   return ssl;
	   }
   }

}
