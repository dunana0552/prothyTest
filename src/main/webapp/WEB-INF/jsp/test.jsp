/**
 * Created by dunana on 18/4/16.
 */
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    <title>$prothyTest$</title>
    </head>
    <body>

    <form action="prothyTest" method="post">

        <table>
            <tr>
                <td>请求时间   ：</td>
                <td><input type="text" id="requestTime" name="requestTime"></td>
            </tr>
            <tr>
                <td>随机请求时间：</td>
                <td><input type="text" id="randomTime" name="randomTime"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" onclick="location='/prothyTest'" value="登录">
                </td>
                <td>
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>

    </form>

    </body>
    </html>

