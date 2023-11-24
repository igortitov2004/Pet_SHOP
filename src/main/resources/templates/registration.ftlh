<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring/>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/login.css">
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/formUser.css">

</head>
<body>

    <div class="ref"><a href="/login" style="text-decoration: none">Назад</a></div>

<form action="/registration" method="post">
    <h2>Регистрация</h2>
    <input type="text" required name="telNumber" value="${user.telNumber}" placeholder="Номер телефона" maxlength="13" minlength="13"><br>
    <#if errorReg??>
    <div style="color: red">
            <@spring.bind "user.telNumber"/>
            <@spring.showErrors ""/>
    </div>
    </#if><br>
    <input type="text" required name="login" value="${user.login}" placeholder="Логин"><br>
    <#if errorReg??>
    <div style="color: red">
        <@spring.bind "user.login"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    <input type="password" required name="password" placeholder="Пароль"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>
<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>