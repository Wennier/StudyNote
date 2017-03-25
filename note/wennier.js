/**
 * Created by Wennier_R on 2017/3/18.
 */

function $( v ){
    if(typeof v === 'function'){
        window.onload = v;
    }else if(typeof v === 'string'){
        return document.getElementById(v);
    }else if(typeof v=== "object"){
        return v;
    }
}
function getStyle(obj,attr){

    return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj)[attr];
}

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