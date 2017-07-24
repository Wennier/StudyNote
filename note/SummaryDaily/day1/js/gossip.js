



	var box = document.getElementsByClassName('gossip-list')[0];

	var text = document.getElementsByTagName('textarea')[0];
	var send = document.getElementsByClassName('send')[0];

	var list = document.getElementsByClassName('gossip-list-ul')[0]; 
 
	var data=null,
		getText = null;

	

	send.onclick = function(){
		getText = text.value;
		data = getData();
		var insertNode = document.createElement('li');
		var nodeContext = "<img src='img/dataicon.png'><div class='data'>"+ data +"</div><div class='text'>"+ getText +"</div>";
		
		insertNode.innerHTML = nodeContext;
		// changeBg();
	 	list.insertBefore(insertNode,list.children[0]);

	}

	function getData(){

		var myTime = new Date();
		var iYear = myTime.getFullYear();
		var iMonth = myTime.getMonth()+1;
		var iDate = myTime.getDate();

		return iYear+'-'+iMonth+'-'+iDate;

	}

	// function changeBg(){

	// 	for(var i = 0.03 ;i < 100 ; i++){
	// 		list.style.backgroundColor = "rgba(0,0,0,"+ i +")";
	// 		i += 0.02;
	// 	}
	// }
 