
1.ANR

when

KeyDispatchTimeout(5 seconds) --主要是类型按键或触摸事件在特定时间内无响应

BroadcastTimeout(10 seconds) --BroadcastReceiver在特定时间内无法处理完成

ServiceTimeout(20 secends) --小概率事件 Service在特定的时间内无法处理完成
  caused by
  
  高耗时的操作，如图像变换
  
  数据库读写操作,磁盘读写
  
  大量的创建新对象
  
避免

UI线程尽量只做跟UI相关的工作

耗时的操作(比如数据库操作，I/O，连接网络或者别的有可能阻塞UI线程的操作)把它放在单独的线程处理

尽量用Handler来处理UIThread和别的Thread之间的交互

  实现
  
  1.使用AsyncTask
  
  在doInBackground()方法中执行耗时操作
  
  在onPostExecuted()更新UI
  
  2.handler
  
  在子线程中处理耗时操作
  
  处理完成之后，通过handler.sendMessage()传递处理结果
  
  在handler的handleMessage()方法中更新UI
  
排查：1.log 2.从trace.txt文件

#FC(Force Close) 

Error

OOM

##解决的办法

注意内存的使用和管理

使用Thread.UncaughtExceptionHandler接口

public class MyApplication extends Application implements UncaughtExceptionHandler { 

@Override 

public void onCreate() { 
}

@Override 

public void uncaughtException(Thread thread, Throwable ex) { 

thread.setDefaultUncaughtExceptionHandler( this); 

}

} 
