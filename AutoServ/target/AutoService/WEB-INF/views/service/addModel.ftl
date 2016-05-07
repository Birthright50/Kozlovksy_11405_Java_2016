<#include "../main_template.ftl"/>
<@main_template title="Добавление"/>
<#macro m_body>
<div class="narrow">


    <div id="right">
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Добавить модель</li>
        </ul>
        <div class="both"></div>
        <h1>Добавить модель</h1>
        <#if RequestParameters.error??>
            <p><span class="errortext">Уже существует.<br></span></p>
        </#if>
        <#if RequestParameters.success??>
            <p style="color: green"><span>Добавлено<br></span></p>
        </#if>
        <div id="pop-form" class="static">
            <div class="container_form">
                <div style="margin-top: 16px;">

                    <form name="form_auth" method="post" target="_top" action="/services/addModel">

                        <div class="form-group">
                            <span class="input-text">Бренд&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                            <select class="form-control" name="brand">
                                <#list brands as brand>
                                    <option value="${brand.getId()}">${brand.getName()}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <span class="input-text">Модель&nbsp&nbsp&nbsp</span>
                            <input class="text" autocomplete="on" type="text" maxlength="255" value="" name="model">
                        </div>

                        <br><br>
                        <p></p>
                        <input align="center" type="submit" name="Login" value="Добавить" class="button_red_big"
                               style="left: 110px; top: -31px">

                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</#macro>