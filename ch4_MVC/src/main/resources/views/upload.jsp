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
    <title>Converter demo</title>
</head>
<body>
    <pre>
        Welcome to spring mvc world!
    </pre>

    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>

    <script src="http://lib.sinaapp.com/js/jquery/2.0/jquery.min.js"></script>
    <script>
        function req() {
            $.ajax( {
                    url: "convert",
                    data: "1-wangyufei",
                    type: "POST",
                    contentType:"application/x-wisely",
                    success: function(data){
                        $("#resp").html(data);
                    }
                }
            );
        }
    </script>

</body>
</html>
