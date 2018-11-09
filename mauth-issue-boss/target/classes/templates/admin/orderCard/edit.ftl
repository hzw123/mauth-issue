<#assign base=request.contextPath /> 
<div class="bjui-pageContent">
	<form action="${base}/admin/orderCard/update" data-toggle="validate" method="post">
		<input type="hidden" name="id" value="${bean.id}"/>
		<div class="form-group">
            <label class="control-label x85">订单名称：</label>
            <input type="text" name="orderCardName" value="${bean.orderCardName!}" placeholder="订单名称" size="20">
        </div>
		<div class="form-group">
            <label class="control-label x85">订单类型：</label>
            <select name="orderType" data-toggle="selectpicker" data-width="80">
                <option value="内部"
                <#if bean.orderType='内部'>
                    selected
                </#if>
                >内部</option>
                <option value="对公"
                <#if bean.orderType='对公'>
                    selected
                </#if>
                >对公</option>
                <option value="X事件"
                <#if bean.orderType='X事件'>
                    selected
                </#if>
                >X事件</option>
            </select>
        </div>
		<div class="form-group">
            <label class="control-label x85">下单时间：</label>
            <input type="text" name="gmtCreate" value="${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="下单时间" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">修改时间：</label>
            <input type="text" name="gmtModified" value="${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="修改时间" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">订单总价：</label>
            <input type="text" name="totalPrice" value="${bean.totalPrice!}" placeholder="订单总价" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">支付账户：</label>
            <input type="text" name="userPayAccount" value="${bean.userPayAccount!}" placeholder="用户支付账户" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">支付方式：</label>
            <input type="text" name="payType" value="${bean.payType!}" placeholder="支付方式" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">身份标识：</label>
            <input type="text" name="authSign" value="${bean.authSign!}" placeholder="身份标识" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">状态：</label>
            <input type="text" name="status" value="${bean.status!}" placeholder="状态" size="20" >
        </div>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>