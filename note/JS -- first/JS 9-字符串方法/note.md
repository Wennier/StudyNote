# 字符串方法

## str.charAt( index );

* 表示在字符串中获取某个位置的单个字符，返回值为String
  
* index 指字符所在数组的位置
## str.charCodeAt( index );

* 表示在字符串中获取位置的单个字符的编码，返回值为number

* index 指字符所在数组的位置;
## String.fromCharCode( number );

* **是静态方法**

* 表示将参数中的字符编码转换成对应的字符

* number 指字符编码值;
## str.indexOf( index,num );

* 表示在字符串中获取单个字符或字符串的位置，函数内部有循环函数，当查找到最后一个完成时返回 -1
* index 指要获取的单个字符或字符串

* num 指要开始查找的位置
* 当要获取到字符串中所有的要查找的字符的位置

```javascript
  var str = "";
  var num = 0;
  var index = '';
  
  whlie(str.indexOf(index,num != -1)){
    console.log(str.indexOf(index,num));
    num = str.indexOf(index,num) + index.length;
  }
```
## str.lastIndexOf( index,num );

* 与str.indexOf( index,num )方法恰好相反，前者从 num 处倒着向前查找，后者从 num 处正着向后查找
## 截取类
> * subString( num1,num2 );

* 表示截取字符串中的某一段字符

* num1 指开始截取的位置，num2 指结束截取的位置

* 当参数num1 > num2 时，该函数会自动判断参数的大下从而交换参数位置

* 当任意参数小于 0 时，把小于 0 的参数改为 0

> * slice( num1,num2 );

* 功能同上

* 区别在于不会自动判断参数大小，若 num1 > num2 ，将报错

* 参数为负数时，从字符串的末端倒着查找
## str.split();

* 根据参数切割字符串的方法

1.没有参数
```javascript
  var str = 'vik';
  str.split();  ->['vik']   //  将整个字符串作为数组的一个元素
```
2.参数为空字符
```javascript
  var str = 'vik';
  str.split('');  ->['v','i','k']  //若参数是空字符，则每个字符都将被切割
```
3.特例：当以'/'为切割字符进行切割时，'/'与'''号之间也会被切割为一个空字符
```javascript
  var str = '/vik/';
  str.split('/');  ->[,'vik',]  
```
4.有两个参数时，第二个参数表示切割后保留的子字符串的个数
```javascript
  var str = '2017-4-1-08-24';
  str.split('-',3);  ->['2017','4','1'] 
```

* split() 通常与 join() 配合使用，前者是切割字符，后者是连接字符;
  
