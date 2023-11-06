<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/login.css">
</head>
<body>
<h1 style="text-align: center; color: green">ЗООМАГАЗИН</h1>
<div>

<h2>Авторизация</h2>
<form action="/login" method="post">
    <input type="text" required name="username" placeholder="Логин"><br><br>
    <input type="password"  required name="password" placeholder="Пароль"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form><br>

<a style="text-decoration: none;" href="/registration">Зарегистрироваться</a>
</div>
</body>
</html>
