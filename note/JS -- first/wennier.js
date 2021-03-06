/**
 * Created by Wennier_R on 2017/3/18.
 */


//获取元素
function $( v ){
    if(typeof v === 'function'){
        window.onload = v;
    }else if(typeof v === 'string'){
        return document.getElementById(v);
    }else if(typeof v=== "object"){
        return v;
    }
}

//获取属性的值
function getStyle(obj,attr){

    return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj)[attr];
}


//移动
function doMove (obj,attr,dir,point,endFn){
    clearInterval(obj.timer);

    /*
     * 在参数中增加一个回调函数作为新的参数，当前的程序执行完成后，紧跟着执行
     * 回调函数
     * 在程序执行完成后还需要判断回调函数这个参数是否存在
     * */
    dir = parseInt(getStyle(obj,attr)) < point ? dir:(-dir);

    obj.timer = setInterval(function(){

        var attrLeft = parseInt(getStyle(obj,attr)) + dir;

        if (attrLeft > point && dir > 0 || attrLeft < point && dir < 0 ){
            attrLeft = point;
        }

        obj.style[attr] = attrLeft+ 'px';

        if(attrLeft == point){
            clearInterval(obj.timer);

//                        if(endFn){
//                            endFn();
//                        }
            endFn && endFn();
        }
    },30);
}


//文字透明度逐渐减小
function opacity(obj,attrOpacity){
    clearInterval(obj.opa);
    obj.opa = setInterval(function(){

        obj.style.opacity = attrOpacity;
        if(attrOpacity<0){
            attrOpacity = 0;
        }
        attrOpacity -= 0.2;

        if(attrOpacity == 0){
            clearInterval(obj.opa);
        }
    },100);
}


//获取元素的绝对位置
function getPos(obj){

		var pos = {top:0,left:0};

		while(obj){
			pos.top += obj.offsetTop;
			pos.left += obj.offsetLeft;

			obj = obj.offsetParent;
		}
		return pos;
	}