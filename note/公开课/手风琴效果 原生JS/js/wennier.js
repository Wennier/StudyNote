var oBg = document.getElementById('bg');

var oBox = document.getElementById('box');
var oBox_ul = oBox.children[0];
var oBox_ul_li = oBox_ul.children;




for(var i = 0; i<oBox_ul_li.length;i++){
	
	oBox_ul_li[i].index = i;
	
	
	oBox_ul_li[i].onmouseover = function(){
		
		var _index = this.index;
		
		//alert(_index);
		
		for(var j = 0; j<oBox_ul_li.length;j++){
			if(j<=_index){
			animate(oBox_ul_li[j],{'left':j*100});
		}else{
			animate(oBox_ul_li[j],{'left':789+100*(j-1)});
		}
		}
			
	oBg.style.backgroundImage = "url(img/"+(_index+1)+".jpg)";
					
	}
	
			
}

function animate(obj,json){
	
	clearInterval(obj.timer);
	
	obj.timer = setInterval(function(){
		
		var flag = true;
		
		for(var attr in json){
			
			var leader = parseInt((obj,attr)) || 0;
			var target = json[attr];
			
			var step = (target - leader);
			
			step = step>0?Math.ceil(step): Math.floor(step);
			
			leader = leader + step;
			
			obj.style[attr] = leader +'px';
			
			if(leader != target){
				flag = false;
			}
			
		}
		
		if(flag){
			clearInterval(obj.timer);
		}
		
	},100);
	
}

function getStyle(obj,attr){
	
	if(window.getComputedStyle) {
		return window.getComputedStyle(obj, null)[attr];
	} else {
		return obj.currentStyle[attr];
	}
	
}


