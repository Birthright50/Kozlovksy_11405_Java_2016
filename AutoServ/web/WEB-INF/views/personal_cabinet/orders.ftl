<#include "../main_template.ftl"/>
<@main_template title="Мои заказы"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/personal_cabinet/my-auto">Обслуживание</a></div>
                <li>
                    <div><a href="/personal_cabinet/basket">Моя корзина</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/orders">Мои заказы</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/configuration">Мои настройки</a></div>
                </li>
            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->
        <!--Специиальные предложения -->

        <!--Новости -->

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
            <li><a href="/personal_cabinet" title="Личный кабинет">Личный кабинет</a></li>

            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Мои заказы</li>
        </ul>
        <div class="both"></div>
        <h1>Мои заказы</h1>
        <div id="55" hidden><@security.authentication property="principal.userInfo.id"/></div>
        <div id="123" class="order_list current-status">
            <div class="wrap_table">
                <table class="gray_table">
                    <tbody>
                    <tr class="even">
                        <th class="number">№ заказа
                        </th>
                        <th class="date">Дата
                        </th>
                        <th class="status">Статус
                        </th>
                        <th class="sum">Сумма</th>
                        <th class="action"></th>
                    </tr>
                        <#list orders as order>
                        <tr class="even">
                            <td align="center"><a href="/personal_cabinet/orders/${order.getId()}">${order.getId()}</a>
                            </td>
                            <td>${order.getfDate()}</td>
                            <td>${order.getStatus()}</td>
                            <td align="right">${order.getSum()}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <button onclick="sort()">ssss</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    function sort() {
        $.ajax({
            type: "GET",
            headers: {
                'Cache-Control': 'max-age=1000'
            },
            url: "/personal_cabinet/orders/sort"
        }).done(function (data) {
            if (data != '') {
                $("#123").append(data);

            } 
        }).fail(function () {
          alert("error");
        });

    }

</script>
</#macro>
