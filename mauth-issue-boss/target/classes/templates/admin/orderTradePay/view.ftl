<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">创建时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">修改时间：</label>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1创建 2支付成功 3支付失败 9异常">状态：</label>${bean.payStatus!}
	</div>
    <div class="form-group">
		<label class="control-label">交易订单ID：</label>${bean.paySerialNo!}
	</div>
    <div class="form-group">
		<label class="control-label">平台交易号：</label>${bean.orderTradeNo!}
	</div>
    <div class="form-group">
		<label class="control-label">用户ID：</label>${bean.userInfoId!}
	</div>
    <div class="form-group">
		<label class="control-label">账户ID：</label>${bean.acctInfoId!}
	</div>
    <div class="form-group">
		<label class="control-label">账户日志ID：</label>${bean.acctLogId!}
	</div>
    <div class="form-group">
		<label class="control-label">商品ID：</label>${bean.itemId!}
	</div>
    <div class="form-group">
        <label class="control-label">商品编号：</label>${bean.itemNo!}
	</div>
    <div class="form-group">
		<label class="control-label">销售价：</label>${bean.salesPrice!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1余额">支付类型：</label>${bean.payType!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1 入账 2 出账">交易类型：</label>${bean.tradeType!}
	</div>
    <div class="form-group">
		<label class="control-label">错误信息：</label>${bean.errorMsg!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>