<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="../common/common.jsp"%>
<head>
  	<meta charset="utf-8">
  	<title>picture</title>
	<style>
		/* 进度条颜色 */
		.bar {
		    height: 18px;
		    background: green;
		}
	</style>
	<script type="text/javascript"	src="${basePath}/jquery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${basePath}/plugin/jQuery-File-Upload-9.19.0/js/vendor/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${basePath}/plugin/jQuery-File-Upload-9.19.0/js/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="${basePath}/plugin/jQuery-File-Upload-9.19.0/js/jquery.fileupload.js"></script>
</head>

<body>
	<input id="fileupload" type="file" name="files[]" data-url="${basePath}/picture/savePicture/" multiple>
	<div id="progress">
	    <div class="bar" style="width: 0%;"></div>
	</div>	
  
</body>
<script>
/* $(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        done: function (e, data) {
            $.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo(document.body);
            });
        }
    });
}); */
$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
        add: function (e, data) {
            data.context = $('<button/>').text('Upload')
                .appendTo(document.body)
                .click(function () {
                    $(this).replaceWith($('<p/>').text('Uploading...'));
                    data.submit();
                });
        },
        done: function (e, data) {
        	$.each(data.result.files, function (index, file) {
                $('<p/>').text(file.name).appendTo(document.body);
            });
        }
    });
});


/* 上传进度条 */
$('#fileupload').fileupload({
    /* ... */
    progressall: function (e, data) {
        var progress = parseInt(data.loaded / data.total * 100, 10);
        $('#progress .bar').css(
            'width',
            progress + '%'
        );
    }
});
</script>
</html>
