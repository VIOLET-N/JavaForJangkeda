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
                    <form role="form" method="post" action="/seller/product/save">
                        <div class="form-group">
                            <label for="productName">商品名称</label>
                            <input name="productName" id="productName" type="text" class="form-control" value="${(productInfo.productName)!''}" />
                        </div>

                        <div class="form-group">
                            <label for="productPrice">价格</label>
                            <input name="productPrice" type="text" class="form-control" id="productPrice" value="${(productInfo.productPrice)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="productStock">库存</label>
                            <input name="productStock" type="text" class="form-control" id="productStock" value="${(productInfo.productStock)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="productDescription">商品描述</label>
                            <input name="productDescription" type="text" class="form-control" id="productDescription" value="${(productInfo.productDescription)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="">商品图片</label>
                            <img width="100px" height="100px" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control" id="productIcon" value="${(productInfo.productIcon)!''}"/>
                        </div>

                        <div class="form-group">
                            <label for="categoryType">类目</label>
                            <select name="categoryType" id="categoryType">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                    <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                        selected
                                    </#if>
                                    >${category.categoryName}</option>
                                </#list>
                            </select>
                        </div>

                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>