<div class="bjui-pageContent">
    <div class="form-group">
        <label class="control-label">订单名称：</label>${bean.orderCardName!}
    </div>
    <div class="form-group">
        <label class="control-label">订单类型：</label>${bean.orderType!}
    </div>
    <div class="form-group">
        <label class="control-label">下单时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
    </div>
    <div class="form-group">
        <label class="control-label">修改时间：</label>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}
    </div>

    <div class="form-group">
        <label class="control-label">订单总价：</label>${bean.totalPrice!}
    </div>
    <div class="form-group">
        <label class="control-label">用户支付账户：</label>${bean.userPayAccount!}
    </div>
    <div class="form-group">
        <label class="control-label">支付方式：</label>${bean.payType!}
    </div>
    <div class="form-group">
        <label class="control-label">身份标识：</label>${bean.authSign!}
    </div>
    <div class="form-group">
        <label class="control-label">状态：</label>${bean.status!}
    </div>
    <div class="form-group">
        <label class="control-label">有效天数：</label>${bean.days!}
    </div>
    <div class="form-group" >
        <table class="table table-bordered table-hover table-top">
            <thead>
            <tr><th colspan="3" align="center"><h4>订单详情</h4></th></tr>
            <tr>
                <th>储值卡面额</th>
                <th>数量</th>
                <th>总价</th>
            </tr>
            </thead>
            <tbody id="card-bills">
            <#if bean.list??>
                <#list bean.list as bills>
                    <tr>
                        <td>${bills.cardFacePrice!}元</td>
                        <td>${bills.amount!}</td>
                        <td>${bills.total!}元</td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>