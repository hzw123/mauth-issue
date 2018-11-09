<#assign base=request.contextPath /> 
<div class="bjui-pageContent">
	<form action="${base}/admin/cardLog/update" data-toggle="validate" method="post">
		<input type="hidden" name="id" value="${bean.id}"/>
		<div class="form-group">
            <label class="control-label x85">支付时间：</label>
            <input type="text" name="gmtCreate" value="${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}" placeholder="支付时间" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85">储值卡信息ID：</label>
            <input type="text" name="orderCardWaterId" value="${bean.orderCardWaterId!}" placeholder="储值卡流水id" size="20" readonly>
        </div>
		<div class="form-group">
            <label class="control-label x85" title="1:创建,2:激活">状态：</label>
            <input type="text" name="status" value="${bean.status!}" placeholder="状态" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">用户id：</label>
            <input type="text" name="userId" value="${bean.userId!}" placeholder="用户id" size="20" >
        </div>
		<div class="form-group">
            <label class="control-label x85">消息：</label>
            <input type="text" name="msg" value="${bean.msg!}" placeholder="消息" size="20" >
        </div>

	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">修改</button></li>
    </ul>
</div>