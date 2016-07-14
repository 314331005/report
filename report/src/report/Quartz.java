package report;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
	private static final Log log = LogFactory.getLog(DBToolkit.class); 
	private static Properties props = new Properties(); 
	private static String timer = null; 
    static { 
            try { 
                    props.load(DBToolkit.class.getResourceAsStream("/quartz.properties")); 
            } catch (IOException e) { 
                    log.error("#ERROR# :系统加载squartz.properties配置文件异常，请检查！", e); 
            } 
            
            timer = props.getProperty("timer"); 
    } 
	public static void start() throws SchedulerException {

		StdSchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();

		JobDetail job = newJob(MyJob.class).withIdentity("job1",Scheduler.DEFAULT_GROUP).build();
		try {
			Trigger trigger = newTrigger()
					.withIdentity("trigger1", Scheduler.DEFAULT_GROUP)
					.withSchedule(cronSchedule(timer)).build();
			scheduler.scheduleJob(job, trigger);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		scheduler.start();
	}
}