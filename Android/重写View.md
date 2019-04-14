1.新建一个类，customView.java 继承view
2.重写 onMeasure 函数，但他不是必须的，我看了imageview的源码，他也没有重写，或者说他只是摆了一个重写的框架，里面什么都没有。
       然后这个onmeasure函数，是为了满足我们的特殊需求，比如xml中定义的大小是wrap parents，但我们想要正方形，就需要重写这个函数。
       
2.重写 onlayout函数，没用过，但我知道提供该函数主要是为viewGroup类型布局子视图用的
       
3.重写 Ondraw函数 ，参数是canvas，然后新建 paint对象，最后对设好的paint 颜色啊 字体大小啊，最后对paint调用canvas对象的画图函数。

4.最后就在xml中像其他的view一样声明出来用就行了，注意的是给跟上包名，不然识别不了
