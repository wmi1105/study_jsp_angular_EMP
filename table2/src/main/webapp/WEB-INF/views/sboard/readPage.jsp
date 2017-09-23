<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/index.jsp"%>
<!-- getFileInfo() js파일  -->
<script type="text/javascript" src="/resources/js/upload.js"></script>
<!-- 첨부파일 템플릿 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Main content -->
<style type="text/css">
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
  	
    </style>
 <!-- 이미지 클릭하면 큰 크기로  -->
				<div class='popup back' style="display:none;"></div>
				    <div id="popup_front" class='popup front' style="display:none;">
				     <img id="popup_img">
				    </div>
				<section class="content">
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- general form elements -->
							<div class="box box-primary">
								<div class="box-header">
									<h3 class="box-title">READ BOARD</h3>
								</div>
								<!-- /.box-header -->
				
				<form role="form" action="modifyPage" method="post">
				
					<input type='hidden' name='bno' value="${boardVO.bno}"> <input
						type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${boardVO.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->
                     <ul class="mailbox-attachments clearfix uploadedList"></ul>
				<div class="box-footer">
			   <button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			   <button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			   <button type="submit" class="btn btn-primary" id="goListBtn">GO LIST </button>
			 </div>







			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</span>
  </div>
</li>                
</script>



<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyBtn").on("click", function(){
		formObj.attr("action", "/sboard/modifyPage");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
/* 	$("#removeBtn").on("click", function(){
		formObj.attr("action", "/sboard/removePage");
		formObj.submit();
	}); */

	
	$("#removeBtn").on("click", function(){
		
		
		
		var arr = [];
		$(".uploadedList li").each(function(index){
			 arr.push($(this).attr("data-src"));
		});
		
		if(arr.length > 0){
			$.post("/deleteAllFiles",{files:arr}, function(){
				
			});
		}
		
		formObj.attr("action", "/sboard/removePage");
		formObj.submit();
	});	
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/sboard/list");
		formObj.submit();
	});
	//첨부파일에 대한 템플릿과  jackson-databind pom.xml에 추가하여야 적용
	var bno = ${boardVO.bno};
	var template = Handlebars.compile($("#templateAttach").html());
	
	$.getJSON("/sboard/getAttach/"+bno,function(list){
		$(list).each(function(){
			
			var fileInfo = getFileInfo(this);
			
			var html = template(fileInfo);
			
			 $(".uploadedList").append(html);
			
		});
	});
	
	//이미지 파일인경우

	$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
		
		var fileLink = $(this).attr("href");
		
		if(checkImageType(fileLink)){
			
			event.preventDefault();
					
			var imgTag = $("#popup_img");
			imgTag.attr("src", fileLink);
			
			console.log(imgTag.attr("src"));
					
			$(".popup").show('slow');
			imgTag.addClass("show");		
		}	
	});
	
	$("#popup_img").on("click", function(){
		
		$(".popup").hide('slow');
		
	});	
	
		
	
});
</script>

<%@include file="../include/footer.jsp"%>
