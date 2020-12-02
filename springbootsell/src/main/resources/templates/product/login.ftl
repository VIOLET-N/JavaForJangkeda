<html>
<head>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>
        body{
            background: #5669D6;
            /*background-size: 100%;*/
        }
        .div{
            width: 500px;
            height: 320px;
            background: rgba(0,0,0,0.5);
            margin: 0 auto;
            margin-top: 100px;
            border-radius: 50px;
        }
        .form-horizontal{
            padding-top: 20%;
            padding-left: 10%;
        }
        .form-control{
            width: 300px;
        }
        .btn{
            width: 300px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="div">
        <form role="form" class="form-horizontal" action="/login/user/" method="post">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="productUserPhone" id="inputEmail" placeholder="请输入账号...">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="productUserPwd" id="inputPassword" placeholder="请输入密码...">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>