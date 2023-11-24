<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/feeds" style="text-decoration: none">Назад</a></h3>
    <hr>
</head>
<body>
<h3>Изменение стоимости</h3><hr>
<div>
    Название - ${feeds.nameOfFeed}<br>
    Животное - <#if feeds.animal??>
        ${feeds.animal.kindOfAnimal}(${feeds.animal.breed.breed})
        <#else> Животное удалено!
    </#if> <br>
    Стоимость - ${feeds.priceOfFeed}<br>
    Вес - ${feeds.weightOfFeed}<br>
    Производитель - ${feeds.manufacturerOfFeed}
</div><hr>
<form action="/feeds/${feeds.id_feeds}/edit" method="post" enctype="multipart/form-data">
    Изменение стоимости:<input type="number" step="0.01" min="0.01" max="300" value="${feeds.priceOfFeed}" required name="priceOfFeed"/><br>
    <#if editFeedErr??>
        <div style="color: red">
            ${editFeedErr}
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>