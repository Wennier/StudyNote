



	var box = document.getElementsByClassName('gossip-list')[0];

	var text = document.getElementsByTagName('textarea')[0];
	var send = document.getElementsByClassName('send')[0];

	var list = document.getElementsByClassName('gossip-list-ul')[0]; 
 
	var data=null,
		getText = null;

	

	function textTip(){
		text.value = "想说点什么呢？（记得点击右上角的小飞机噢~）";;

	}

	text.onblur = textTip();

	text.onfocus = function(){
		text.value = "";
	}


	send.onclick = function(){
		getText = text.value;
		data = getData();
		
		var insertNode = document.createElement('li');
		var nodeContext = "<img src='img/dataicon.png'><div class='data'>"+ data +"</div><div class='text'>"+ getText +"</div>";
		
		insertNode.innerHTML = nodeContext;
		insertNode.style.background = "rgba(0,0,0,0.05)";

	 	list.insertBefore(insertNode,list.children[0]);

	}

	function getData(){

		var myTime = new Date();
		var iYear = myTime.getFullYear();
		var iMonth = myTime.getMonth()+1;
		var iDate = myTime.getDate();

		return iYear+'-'+iMonth+'-'+iDate;

	}

	

 