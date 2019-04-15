ListView的四种优化方式
优化方式一：
convertView的复用
  第一种优化就是重用convertView，这也是最简单的一种优化方式，就是在Adapter类的getView方法中通过判断convertView是否为null，是的话就需要在创建一个视图出来，然后给视图设置数据，最后将这个视图返回给底层，呈现给用户；如果不为null的话，其他新的view可以通过复用的方式使用已经消失的条目view，重新设置上数据然后展现出来。

代码如下：

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {

//如果当前的convertView为null，则通过inflate产生一个view

    convertView = View.inflate(context, R.layout.layout_pic_item,null);
    }

    TextView tvDis = (TextView) convertView.findViewById(R.id.tv_item_picture_desc);

    tvDis.setText("设置数据");

    return convertView;
}


优化方式二：
ViewHolder的使用
  第一种优化方式有个缺点，就是每次在findviewById，重新找到控件，然后对控件进行赋值，这样会减慢加载的速度，其实我们可以创建一个内部类ViewHolder，里面的成员变量和view中所包含的组件个数、类型相同，在convertview为null的时候，把findviewbyId找到的控件赋给ViewHolder中对应的变量，就相当于先把它们装进一个容器，下次要用的时候，直接从容器中获取，这样是不是比findviewbyId效率要高一点？

需要用到两个方法：setTag和getTag方法：

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View itemView = null;
        if (convertView == null) {
            itemView = View.inflate(context, R.layout.item_news_data, null);
            holder = new ViewHolder(itemView);
            //用setTag的方法把ViewHolder与convertView "绑定"在一起
            itemView.setTag(holder);
        } else {

    //当不为null时，我们让itemView=converView，用getTag方法取出这个itemView对应的holder对象，就可以获取这个itemView对象中的组件

            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }

        NewsBean newsBean = newsListDatas.get(position);
        holder.tvNewsTitle.setText(newsBean.title);
        holder.tvNewsDate.setText(newsBean.pubdate);
        mBitmapUtils.display(holder.ivNewsIcon, newsBean.listimage);

        return itemView;
    }

}

public class ViewHolder {
    @ViewInject(R.id.iv_item_news_icon)
    private ImageView ivNewsIcon;// 新闻图片
    @ViewInject(R.id.tv_item_news_title)
    private TextView tvNewsTitle;// 新闻标题
    @ViewInject(R.id.tv_item_news_pubdate)
    private TextView tvNewsDate;// 新闻发布时间
    @ViewInject(R.id.tv_comment_count)
    private TextView tvCommentIcon;// 新闻评论

    public ViewHolder(View itemView) {
        ViewUtils.inject(this, itemView);
    }
}


优化方式三：

使用分段加载 
  有些情况下我们需要加载网络中的数据，显示到ListView，而往往此时都是数据量比较多的一种情况，如果数据有1000条，没有优化过的ListView都是会一次性把数据全部加载出来的，很显然需要一段时间才能加载出来，我们不可能让用户面对着空白的屏幕等好几分钟，那么这时我们可以使用分段加载，比如先设置每次加载数据10条，当用户滑动ListView到底部的时候，我们再加载20条数据出来，然后使用Adapter刷新ListView，这样用户只需要等待10条数据的加载时间，这样也可以缓解一次性加载大量数据而导致OOM崩溃的情况。
优化方式四：

使用分页加载 
  上面第三种方式其实也不能完全解决OOM崩溃的情况，因为虽然我们在分段中一次只增加10条数据到List集合中，然后再刷新到ListView中去，假如有10万条数据，如果我们顺利读到最后这个List集合中还是会累积海量条数的数据，还是可能会造成OOM崩溃的情况，这时候我们就需要用到分页，比如说我们将这10万条数据分为1000页，每一页100条数据，每一页加载时都覆盖掉上一页中List集合中的内容，然后每一页内再使用分批加载，这样用户的体验就会相对好一些。
