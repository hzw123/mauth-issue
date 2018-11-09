<div class="bjui-pageContent">
    <div class="form-group">
        <label class="control-label">支付时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
    </div>
    <div class="form-group">
        <label class="control-label">流水号：</label>${bean.serialNo!}
    </div>
    <div class="form-group">
        <label class="control-label">流水类型：</label>${bean.serialType!}
    </div>
    <div class="form-group">
        <label class="control-label">订单id：</label>${bean.orderCardId!}
    </div>
    <div class="form-group">
        <label class="control-label">流水金额：</label>${bean.serialAmount!}
    </div>
    <div class="form-group">
        <label class="control-label" title="1 支付成功,0 支付失败">状态：</label>${bean.status!}
    </div>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>