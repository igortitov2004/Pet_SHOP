<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring/>
<head>
    <title>SHOP</title>
</head>
<body>

<h4>Регистрация</h4>
<form action="/registration" method="post">
    Телефон: <input type="text" required name="telNumber"><br>
    <#if errorReg??>
    <div style="color: red">
        <@spring.bind "user.telNumber"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    Логин: <input type="text" required name="login"><br>
    <#if errorReg??>
    <div style="color: red">
        <@spring.bind "user.login"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    Пароль: <input type="password" required name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"/>
</form>
<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>