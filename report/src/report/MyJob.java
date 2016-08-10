package report;


import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{
	
	Logger logger = Logger.getLogger(MyJob.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println(">>>开始导出");
			ExcelToDisk.expData();
			System.out.println(">>>导出成功");
			logger.error(arg0.getJobDetail().getKey() +"调用计划任务在：" + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		try {
			//ExcelToDisk.expData();
			ExcelToDisk.expDataToDb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
