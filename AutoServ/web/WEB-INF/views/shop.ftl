<#include "main_template.ftl"/>
<@main_template title="Запчасти"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <#list brands as brand>
                    <li>
                        <div><a>${brand.getName()}</a></div>
                        <ul class="left-menu-sub">
                            <#list brand.getAutoModels() as model>
                            <li>
                                <div><a href="/shop/${brand.getName()}/${model.getId()}">${model.getName()}</a></div>
                            </li>

                            </#list>
                        </ul>
                    </li>
                </#list>
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
                125047, г. Москва, ул. Пушкина, дом 21.
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
            <li>Запчасти</li>
        </ul>
        <div class="both"></div>
        <h1>Запчасти</h1>
        <div class="selling_block">
    <@security.authorize access="!hasRole('ROLE_ADMIN')">
	<span class="basket">
		<a href="/personal_cabinet/basket">Корзина</a><br>

	</span>
    </@security.authorize>
        </div>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
        <div class="wrap_table">
            <table class="content gray_table">
                <tbody>
                <tr class="even">
                    <th><a href="/services/addBrand" class="button_red_big">Добавить бренд</a></th>
                    <th><a href="/services/addModel" class="button_red_big">Добавить модель</a></th>
                    <th><a href="/services/addProduct" class="button_red_big">Добавить товар</a> </th>
                </tr>
                </tbody>
            </table>
        </div>
    </@security.authorize>

        <p>
            Добро пожаловать в интернет-магазин «Сайт Автосервиса»! Наша компания предоставляет полный спектр товаров и
            услуг
            для автовладельцев, и чтобы стать для Вас еще доступнее, мы открыли интернет-магазин.
        </p>


        <br>


    </div>
</div>

</#macro>