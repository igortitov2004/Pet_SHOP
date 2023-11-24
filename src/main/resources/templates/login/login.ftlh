<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/login.css">
    <link rel="stylesheet" type="text/css" href="/style/buttonRegister.css">
    <link rel="stylesheet" type="text/css" href="/style/formUser.css">
</head>
<body>
<h1 style="text-align: center; color: green">ЗООМАГАЗИН</h1>

<form action="/login" method="post">
    <h2>Авторизация</h2>
    <input type="text" required name="username" placeholder="Логин"><br><br>
    <input type="password" required name="password" placeholder="Пароль"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
    <a style="text-decoration: none;" href="/registration">Регистрация</a>
</form><br>
</body>
</html>
