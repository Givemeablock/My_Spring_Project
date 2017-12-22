<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#assign title = "yyc_news" >
    <#--包含别的模板的语法-->
    <#include "m_title.ftl">
    <h1>This is a free-maker based page</h1>
    <div>i am value1: ${value1}</div>
    <ul>
      <#--这是循环取值的方法-->
      <#list colors as color>
          <li>${color}</li>
      </#list>
    </ul>
    <#--函数-->
    <#assign num = 1>
    <#macro stack color>
        <div style="width: 100px; height: 100px; background: ${color}">${color}:${num}</div>
        <#assign num = num + 1>
    </#macro>
    <#list colors as color>
        <@stack color=color/>
    </#list>

</body>
</html>