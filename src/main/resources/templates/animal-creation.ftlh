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
<h3>Добавление животного</h3>
<hr>
<form action="/animals/create" method="post" enctype="multipart/form-data">
    Название:<input type="text" value="${newAnimal.kindOfAnimal}" required name="kindOfAnimal" minlength="3" maxlength="30"/><br>
    <#if animalErr??>
        <div style="color: red">
            <@spring.bind "newAnimal.kindOfAnimal"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    Порода:  <select name="breed" required>
<#--        <option disabled SELECTED><option>-->
            <#list breeds as breed>
        <option value="${breed.id_breeds}"> ${breed.breed}</option>
        </#list>
    </select><br><br>
    Вес:     <input type="number" step="0.01" value="${newAnimal.weight_of_animal}" required name="weight_of_animal" min="0.01" max="50"
                    onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/><br>
    <br>
    Возраст: <input type="number" value="${newAnimal.ageOfAnimal}" id="age" required name="ageOfAnimal" min="0" max="30" step="1"
                    onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/><br>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить животное"/>
</form>

<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>