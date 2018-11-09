<#assign base=request.contextPath /> 
<div class="bjui-pageContent">
	<form action="${base}/admin/cardInfo/update" data-toggle="validate" method="post">
		<input type="hidden" name="id" value="${bean.id}"/>
        <div class="form-group">
            <label class="control-label x85">创建时间：</label>
            <input type="text" name="serialTime" value="${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="流水时间" size="34" readonly>
        </div>
        <div class="form-group">
            <label class="control-label x85">修改时间：</label>
            <input type="text" name="serialTime" value="${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="流水时间" size="34" readonly>
        </div>
        <div class="form-group">
            <label class="control-label x85">卡面额：</label>
            <input type="text" name="cardType" value="${bean.cardFacePrice!}" placeholder="流水类型" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85">卡密：</label>
            <input type="text" name="uuid" value="${bean.uuid!}" placeholder="卡密" size="34" readonly >
        </div>
        <div class="form-group">
            <label class="control-label x85">卡类型：</label>
            <input type="text" name="cardType" value="${bean.cardType!}" placeholder="卡类型" size="34" readonly>
        </div>
        <div class="form-group">
            <label class="control-label x85">订单id：</label>
            <input type="text" name="orderCardId" value="${bean.orderCardId!}" placeholder="订单id" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85">订单支付流水id：</label>
            <input type="text" name="orderCardPayId" value="${bean.orderCardPayId!}" placeholder="订单支付流水id" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85" title="1 创建 2激活">状态：</label>
            <input type="text" name="status" value="${bean.status!}" placeholder="流水状态" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85" title="单位：天">激活有效期：</label>
            <input type="text" name="status" value="${bean.days!}" placeholder="激活有效期" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85">是否过期：</label>
            <input type="text" name="status" value="${(bean.expire?string('true','false'))!}" placeholder="是否过期" size="34" >
        </div>
        <div class="form-group">
            <label class="control-label x85">备注：</label>
            <input type="text" name="remark" value="${bean.remark!}" placeholder="备注" size="34" >
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>