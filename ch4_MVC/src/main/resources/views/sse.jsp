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
    <title>sse page</title>
</head>
<body>
    <pre>
        Welcome to spring mvc world!
    </pre>

    <div id="msgFromPush"></div>
    <script src="http://lib.sinaapp.com/js/jquery/2.0/jquery.min.js"></script>
    <script>
        if(!!window.EventSource){
            var source = new EventSource('push');
            s = '';
            source.addEventListener('message', function (evt) {
                s += evt.data + "<br/>";
                $("#msgFromPush").html(s);
            });

            source.addEventListener('open', function (evt) {
                console.log("open connection.");
            }, false);

            source.addEventListener('error', function (evt) {
                if (evt.readyState == EventSource.CLOSED) {
                    console.log("connection close");
                }else {
                    console.log(evt.readyState);
                }
            }, false);

        } else {
            console.log("你的浏览器不支持sse");
        }
    </script>


</body>
</html>
