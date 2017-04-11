# 数组方法

## 数组的定义

* 直接声明 

```javascript
  var arr = [1,2,3];
```
* 使用Array类进行声明

```javascript
  var arr = new Array(1，2，3);
```
```javascript
  var arr = new Array(2);
```
上边的声明数字被解析为数组长度，字符串数字解析为元素

* 快速清空数组中的元素
```javascript
  arr.length = 0;             //长度设置为0;
  arr = [];                   //赋新值空数组，效率高
```
## 数组的方法

### 数组方法之添加

* push(arg);
1. 往数组最后边的位置添加元素
2. 返回值是数组的新的长度
* unshift(arg);
1. 往数字最前边的位置添加元素
2. 返回值是数组的新的长度
### 数组方法之删除

* pop();

1. 默认删除数组最后一个元素
2. 返回值是被删除的元素

* shift();

1. 默认删除数组最前边的元素
2. 返回值为被删除的元素

### 数组方法之splice()

 * splice()的删除功能
  
```javascript
  arr.splice(0,2);
```
    1. 第一个参数表示从哪个位置开始删除
    2. 第二个参数表示删除几个元素
    3. 返回值为被删除的元素
    
 * splice()的添加功能
 
```javascript
  arr.splice(1,0,'viking');
```
    1.添加元素时，第二个参数为0，表示删除0个元素
    2.无返回值
 
 * splice()的替换功能
```javascript
  arr.splice(1,2,'viking');
```
    1. 第一个参数表示从哪个位置开始替换
    2. 第二个参数表示从开始位置把几个元素替换掉
    3. 返回值为被替换的元素
    4. 也可以看作前两个参数是删除元素，后一个添加
    
### 数组方法之sort()
* sort排序时根据元素的编码大小进行排序
```javascript
  var arr = ['c','f','a','e'];
  var arr1 = [1,4,34,67,8];
  var arr2 = ['56px','3px','100px','25px'];
  arr.sort();       //['a','c','e','f']
  arr1.sort();      //[1,34,4,67,8]
  arr2.sort();
```
* 当数组元素为数字时，默认排序是将数字转化为字符串，然后进行排序。所以要将数字元素按某顺序排序，在sort方法中添加一个函数，返回a-b时，表示从小到大排序，返回b-a时表示从大到小排序【参数为int型，返回值为int型】
```javascript
  arr1.sort(function(a,b){
        return a-b;
    });
```
* 当元素为某些单位值时，传进来的参数为字符串，所以要将字符串先转换为int型
```javascript
  arr2.sort(function(a,b){
        return parseInt(a) - parseInt(b);
    });
```
* 将有顺序的数组元素打乱，采用Math工具类中的random()随机数函数，与 0.5 做差，返回一个正负值，使得参数进行随机交换
    
```javascript
  var arr3 = [1,2,3,4,5];
    arr3.sort(function(a,b){
        return Math.random() - 0.5;
    });
```
* 产生 x - y 之间的随机整数
```javascript
  Math.round(Math.random*(y-x)+x);
```
* 生成 0 - x 之间的随机整数
```javascript
   Math.round(Math.random*x);
```
* 生成1 - x 之间的随机整数（向上取整）
```javascript
   Math.ceil(Math.random*x);
```
## 数组方法之concat()
* 将两个或多个数组连接起来，成为一个新的数组
* 返回值为新的数组
```javascript
    var arr1 = [1,2,3];
    var arr2 = [4,5,6];
    arr1.concat(arr2);
```
## 数组方法之reverse()
* 将数组元素倒着排序并返回

* 如何将一个字符串中的字符倒着排列
    首先可以用split('')方法将字符串中的字符切割后存放到数组中，然后使用reverse()将数组元素倒序，最后再使用join('')方法将数组元素连接成一个字符串
```javascript
    var str ='abcdef';
    str.split('').reverse().join('');
```
