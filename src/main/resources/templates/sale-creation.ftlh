<!DOCTYPE html>
<html>
<head>
    <title>Cоздание продажи</title>
</head>
<body>

<#if sale.sold_feedsModelList??>
    <table border="1">
        <#list sale.sold_feedsModelList as soldFeed>
            <tr>
                <th><a href="/feeds/${soldFeed.feed.id_feeds}"> ${soldFeed.feed.nameOfFeed}</a></th>
                <th> Количество(${soldFeed.amount})</th>
                <th><a href="/sales/deletePosFeed/${soldFeed_index}"> Удалить </a></th>
            </tr>
        </#list>
    </table>
</#if>
<#if sale.sold_accessoriesModelList??>
    <table border="1">
        <#list sale.sold_accessoriesModelList as soldAccessor>
            <tr>
                <th><a href="/accessories/${soldAccessor.accessor.id_accessories}"> ${soldAccessor.accessor.nameOfAccessor}</a></th>
                <th>Количество(${soldAccessor.amount})</th>
                <th><a href="/sales/deletePosAccessor/${soldAccessor_index}"> Удалить </a></th>
            </tr>
        </#list>
    </table>
</#if>
<hr>
<#if feed?has_content>
    <form action="/sales/addFeed" method="post" enctype="multipart/form-data">
        Корм:<select name="id_feeds" required>
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
        Количество:<input type="number" required min="1"  step="1" max="500" name="amount"/><br>
        <#if errFeed??>
            <div style="color: red">
                Лимит покупки - ${amount}
            </div>
        </#if>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить"/>
    </form>
    <#else> Доступных для продажи кормов нет!
</#if>

<hr>
<#if accessor?has_content>
    <form action="/sales/addAccessor" method="post" enctype="multipart/form-data">
        Аксессуар:<select name="id_accessories" required>
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
        Количество:<input type="number" required min="1" step="1"  name="amount"/><br>
        <#if errAccessor??>
            <div style="color: red">
                Лимит покупки - ${amount}
            </div>
        </#if>
        <br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить"/>
    </form>
    <#else> Доступных для продажи аксессуаров нет!
</#if>

<hr>

<#if sale.sold_feedsModelList?has_content || sale.sold_accessoriesModelList?has_content>
    <form action="/sales/save" method="post" enctype="multipart/form-data">

        <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Продать"/>
    </form>
</#if>
</body>
</html>