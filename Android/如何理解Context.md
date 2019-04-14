我看过源码 Context是一个抽象类 抽象出一个app所有应用功能的集合 startactivity sendboardcast startservice 之类的 

我们可以理解为上下文贯穿整个应用  或者 理解为一个 运行环境吧，提供了一个app应用需要的信息，资源，系统服务等等

![image](https://github.com/wxqk3/LearningNotes/blob/master/res/Context.png)

使用的话，通常可以通用，但要考虑内存溢出和其他问题

比如创建一个activity上的对话框

TextView tv = new TextView(MainActivity.this)

就不能用

TextView tv = new TextView(getApplicationContext())

不然activity销毁了，tx空指针还在，容易内存溢出
