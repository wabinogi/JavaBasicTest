
public class Singleton {

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
