<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
<#--    <script>-->
<#--        function validNum(){-->
<#--            if(document.getElementById("age").value.toString().lastIndexOf('e')===document.getElementById("age").value.toString().length-1){-->
<#--                document.getElementById("age").value="";-->
<#--            }-->
<#--        }-->
<#--    </script>-->
</head>
<body>
<form action="/animals" method="get">
    <input type="submit" value="Назад"/>
</form>
<h3>Добавление породы</h3>
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
    Порода:  <select name="breed_id" required>
<#--        <option disabled SELECTED><option>-->
            <#list breeds as breed>
        <option value="${breed.id_breeds}"> ${breed.breed}</option>
        </#list>
    </select><br><br>
    Вес:     <input type="number" step="0.01" value="${newAnimal.weight_of_animal}" required name="weight_of_animal" min="0.01" max="50"
                    onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/><br>
    <#if animalErr??>
        <div style="color: red">
            <@spring.bind "newAnimal.weight_of_animal"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    Возраст: <input type="number" value="${newAnimal.age_of_animal}" id="age" required name="age_of_animal" min="0" max="30" step="1"
                    onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/><br>
    <#if animalErr??>
        <div style="color: red">
            <@spring.bind "newAnimal.age_of_animal"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить животное"/>
</form>

<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>