<#assign base=request.contextPath /> 
<div class="bjui-pageContent">
	<form action="${base}/admin/orderCardPay/update" data-toggle="validate" method="post">
		<input type="hidden" name="id" value="${bean.id}"/>
		<div class="form-group">
            <label class="control-label x85">支付时间：</label>
            <input type="text" name="gmtCreate" value="${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="支付时间" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">流水号：</label>
            <input type="text" name="serialNo" value="${bean.serialNo!}" placeholder="流水号" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">流水类型：</label>
            <input type="text" name="serialType" value="${bean.serialType!}" placeholder="流水类型" size="20">
        </div>
		<div class="form-group">
            <label class="control-label x85">订单id：</label>
            <input type="text" name="orderCardId" value="${bean.orderCardId!}" placeholder="订单id" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">流水金额：</label>
            <input type="text" name="serialAmount" value="${bean.serialAmount!}" placeholder="流水金额" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85" title="1 支付成功,0 支付失败">状态：</label>
            <input type="text" name="status" value="${bean.status!}" placeholder="状态" size="20">
        </div>

	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>