<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/animals" style="text-decoration: none">Назад</a></h3>
    <hr>
</head>
<body>
<h3>Добавление породы</h3>
<hr>
<form action="/breed/create" method="post" enctype="multipart/form-data">
    Порода:<input type="text"  value="${newBreed.breed}" required name="breed" minlength="3" maxlength="30"/><br>
    <#if breedErr??>
        <div style="color: red">
            <@spring.bind "newBreed.breed"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить"/>
</form>
<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>