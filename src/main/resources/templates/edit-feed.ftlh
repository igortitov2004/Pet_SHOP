<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/feeds" style="text-decoration: none">Назад</a></div> </h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Изменение стоимости</h3><hr>
<div style="margin-left: 10px">
    Название - ${feeds.nameOfFeed}<br>
    Животное - <#if feeds.animal??>
        ${feeds.animal.kindOfAnimal}(${feeds.animal.breed.breed})
        <#else> Животное удалено!
    </#if> <br>
    Стоимость - ${feeds.priceOfFeed} BYN<br>
    Вес - ${feeds.weightOfFeed} кг<br>
    Производитель - ${feeds.manufacturerOfFeed}
</div><hr>
<form action="/feeds/${feeds.id_feeds}/edit" method="post" enctype="multipart/form-data" >
    <label for="a" style="margin-left: 10px">Изменение стоимости:</label>
    <input style="margin-left: 5px" id="a" type="number" step="0.01" min="0.01" max="300" value="${feeds.priceOfFeed}" required name="priceOfFeed"/><br>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Применить"/></div>
</form>
</body>
</html>