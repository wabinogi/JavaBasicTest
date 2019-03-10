
public class Singleton {

   public static void main(String...agrs)
   {
	   Integer i = new Integer(1);
	   Integer j = new Integer(0);
	   j = i;
	   i = 20;
	   System.out.println(i);
	   System.out.println(j);
   }
	
   private static Singleton sg;
   public int i = 0;
   private Singleton()
   {
	   
   }
   
   private Singleton(int ii)
   {
	   this.i = ii;
   }
   
   
   static public Singleton getInstant(int iii)
   {
	   if(sg == null)
	   {
		   sg = new Singleton(iii);
	   }
	   return sg;
   }
}
