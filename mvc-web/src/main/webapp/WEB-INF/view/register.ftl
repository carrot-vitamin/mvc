<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>注册</title>

    <link href="${base}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${base}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${base}/css/animate.min.css" rel="stylesheet">
    <link href="${base}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script src="${base}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${base}/js/jquery.form.js"></script>
    <script src="${base}/js/bootstrap.min.js?v=3.3.6"></script>
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">H+</h1>
        </div>
        <h3>欢迎注册 H+</h3>
        <p>创建一个H+新账户</p>
        <form id="userForm" class="m-t" role="form" action="${base}/user/register" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="username" required>
            </div>
            <div class="form-group">
                <input type="email" class="form-control" placeholder="邮箱" name="email" required>
            </div>
            <div class="form-group">
                <input type="tel" class="form-control" placeholder="联系方式" name="telephone" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password" required>
            </div>
        <#--<div class="form-group">
            <input type="password" class="form-control" placeholder="确认密码" required >
        </div>-->
            <div class="form-group">
                <input type="file" name="file">
            </div>
            <div class="form-group">
                <textarea class="form-control" rows="3" name="remark" placeholder="说点什么吧... ..."></textarea>
            </div>

            <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

            <p class="text-muted text-center">
                <small>已经有账户了？</small>
                <a href="${base}/index">点此登录</a>
            </p>

        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        var options = {
            success: function (responseText, statusText, xhr) {
                if (responseText.responseCode != "200") {
                    alert(responseText.responseMessage);
                } else {
                    alert('注册成功');
                    window.location.href = "${base}/index";
                }
            },
            resetForm: true,
            timeout: 3000
        }
        $("#userForm").submit(function () {
            $(this).ajaxSubmit(options);
            return false;
        })
    })
</script>
</body>
</html>
