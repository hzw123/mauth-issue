<#assign base=request.contextPath />
<div class="bjui-pageContent">
	<form action="${base}/admin/orderCardPay/save" data-toggle="validate" method="post">
        <div class="form-group">
            <label class="control-label x85">流水号：</label>
            <input type="text" name="serialNo" value="" placeholder="流水号" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">流水类型：</label>
            <input type="text" name="serialType" value="" placeholder="流水类型" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">订单id：</label>
            <input type="text" name="orderCardId" value="" placeholder="订单id" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85">流水金额：</label>
            <input type="text" name="serialAmount" value="" placeholder="流水金额" size="20" data-rule="required">
        </div>
        <div class="form-group">
            <label class="control-label x85" title="1 支付成功,0 支付失败">状态：</label>
            <input type="text" name="status" value="1" placeholder="状态" size="20">
        </div>

	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">添加</button></li>
    </ul>
</div>