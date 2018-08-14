<%--
  Created by IntelliJ IDEA.
  User: ZhangXu
  Date: 2018/8/13
  Time: 下午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>upload page</title>
</head>
<body>
    <pre>
        Welcome to spring mvc world!
    </pre>

    <div class="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file"/><br/>
            <input type="submit" value="上传">
        </form>
    </div>

</body>
</html>
