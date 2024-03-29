<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>登录</title>

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

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">H+</h1>
        </div>
        <h3>欢迎使用 H+</h3>
        <form id="loginForm" class="m-t" role="form" action="${base}/user/login" method="get">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="username" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

            <p class="text-muted text-center"><a href="#">
                <small>忘记密码了？</small>
            </a> | <a href="${base}/index?flag=register">注册一个新账号</a>
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
                    window.location.href = "${base}/main";
                }
            },
            resetForm: true,
            timeout: 3000
        }
        $("#loginForm").submit(function () {
            $(this).ajaxSubmit(options);
            return false;
        })
    })
</script>
</body>
</html>
