<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/animals" style="text-decoration: none">Назад</a></div></h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Добавление породы</h3>
<hr>
<form action="/breed/create" method="post" enctype="multipart/form-data">
    <label for="a" style="margin-left: 10px">Порода:</label>
    <input type="text" style="margin-left: 5px" value="${newBreed.breed}" required name="breed" minlength="3" maxlength="30"/><br>
    <#if breedErr??>
        <div style="color: red; margin-left: 10px" >
            <@spring.bind "newBreed.breed"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Добавить"/></div>
</form>
<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>