### 1. CSS 选择器
> * 派生选择器（通过依据元素在其位置的上下文关系来定义样式）
> * ID 选择器 （id选择器可以为有特定id的HTML元素指定特定的样式）
> * 类选择器  （类名的第一个人字符不能使用数字！无法在Mozilla 或 Firefox 中起作用）
只有适当地标记文档后，才能使用这些选择器，所以使用前需要先做一些构想和计划。

> * 属性选择器（[name]，属性和值选择器[name = '']，属性和值选择器--多个值[name ~= '']）
[abc^="def"] 选择abc属性值以"def"开头的所有元素
[abc$="def"] 选择abc属性值以"def"结尾的所有元素
[abc*="def"] 选择abc属性值中包含子串"def"的所有元素
*[abc|="def"] 选择abc属性等于def或以def-开头的所有元素
> * 类选择器 or ID 选择器
区别 1：只能在文档中使用一次
区别 2：不能使用 ID 词列表（不同于类选择器，ID选择器不能结合使用，因为ID属性不允许有以空格分隔的词列表）
区别 3：ID能包含更多含义
### 2. CSS 背景
> * background-color不能继承，其默认值是transparent，transparent是“透明”
> * background-position：center；
### 3. CSS 文本
> * text-indent 文本第一行缩进（一般来说，可以为所有块级元素应用text-indent，但无法将该属性应用于行内元素，图像之类的替换元素上也无法应用text-indent属性）
> * text-align 将块级元素或表元素居中，要通过在这些元素上适当地设置左右边距来实现
> * word-spacing（字间隔）可以改变字（单词）之间的标准间隔，默认值为normal
> * letter-spacing（字母间隔）
> * text-transform （字符转换）[uppercase 全部转为大写；lowercase 全部转为小写；capitalize 首字母大写]
> * text-decoration（文本装饰）去除下划线
### 4. CSS 字体
> * font-weight （文本的粗细）[bold：粗体；400等价于normal；700等价于bold]
> * font-size （文本大小）
**使用 em 来设置字体大小**
如果要避免在 IE中无法调整文本的问题，使用em 单位代替px。
1em 等于当前的字体尺寸。如果一个元素的font-size 为16像素，那么对于该元素，1em 就等于16像素。在设置字体大小时，em的值会相对于父元素的字体大小改变。

浏览器中默认的文本大小是16像素。因此 1 em 的默认尺寸是 16 像素。
可以使用这个公式转换为em：px/16 = em；

### 5. CSS 表格

> * 当给Table加边框后，Table具有双线条边框，这是由于table，th以及td元素都有独立的边框。
如果需要把边框显示为单线条边框，使用 border-collapse 属性。
> * 表格文本对齐 
text-align 属性设置水平对齐方式
vertical-align 属性设置垂直对齐方式

### 6. CSS 边框
> * 边框样式：solid  dotted  dashed  double
> * 要使边框出现，必须声明一个边框样式

### 7. CSS 定位
> * 相对定位  设置为相对定位的元素框会偏移某个距离。元素仍然保持其未定位前的相撞，它原本所占有的空间仍保留。
> * 绝对定位  设置为绝对定位的元素框从文档流完全删除，并相对于其包含块定位，包含块可能是文档中的另一个元素或者是初始包含块。元素原先在正常文档流中所占的空间会关闭，就好像该元素原来不存在一样。元素定位后生成一个块级框，而不论原来它在正常流中生成何种类型的框。

### 8. CSS 伪类（Pseudo-classes）
> * CSS伪类用于向某些选择器添加特殊效果
> * 锚伪类
a:link{} /*未访问的链接*/
a:visited{} /*已访问的链接*/
a:hover{} /*鼠标移动到链接上*/
a:active{} /*选定的链接*/
**提示：**在css中，a：hover必须被置于a:link和a:visited之后，才有效。
**提示：**在 CSS 定义中，a:active 必须被置于a:hover之后，才是有效的。

### 9. CSS 对齐
> * 使用margin属性来水平对齐
把左右外边距设置为auto，规定的是均等地分配可用的外边距，结果是居中的元素
如果宽度是100%，则没有对齐效果。
> * 使用 position 属性进行左和右对齐
对齐元素方法之一是使用绝对定位
> * 使用 float 属性来进行左和右对齐

### 10. CSS 清除浮动
 > * 什么是CSS清除浮动？
 在非IE浏览器下，当内容容器的高度为auto，且容器的内容中有浮动的元素，在这种情况下，容器的高度不能自适应内容的高度，使得内容溢出到容器外面而影响布局的现象。这和现象叫浮动溢出，为了防止这个现象的出现而进行的CSS处理，就叫CSS清除浮动。
 > * 1.使用带clear属性的元素
 
    <div class = "clear"></div>
    .clear{
        clear:both;
    }
    
    在浮动元素后面（同一父节点）添加一个空的div即可
    
> * 2.使用邻接元素处理
给浮动元素后面的元素添加clear属性
> * 3.给父容器增加一个样式

    .clearfix:after{
        content:"";
        display:clock;
        height:0;
        clear:both;
        visibility:hidden;
    }
    .clearfix{
        zoom:1;
    }
    
    <div class="*** *** clearfix"></div>
    该方法不会增加多余的html元素，兼容性好。
