<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weekly Class Schedule</title>



<script type="text/javascript">
	var daysOfWeek = new Array("", "Mon", "Tue", "Wed", "Thurs", "Fri");
	var hoursOfDay = new Array("8:00", "9:00", "10:00", "11:00", "12:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00");
	var prefix = new Array("${JSONprefix}");
	var number = new Array("${JSONnumber}");
	var title = new Array("${JSONtitle}");
	var instructor = new Array("${JSONinstructor}");
	var day = new Array("${JSONday}");
	var startTime = new Array("${JSONstartTime}");
	var endTime = new Array("${JSONendTime}");
	var building = new Array("${JSONbuilding}");
	var room = new Array("${JSONroom}");
	var posX = new Array("${JSONposX}");
	var posY = new Array("${JSONposY}");
	var height = new Array("${JSONheight}");

	/**
        *  @author Meghan Redwine
        *  @param varX
        *  @param varY
        *  @param varH
        *  
        *  Draws one class meeting 
        *  Will always be .rect(x,y,156,h), where (x,y) is the top left corner of rectangle
	*/
	function drawClassMeeting(varX, varY, varH){
                var c = document.getElementById("myCanvas");
                var ctx = c.getContext("2d");
		ctx.rect(varX, varY, 156, varH);//0.5 + x + p, 60+45, w-static, h) //(x,y of top left corner, width, height) //(60.5, 206, 156, 56.1)
                ctx.fillStyle = 'orange';
                ctx.fill();
	}
	
	/**
	*  Initialize the canvas with grid lines and labels
        *  @author Alex Tozzi
        *  @author Meghan Redwine
	*/
	function initializeCanvas() {
            
                var c = document.getElementById("myCanvas");
                var ctx = c.getContext("2d");
		
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
                
                
                
                for (var i=0; i<posX.length; i++)
                    {
                        //EXAMPLE
                        var temp = i*10; //Will change to pixX(i), pixY(i), pixH(i)
                        drawClassMeeting(parseInt(posX[i]), parseInt(posY[i]), parseInt(height[i]));
                        //drawClassMeeting(60.5+temp, 206+temp, 56);
                    }
                
                
	}
        
</script>

</head>

<body onload = "initializeCanvas();">

<canvas id="myCanvas" width="900" height="660" style="border:1px solid #000000;">

</canvas>



<script>

var txt = "Hello World!";
document.write("<p>" + txt.length + "</p>");

var txt="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
document.write("<p>" + txt.length + "</p>");



var myCars=new Array("Saab","Volvo","BMW");
document.write("<p>" + myCars[0] + "</p>");

var myCars1=new Array("${stringArray}");
document.write("<p>" + myCars1[0] + "</p>");

for (var i=0;i<myCars1.length;i++)
{
document.write(myCars1[i] + "<br>");
}


</script>


</body>
</html>