
window.onload = function(){

class Circle{
		//创建对象
		//以一个圆为对象
		//设置随机的 x，y坐标，r半径，_mx，_my移动的距离
		//this.r是创建圆的半径，参数越大半径越大
		//this._mx,this._my是移动的距离，参数越大移动
		constructor(x,y){
			this.x = x;
			this.y = y;
			this.r = Math.random()*10;
			this._mx = Math.random();
			this._my = Math.random();
		}
		
		//画圆
		drawCircle(ctx){
			//beginPath()方法开始一条路径，或者重置当前的路径
			ctx.beginPath();
			
			//arc() 方法使用一个中心点和半径，为一个画布的当前子路径添加一条弧。
			ctx.arc(this.x,this.y,this.r,0,360);
			
			//closePath() 方法创建从当前点到开始点的路径。
			ctx.closePath();
			
			//fillStyle()方法设置或返回用于填充绘画的颜色、渐变或模式。
			ctx.fillStyle = 'rgba(184,143,111,0.6)';
			
			 //fill()方法    填充当前绘图（路径）
			 ctx.fill();
			 
		}
	
	//❀画直线
		drawLine(ctx,_circle){
			let dx = this.x - _circle.x;
			let dy = this.y - _circle.y;
			let d = Math.sqrt(dx*dx+dy*dy);
			
			if(d<150){
				ctx.beginPath();
				//开始一条路径，移动到位置 this.x,this.y。创建到达位置 _circle.x,_circle.y 的一条线：
				ctx.moveTo(this.x,this.y);
				ctx.lineTo(_circle.x,_circle.y);
				ctx.closePath();
				ctx.strokeStyle = 'rgba(204,204,204,0.7)';
				ctx.stroke();
			}
		}
	
		 move(w, h) {
	        this._mx = (this.x < w && this.x > 0) ? this._mx : (-this._mx);
	        this._my = (this.y < h && this.y > 0) ? this._my : (-this._my);
	        this.x += this._mx / 2;
	        this.y += this._my / 2;
			}
		
		}
	
		class currentCirle extends Circle{
			constructor(x, y) {
				super(x, y)
			}
		
		drawCircle(ctx) {
	        ctx.beginPath();
	        //注释内容为鼠标焦点的地方圆圈半径变化
	        //this.r = (this.r < 14 && this.r > 1) ? this.r + (Math.random() * 2 - 1) : 2;
	        this.r = 8;
	        ctx.arc(this.x, this.y, this.r, 0, 360);
	        ctx.closePath();
	        //ctx.fillStyle = 'rgba(0,0,0,' + (parseInt(Math.random() * 100) / 100) + ')'
	        ctx.fillStyle = 'rgba(184,143,111,0.8)'
	        ctx.fill();
	
	    }
		
	}
	//更新页面用requestAnimationFrame替代setTimeout
		window.requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
	
		let canvas = document.getElementsByClassName('banner-canvas')[0];
		let ctx = canvas.getContext('2d');
		let w = canvas.width = canvas.offsetWidth;
		let h = canvas.height = canvas.offsetHeight;
		let circles = [];
		let current_circle = new currentCirle(0, 0)
	
		let draw = function () {
		    ctx.clearRect(0, 0, w, h);
		    for (let i = 0; i < circles.length; i++) {
		        circles[i].move(w, h);
		        circles[i].drawCircle(ctx);
		        for (j = i + 1; j < circles.length; j++) {
		            circles[i].drawLine(ctx, circles[j])
		        }
		    }
	    if (current_circle.x) {
	        current_circle.drawCircle(ctx);
	        for (var k = 1; k < circles.length; k++) {
	            current_circle.drawLine(ctx, circles[k])
	        }
	    }
	    requestAnimationFrame(draw)
	}
	
	let init = function (num) {
	    for (var i = 0; i < num; i++) {
	        circles.push(new Circle(Math.random() * w, Math.random() * h));
	    }
	    draw();
	}
	window.addEventListener('load', init(60));
	window.onmousemove = function (e) {
	    e = e || window.event;
	    current_circle.x = e.clientX;
	    current_circle.y = e.clientY;
	}
	window.onmouseout = function () {
	    current_circle.x = null;
	    current_circle.y = null;
	
	}
		
};