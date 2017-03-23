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
