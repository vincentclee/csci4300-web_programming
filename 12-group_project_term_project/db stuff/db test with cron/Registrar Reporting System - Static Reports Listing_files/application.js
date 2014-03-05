


var Ajax;
if (Ajax && (Ajax != null)) {
	Ajax.Responders.register({
	  onCreate: function() {
        if($('spinner') && Ajax.activeRequestCount>0)
          Effect.Appear('spinner',{duration:0.5,queue:'end'});
	  },
	  onComplete: function() {
        if($('spinner') && Ajax.activeRequestCount==0)
          Effect.Fade('spinner',{duration:0.5,queue:'end'});
	  }
	});
}

function clearFileInput(fileInput){
	var fileInputHash = new Hash();
	fileInputHash.set('id',fileInput.readAttribute('id'));
	fileInputHash.set('type',fileInput.readAttribute('type'));
	fileInputHash.set('countervalue',fileInput.readAttribute('countervalue'));
	fileInputHash.set('name',fileInput.readAttribute('name'));
	fileInputHash.set('size',fileInput.readAttribute('size'));					
	fileInputHash.set('onchange',fileInput.readAttribute('onchange'));
	var templ = new Template('<input id="#{id}" type="#{type}" countervalue="#{countervalue}" name="#{name}" size="#{size}" onchange="#{onchange}"/>');
	return templ.evaluate(fileInputHash);				
}

function clearReplaceFileInput(fileInput){
	fileInput.replace(clearFileInput(fileInput));
}

function validateFileInput(fileInput){
	if(!validateFileName($F(fileInput))){
		clearReplaceFileInput(fileInput);
	}
}

function validateFileName(fileName){
	var strArr = fileName.split('.', fileName.length);
	var fileExt = strArr[strArr.length - 1];
	fileExt = fileExt.toUpperCase();
	var okContents = new Array('PDF','TXT','DOC','XLS','CSV','XLSX','DOCX');
	for(var i = 0; i < okContents.length; i++){
		if(fileExt == okContents[i]){
			return true;
		}
	}
	alert("File " + fileName + " with file type " + fileExt + " will not be uploaded successfully to the server.  Allowed file types are " + okContents.toString() + ".");
	return false;
}
