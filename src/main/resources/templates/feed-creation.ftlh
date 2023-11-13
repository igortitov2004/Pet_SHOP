<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
</head>
<body>
<form action="/feeds" method="get">
    <input type="submit" value="Назад"/>
</form>
<h3>Добавление корма</h3>
<hr>
<form action="/feeds/create" method="post" enctype="multipart/form-data">
    Название:<input type="text" value="${newFeed.nameOfFeed}" required name="nameOfFeed"/><br>
    <#if feedErr??>
    <div style="color: red">
        <@spring.bind "newFeed.nameOfFeed"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    Животное:<select name="animal" required>
        <#--        <option disabled SELECTED>Выберите</option>-->
        <#list animals as animal>
            <option value="${animal.id_animals}"> ${animal.kindOfAnimal}: ${animal.breed.breed}</option>
        </#list>
    </select><br><br>
    Стоимость:<input type="number"  step="0.01" min="0.01" max="1000" required name="priceOfFeed" /><br>
    <br>
    Вес:<input type="number" step="0.01" min="0.01" maxlength="50" required name="weightOfFeed"/><br>
    <br>
    Производитель:<input type="text" required name="manufacturerOfFeed" minlength="3" maxlength="50"/><br>
    <#if feedErr??>
    <div style="color: red">
        <@spring.bind "newFeed.manufacturerOfFeed"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    <input type="hidden" value="0" name="amountOfFeeds"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить корм"/>
</form>
</body>
</html>