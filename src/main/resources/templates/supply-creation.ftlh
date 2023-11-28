<!DOCTYPE html>
<html>
<head>
    <title>Создание поставки</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <div class="ref"><a href="/supplies">Назад</a></div>
    <br>
</head>
<body>
<#if supply.supplied_feedsModelList??>
    <table >
    <#list supply.supplied_feedsModelList as suppliedFeed>
        <tr>
            <th><a style="text-decoration: none" href="/feeds/${suppliedFeed.feed.id_feeds}"> ${suppliedFeed.feed.nameOfFeed}</a></th>
            <th> - Количество(${suppliedFeed.amount}), </th>
            <th><a style="text-decoration: none" href="/supplies/deletePosFeed/${suppliedFeed_index}"> Удалить </a></th>
        </tr>
    </#list>
    </table>
</#if>
<#if supply.supplied_accessoriesModelList??>
    <table >
    <#list supply.supplied_accessoriesModelList as suppliedAccessor>
        <tr>
            <th><a style="text-decoration: none" href="/accessories/${suppliedAccessor.accessor.id_accessories}"> ${suppliedAccessor.accessor.nameOfAccessor}</a></th>
            <th> - Количество(${suppliedAccessor.amount}), </th>
            <th><a style="text-decoration: none" href="/supplies/deletePosAccessor/${suppliedAccessor_index}"> Удалить </a></th>
        </tr>
    </#list>
    </table>
</#if>
<hr>
<#if feed?has_content>
    <form action="/supplies/addFeed" method="post" enctype="multipart/form-data">
        <label style="margin-left: 10px">Корм: </label>
        <select name="id_feeds" required>
            <option value="">Выберите корм</option>
            <#list feed as feed>
                <option value="${feed.id_feeds}">
                    ${feed.nameOfFeed}
                    <#if feed.animal??>
                        - ${feed.animal.kindOfAnimal}
                        (${feed.animal.breed.breed})
                    <#else> - Животное удалено!
                    </#if>
                    , Производитель - ${feed.manufacturerOfFeed}
                    , Вес - ${feed.weightOfFeed} кг
                    , Cтоимость - ${feed.priceOfFeed} BYN
                </option>
            </#list>
        </select><br><br>
        <label style="margin-left: 10px">Количество: </label>
        <input type="number" required min="1"  max="500" name="amount"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="action"><input type="submit" value="Добавить"/></div>
    </form>
    <#else> Доступных кормов для поставки нет!
</#if>
<hr>
<#if accessor?has_content>
    <form action="/supplies/addAccessor" method="post" enctype="multipart/form-data">
        <label style="margin-left: 10px">Аксессуар: </label>
        <select name="id_accessories" required>
            <option value="">Выберите аксессуар</option>
            <#list accessor as accessor>
                <option value="${accessor.id_accessories}">
                    ${accessor.nameOfAccessor}
                    <#if accessor.animal??>
                        - ${accessor.animal.kindOfAnimal}
                        (${accessor.animal.breed.breed})
                    <#else> - Животное удалено!
                    </#if>
                    , Производитель - ${accessor.manufacturerOfAccessor}
                    , Cтоимость - ${accessor.priceOfAccessor} BYN
                </option>
            </#list>
        </select><br><br>
        <label style="margin-left: 10px">Количество: </label>
        <input type="number"required min="1" step="1" max="200" name="amount"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="action"><input type="submit" value="Добавить"/></div>
    </form>
    <#else> Доступных аксессуаров для поставки нет!
</#if>
<hr>
<#if supply.supplied_feedsModelList?has_content || supply.supplied_accessoriesModelList?has_content>
<form action="/supplies/save" method="post" enctype="multipart/form-data">
    <input type="hidden" required name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Оформить"/></div>
</form>
</#if>
</body>
</html>