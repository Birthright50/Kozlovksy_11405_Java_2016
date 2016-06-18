<#include "../main_template.ftl"/>
<@main_template title="Заказ"/>
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
            <li>Заказ # ${order.getId()}</li>
        </ul>
        <div class="both"></div>
        <h1>Заказ # ${order.getId()}</h1>
        <div id="warning_message">
        </div>

        <div id="basket_form_container">
            <div class="bx_ordercart">
                <div id="basket_items_list">
                    <div class="bx_ordercart_order_table_container">
                        <table id="basket_items">
                            <thead>
                            <tr>
                                <td class="margin"></td>
                                <td class="item" colspan="2" id="col_NAME">
                                    Наименование
                                </td>
                                <td class="price" id="col_PRICE">
                                    Цена
                                </td>
                                <td class="custom" id="col_QUANTITY">
                                    Кол-во
                                </td>
                                <td class="custom" id="col_SUM">
                                    Сумма
                                </td>
                                <td class="custom"></td>
                                <td class="margin"></td>
                            </tr>
                            </thead>
                            <tbody>
                                    <#list order.getOrdersProductsList() as product>
                                    <tr id="18701">
                                        <td class="margin"></td>
                                        <td class="itemphoto">
                                            <div class="bx_ordercart_photo_container">

                                                <a href="/shop/shiny-13-quot/12728/">
                                                    <div class="bx_ordercart_photo"
                                                         style="background-image:url('/resources/images/no-auto.png')"></div>
                                                </a></div>
                                        </td>
                                        <td class="item">
                                            <h2 class="bx_ordercart_itemtitle">
                                                <a>${product.getProducts().getName()}</a></h2>
                                            <div class="bx_ordercart_itemart">
                                            </div>
                                        </td>
                                        <td class="price">
                                            <div class="current_price"
                                                 id="current_price_18701">${product.getProducts().getPrice()}</div>
                                        </td>

                                            <td class="custom">
                                                <span>:</span>
                                                <div class="centered">
                                                    <table cellspacing="0" cellpadding="0" class="counter">
                                                        <tbody>
                                                        <tr>
                                                            <td>

                                                                <p   style="max-width: 50px"

                                                                >${product.getCount()}</p>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </td>

                                        <td class="custom">
                                            <span>:</span>
                                            <div id="sum_18701">${product.getCount()*product.getProducts().getPrice()}</div>
                                        </td>

                                        <td class="margin"></td>
                                    </tr>
                                    </#list>

                            </tbody>
                        </table>
                    </div>


                        <div class="bx_ordercart_order_pay">

                            <div class="bx_ordercart_order_pay_left" id="coupons_block">
                                <div class="bx_ordercart_coupon">

                                    <span>Адрес: ${order.getAddress()}</span>
                                </div>
                            </div>
                            <div class="bx_ordercart_order_pay_right">
                                <table class="bx_ordercart_order_sum">
                                    <tbody>

                                    <tr>
                                        <td class="fwb">Итого:</td>
                                        <td class="fwb" id="allSum_FORMATED">
                                                    ${order.getSum()}
                                                </td>
                                    </tr>


                                    </tbody>
                                </table>
                                <div style="clear:both;"></div>
                            </div>


                        </div>

                </div>
            </div>
        </div>
    </div>
</div>
</#macro>