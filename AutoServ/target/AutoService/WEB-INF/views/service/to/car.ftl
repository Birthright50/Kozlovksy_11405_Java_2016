<#include "../../main_template.ftl"/>
<@main_template title="${brand.getName()}"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/services/to">Плановое ТО</a></div>
                </li>
                <li>
                    <div><a href="/services/repair">Ремонт авто</a></div>
                </li>

            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->

        <!--Как добраться-->
        <p></p>
        <h3 class="up_case"><a>Как добраться</a></h3>
        <div class="banner address">
            <div class="head_banner"></div>
            <p>
                299002, г. Севастополь, ул. Живописная 17
            </p>
            <p>
                125047, г. Москва, ул. Пушкина, дом Колотушкина.
            </p>

            <div class="foot_banner"></div>
            <div class="compas"></div>
        </div>
        <p></p>
    </div><!--/Левая колонка-->
    <div id="right"><!--Правая колонка-->
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12"
                                          height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/services" title="Сервис">Сервис</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/services/to" title="Сервис">Плановое ТО</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>${brand.getName()}</li>
        </ul>
        <div class="both"></div>
        <h1>${brand.getName()}</h1>

        <div class="wrap_table">
            <table class="content gray_table">
                <tbody>
                <tr class="even">
                    <th>Модель</th>
                    <th>Цена (руб.)</th>
                    <@security.authorize access="hasRole('ROLE_ADMIN')">
                        <th>Редактировать</th>
                    </@security.authorize>
                </tr>
                    <#list models as model>
                    <tr class="even">
                        <td><strong>${model.getName()}</strong></a></td>
                        <@security.authorize access="!hasRole('ROLE_ADMIN')">
                            <#if model.getPrice()??>
                                <td>от  ${model.getPrice().getPrice()}</td>
                            <#else>
                                <td>-</td>
                            </#if>
                        </@security.authorize>
                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                            <form action="/services/to" method="post">
                                <#if model.getPrice()??>
                                    <td><input value="${model.getPrice().getPrice()}" type="number" name="price"></td>
                                    <input hidden name="id" type="text" value="${model.getPrice().getId()}">
                                     <td><input value="OK" type="submit" class="button_red_small"></td>
                                </#if>
                            </form>
                        </@security.authorize>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>



    </div>
</div>
</#macro>