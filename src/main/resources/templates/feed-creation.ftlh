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
    Животное:<select name="animal_id_for_feed" required>
        <#--        <option disabled SELECTED>Выберите</option>-->
        <#list animals as animal>
            <option value="${animal.id_animals}"> ${animal.kindOfAnimal}: ${animal.breed_id.breed}</option>
        </#list>
    </select><br><br>
    Стоимость:<input type="number"  step="0.01" min="0.01" max="1000" required name="price_of_feed" /><br>
    <#if feedErr??>
    <div style="color: red">
        <@spring.bind "newFeed.price_of_feed"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    Вес:<input type="number" step="0.01" min="0.01" maxlength="50" required name="weight_of_feed"/><br>
    <#if feedErr??>
    <div style="color: red">
        <@spring.bind "newFeed.weight_of_feed"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    Производитель:<input type="text" required name="manufacturer_of_feed" minlength="3" maxlength="50"/><br>
    <#if feedErr??>
    <div style="color: red">
        <@spring.bind "newFeed.manufacturer_of_feed"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if><br>
    <input type="hidden" value="0" name="amount_of_feeds"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить корм"/>
</form>
</body>
</html>