<%
String path = request.getContextPath();//
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
pageContext.setAttribute("basePath",basePath);

String serverPath = request.getScheme()+"://"+request.getServerName()+":8000";
pageContext.setAttribute("serverPath",serverPath);
%>

