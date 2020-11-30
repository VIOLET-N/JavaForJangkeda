<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#--                        通过.content 获取page中的每一个对象-->
                        <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td>
                                    <img height="100" , width="100" src="${productInfo.productIcon}" alt="">
                                </td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td>
                                    <a href="#">修改</a>
                                </td>
                                <td>
                                    <a href="#">下架</a>
                                </td>

                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>

                <ul class="pagination">
                    <li>
                        <a href="#">Prev</a>
                    </li>
                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled">
                                <a href="#">${index}</a>
                            </li>
                        <#else >
                             <li>
                                <a href="/seller/product/list?page=${index}&size=${size}">${index}</a>
                             </li>
                        </#if>

                    </#list>


                    <li>
                        <a href="#">Next</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>