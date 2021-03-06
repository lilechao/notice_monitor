# 使用方法
apicloud通知栏消息抓取模块(仅支持安卓)

该模块可以抓取安卓端其它APP的消息通知栏内容，例如支付宝，微信等

使用方法。请将data目录里面的zip包上传到你的apicloud项目模块里面。
![](https://xz-ukulele.oss-cn-hangzhou.aliyuncs.com/test/1560403271%281%29.jpg)  
然后在你的apicloud程序apiready方法里面调用notice即可，如下:
```
<body>
<div class="main">
     <h1>获取的内容将在以下展示:</h1>
     <div class="content"></div>
</div>
</body>
<script type="text/javascript">
    apiready = function() {
        var getNoticeMsg = api.require('notice');
        getNoticeMsg.notice(function(ret){	
            var r = document.getElementsByClassName("content")[0];
            var str = JSON.parse(ret['res']);
            if (str['type'] == 'add') {
              var c = "  <b>标题:</b>"+ str['title'] + "  <b>ID号:</b>"+ str['id'] + "  <b>包名:</b>"+ str['packgename'] +" <b> 时间:</b>"+ str['time'] +"  <b>内容:</b>"+ str['content'];
              r.innerHTML += "<br><span>"+ c +"</span>";
            }
        });
    };
</script>
```
# 返回值

模块返回数据类型是json字符串字段，总共有6个键值:

type(监听类型，当值为“add”表示通知栏有新的消息，当值为"remove"表示通知栏有消息移除)

id(对应的通知栏ID，可不用关心)

title(通知栏消息标题)

packgename（所对应的APP包名，例如支付宝的包名是com.eg.android.AlipayGphone，微信包名com.tencent.mm）

time(获取到通知栏消息里面的时间)

content（通知栏消息里面的具体内容，获取到的内容你可以自己处理哪些是你想要的）

# 注意事项

1.在你的程序里面调用本模块后，第一次打开你的APP时会提示开启监听权限，只用开启该权限后本模块才有效，开启后下次将不会再提示了

2.该模块有时可能出现无法获取通知消息内容的情况，重新启动多尝试几次试试（该模块没有具体优化，才会出现这种情况，我将模块源码上传到source目录下，有兴趣者你可以帮忙优化优化，当然你得要懂点儿安卓开发的东西啦）

3.该模块仅仅用于个人学习，未经本人允许，禁止将模块上传到apicloud的模块商店。禁止非法监听支付宝，微信等第三方支付的到账通知来非法谋利，被追究任何问题请后果自负

4.该模块的实现关键点在于通过安卓的NotificationListenerService类抓取其它APP的消息通知类容，将其内容保存到一个本地文件notice.txt里面，然后监听文件的内容变化，一有变化，就会将内容转发给你的APP，然后再清空notice.txt文件里面的内容

# 其它

测试效果截图：

![](https://xz-ukulele.oss-cn-hangzhou.aliyuncs.com/test/3.png)  
![](https://xz-ukulele.oss-cn-hangzhou.aliyuncs.com/test/4.png)  

若该模块对你学习有帮助，或者你觉得还行，你可以扫描下面的支付宝打赏小弟，不管多少意思意思，谢谢你啦。

![](https://xz-ukulele.oss-cn-hangzhou.aliyuncs.com/test/alipay.jpg)  


作者联系QQ：1119433875
