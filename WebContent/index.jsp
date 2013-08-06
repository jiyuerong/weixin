<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Uploadify 上传文件示例</title>
<script src="${ctx}/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery.uploadify.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/uploadify.css">
<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>
</head>

<body>
	<h1>多文件列表手动上传示例</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload1" name="file_upload" type="file" multiple="true"/>
	</form>
	<input type="button" value="获取上传文件信息" onclick="getFileInfo(1)"/>
	
	<h1>多文件列表自动上传示例</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload2" name="file_upload2" type="file" multiple="true"/>
	</form>
	
	<input type="button" value="获取上传文件信息" onclick="getFileInfo(2)"/>
	
	<h1>单文件输入框上传示例</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload3" name="file_upload3" type="file" multiple="true"/>
	</form>
	
	<input type="button" value="获取上传文件信息" onclick="getFileInfo(3)"/>
	
	
	<h1>多文件输入框上传示例</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload4" name="file_upload4" type="file" multiple="true"/>
	</form>
	
	<input type="button" value="获取上传文件信息" onclick="getFileInfo(4)"/>
	
	

	<script type="text/javascript">
	
	    function getFileInfo(i){
	    	$("#file_upload" + i).each(function(){
	    		var swfuploadify = $(this).data('uploadify');
		    	$.each(swfuploadify.queueData.files, function(index, file){
		    		alert(file.name + ", " + file.accessUrl);
		    	});
	    	});
			
	    }
	
		$(function(){
			$('#file_upload1').uploadify({
				'auto': false,
				'removeCompleted': false,
				'selectButtonText': '添加文件',
				'uploadButtonText': '上传文件',
				'stopButtonText': '停止上传',
				'cancelButtonText': '删除所有',
				'requireUploadButton': true,
				'requireStopButton': true,
				'requireCancelButton': true,
				'fileObjName': 'file',
				'swf'      : '${ctx}/js/uploadify.swf',
				'uploader' : '${ctx}/upload/file.do'
			});
			$('#file_upload2').uploadify({
				'auto': true,
				'removeCompleted': false,
				'selectButtonText': '上传文件',
				'fileObjName': 'file',
				'swf'      : '${ctx}/js/uploadify.swf',
				'uploader' : '${ctx}/upload/file.do'
			});
			$('#file_upload3').uploadify({
				'auto': true,
				'isInput': true,
				'isInputSingle': true,
				'removeCompleted': true,
				'selectButtonText': '上传文件',
				'fileObjName': 'file',
				'swf'      : '${ctx}/js/uploadify.swf',
				'uploader' : '${ctx}/upload/file.do'
			});
			$('#file_upload4').uploadify({
				'auto': true,
				'isInput': true,
				'removeCompleted': false,
				'selectButtonText': '上传文件',
				'fileObjName': 'file',
				'swf'      : '${ctx}/js/uploadify.swf',
				'uploader' : '${ctx}/upload/file.do'
			});
		});
	</script>
</body>
</html>