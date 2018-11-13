
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * hbase rowkey 与  时间互相转换
 * 
 * 时间递增
 * rowkey 递减  
 * 
 * rowkey 时间精度 纳秒
 * Date   时间精度 毫秒   INFO： rowkey转换为 Date后丢失纳秒信息，无法再还原 原 rowkey
 * unix时间戳 时间精度 秒   转换Date毫秒需要*1000
 * 
 * 
 */
public class RowKey {
    
    public static long WORLD_END = 0;// 2222-2-22 22:22:22:222:222 精确到纳秒
    
    static {
        LocalDateTime base = null;
        LocalDate date = LocalDate.of(2222, Month.FEBRUARY, 22);
        LocalTime time = LocalTime.of(22, 22, 22, 222);
        base = LocalDateTime.of(date, time);
        //(base.toEpochSecond(ZoneOffset.of("+8")));//linux timestamp 精确到秒
        WORLD_END = base.toInstant(ZoneOffset.of("+8")).toEpochMilli();//毫秒 //丢失毫秒信息(7956886942000) 。。
        WORLD_END += base.getNano();
        WORLD_END = WORLD_END*1000+222;//精确到纳秒 
    }
    
    
//    public static String getkey(LocalDateTime date){
//        
//        long ttime = date.toInstant(AppTime.zoneOffset).toEpochMilli();
//        ttime = ttime*1000 + date.getNano();
//        long lkey = WORLD_END - ttime;
//        return String.valueOf(lkey)+"0";//
//    }
//    public static LocalDateTime gettime(String key,boolean withNanosecond){
//        
//        long lkey = Long.valueOf(key.substring(0, key.length()-1));//
//        long ttime = WORLD_END - lkey;
//        long time = ttime/1000;
//        System.out.println(AppTime.getDate(time));
//        System.out.println(AppTime.getFStr(AppTime.getDate(AppTime.getLocalDateTime(time,ttime%1000))));
//        return AppTime.getLocalDateTime(time,ttime%1000);
//        
//    }
//    
    
    // 
    public static String time2key(Date date){
        
        //date = AppTime.getDate(1516346812608L);
        long time = date.getTime();
        //System.out.println("    time: "+time);
        long ttime = time*1000;// 精度   毫秒 转 纳秒  
        //System.out.println("   ttime: "+ttime);
        long lkey = WORLD_END - ttime;
        //System.out.println("    lkey: "+lkey);
        return String.valueOf(lkey)+"0";//
    }
    
    
    // 指定最后一位 符号 0-9  （有关于时间同步，数据选择的开闭区间问题）
    public static String time2key(Date date,String postfix){
        
        //date = AppTime.getDate(1516346812608L);
        long time = date.getTime();
        //System.out.println("    time: "+time);
        long ttime = time*1000;// 精度   毫秒 转 纳秒  
        //System.out.println("   ttime: "+ttime);
        long lkey = WORLD_END - ttime;
        //System.out.println("    lkey: "+lkey);
        return String.valueOf(lkey)+postfix;//
    }
    
    
    public static Date key2time(String key){
        
        long lkey = Long.valueOf(key.substring(0, key.length()-1));
        //System.out.println("    lkey: "+lkey);
        long ttime = WORLD_END - lkey;
        //System.out.println("   ttime: "+ttime);
        long time = ttime/1000;// 精度 纳秒 转 毫秒（毫秒*1000）
        //System.out.println("    time: "+time);
        Date date = new Date(time);
        //Date date = new Date(time/1000+time%1000);
        //System.out.println(AppDateFormat.getViewTime(date));
        return date;
    }
    
    public static void main(String... args)
    {
    	//7956886942222222
    	System.out.println(key2time("64148975354678164"));
    }
    
}

/*
 
 
rowkey:64405401296136892
log:src_ip,61.148.244.22
log:logstr,{category=漏洞扫描事件} {type=WebDAV写文件漏洞} {priority=提示} {typeCN=WebDAV写文件漏洞} 
{level=6} {id=46596685} 
{time=2018-01-19 15:24:18} 
{sip=61.148.244.22} 
{sport=18332}
 {dip=202.106.90.104} 
 {dport=8088} {host=202.106.90.104:8088} 
 {code=504} 
 {sysurl=/sys/web_session.php?level=6&sid=46596685} 
 {attach=/sys/web_session.php?act=download&level=6&sid=46596685} {intent=利用WebDAV写文件漏洞}
  {detail=发现请求的数据包含有敏感数据: 使用IIS WebDav的PUT协议上传文件} 
  {dev=} {url=http://202.106.90.104:8088/services/hungup-notify/users/sip:zhaoxinghua@sasac.gov.cn/index}
log:packet_pcap,group1/M00/00/08/rBAFC1phnVSASVPnAAAAAAAAAAA6861962
log:le
 
 
 
                LocalDate firstDay = LocalDate.of(2017, Month.AUGUST, 15);
                LocalDate today = LocalDate.now();
 
                // 2017年8月15日 2017年第001期 总第00001期
                //
                LocalDate firstDay = LocalDate.of(2017, Month.AUGUST, 15);
                LocalDate today = LocalDate.now();
                int allCount = (int)firstDay.until(today, ChronoUnit.DAYS) + 1;
                
                System.out.println(firstDay);
                System.out.println(today);
                System.out.println(allCount);
                
                
                int yearCount = allCount;
                if(today.getYear()!=2017) {
                    LocalDate yearFirstDay = LocalDate.of(today.getYear(), Month.JANUARY, 1);
                    yearCount = (int)yearFirstDay.until(today, ChronoUnit.DAYS) + 1;
                }

                // 其中0表示补零而不是补空格，6表示至少6位
                String allCountStr = String.format("%5d", allCount).replace(
                        " ", "0");
                String thisYearCountStr = String.format("%3d", yearCount)
                        .replace(" ", "0");

                LocalDate yesterday = today.plusDays(-1);// 不可变对象
 
 */