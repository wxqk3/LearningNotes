1.线程之间怎么通信
用handler///或者AsyncTask，他是对handler的封装

分两种情况：

在主线程创建handler 

在子线程创建handler,Handler在哪个线程中创建，那该线程就负责接收和处理消息,同时 该handler也持有该线程下的looper 和 消息队列的引用，

先说主线程创建handler

在子线程通过在主线程创建的handler对象发送Message

![image](https://github.com/wxqk3/LearningNotes/blob/master/res/handler.png)

 //主线程创建handler
 

            private Handler mHandler = new Handler(){
   
            @Override
            
            public void handleMessage(Message msg) {
            
                super.handleMessage(msg);
                
                //获得刚才发送的Message对象，然后在这里进行UI操作
                
                Log.e(TAG,"------------> msg.what = " + msg.what);
                
            }
            
        };
        
        
 //子线程   
 
 
                new Thread(new Runnable() {
  
                @Override
                
                public void run() {

                    SystemClock.sleep(2000);
                    //通过Handler发送一个消息切换回主线程（mHandler所在的线程）
                    mHandler.sendEmptyMessage(0);
                }
            }).start();
