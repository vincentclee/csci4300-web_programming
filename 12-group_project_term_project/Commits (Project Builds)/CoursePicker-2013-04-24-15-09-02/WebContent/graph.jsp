<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weekly Class Schedule</title>

<script type="text/javascript">
function myCanvas() {
        
	var daysOfWeek = new Array("", "Mon", "Tue", "Wed", "Thurs", "Fri");
	var hoursOfDay = new Array("8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00");
	
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
        
	/**
	*  Draw a single class meeting on the canvas - or draw all meetings??
        *  
        *  will always be .rect(x,y,156,45), where (x,y) is the top left corner of rectangle
	*/
	function drawClassMeeting() {
		ctx.rect(60.5, 60, 156, 45);//0.5 + x + p, p, w, h) //(x,y of top left corner, width, height)
                ctx.fillStyle = 'yellow';
                ctx.fill();
	}
	
	/**
	*  Initialize the canvas with grid lines and labels
	*/
	function initializeCanvas() {
		
		var bw = 780; //bow width
		var bh = 540;  //box height
		var p = 60;  //padding
		

		for (var x = 0, y = 0; x <= bw; x += 156, y++) {
		    ctx.moveTo(0.5 + x + p, p);
		    ctx.lineTo(0.5 + x + p, bh + p);
		    ctx.fillText(daysOfWeek[y], x + p - 96, p - 15);
		}

		for (var x = 0, y = 0; x <= bh; x += 45, y++) {
		    ctx.moveTo(p, 0.5 + x + p);
		    ctx.lineTo(bw + p, 0.5 + x + p);
                    ctx.fillText(hoursOfDay[y], p - 30, x + p + 5);
		}
                   
                
                
		ctx.strokeStyle = "black";
		ctx.stroke();
                
                
                
                
	}
}
        
</script>
</head>

<body onload = "initializeCanvas();">

<canvas id="myCanvas" width="900" height="660" style="border:1px solid #000000;">

</canvas>

</body>
</html>