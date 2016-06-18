<#include "../main_template.ftl"/>
<@main_template title="Личный кабинет"/>
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
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/personal_cabinet" title="Личный кабинет">Личный кабинет</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Мои настройки</li>
        </ul>
        <div class="both"></div>
        <h1>Мои настройки</h1>
        <div id="order_form_div" class="order-checkout">
            <noscript>
                &lt;div class="errortext"&gt;Для оформления заказа необходимо включить JavaScript. По-видимому,
                JavaScript либо не поддерживается браузером, либо отключен. Измените настройки браузера и затем &lt;a
                href=""&gt;повторите попытку&lt;/a&gt;.&lt;/div&gt;
            </noscript>


            <div class="bx_order_make">
                <form action="/personal_cabinet/checkout" method="POST" name="ORDER_FORM" id="ORDER_FORM"
                      enctype="multipart/form-data">
                    <div id="order_form_content">

                        <div class="bx_section">
                            <h2>
                                Информация для оплаты и доставки заказа </h2>
                            <div id="sale_order_props" class="sale_order_props">
                                <div>
                                    <h3>Личные данные</h3>

                                    <div data-property-id-row="21">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Ф.И.O:
                                        </div>
                                        <input hidden type="text" name="id"
                                               value="<@security.authentication property="principal.userInfo.id"/>"/>
                                        <div class="bx_block r3x1">

                                            <input disabled type="text" maxlength="250" size="40"
                                                   value="<@security.authentication property="principal.userInfo.lastname"/> <@security.authentication property="principal.userInfo.name"/> <@security.authentication property="principal.userInfo.secondName"/>"
                                                   name="ORDER_PROP_21" id="ORDER_PROP_21">

                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>
                                    <div data-property-id-row="22">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            E-Mail:
                                        </div>

                                        <div class="bx_block r3x1">
                                            <input disabled type="text" maxlength="250" size="40"
                                                   value="<@security.authentication property="principal.userInfo.email"/>"
                                                   name="ORDER_PROP_22" id="ORDER_PROP_22">

                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>
                                    <div data-property-id-row="23">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Телефон:
                                        </div>
                                        <div class="bx_block r3x1">
                                            <input disabled type="text" maxlength="250" size=""
                                                   value="<@security.authentication property="principal.userInfo.telephone"/>"
                                                   name="telephone"
                                                   id="telephone">
                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>
                                    <h3>Данные для доставки</h3>
                                    <div data-property-id-row="24">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Индекс:
                                        </div>

                                        <div class="bx_block r3x1">
                                            <input type="text" maxlength="250" size="8" value="" name="index"
                                                   id="index">

                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>
                                    <div data-property-id-row="24">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Страна:
                                        </div>

                                        <div class="bx_block r3x1">
                                            <input type="text" maxlength="250" size="8" value="" name="country"
                                                   id="country">

                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>

                                    <div data-property-id-row="26">

                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Город:
                                        </div>

                                        <div class="bx_block r3x1">
                                            <input type="text" maxlength="250" size="3" value="" name="city"
                                                   id="city">

                                        </div>
                                        <div style="clear: both;"></div>
                                        <br>
                                    </div>


                                    <div data-property-id-row="27">

                                        <br>
                                        <div class="bx_block r1x3 pt8">
                                            <span class="bx_sof_req">*</span>
                                            Адрес доставки:
                                        </div>

                                        <div class="bx_block r3x1">
                                            <textarea rows="3" cols="30" name="address"
                                                      id="address"></textarea>

                                        </div>
                                        <div style="clear: both;"></div>
                                    </div>


                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="bx_ordercart">
                        <div>
                            <table class="content">
                                <thead>
                                </thead>
                                <tbody>
                                <tr>
                                    <td align="right" class="itog">
                                        Итого:
                                    </td>
                                    <td align="right" colspan="6">
                                        <#if sum??>
                                        ${sum}
                                    </#if></td>

                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="bx_ordercart_order_pay_center">
                        <input onclick="return check()" type="submit" value="Оформить заказ" class="button_red_big"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function check() {
        var telephone = $('#telephone');
        var index = $('#index');
        var country = $('#country');
        var city = $('#city');
        var address = $('#address');
        if (telephone.val().length == 0 || index.val().length == 0 || country.val().length == 0 || city.val().length == 0 || address.val().length == 0) {
            alert("Введите все данные");
            return false;
        }
        return true;
    }
</script>
</#macro>