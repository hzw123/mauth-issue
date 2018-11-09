<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">创建时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">修改时间：</label>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">用户ID：</label>${bean.userInfoId!}
	</div>
    <div class="form-group">
		<label class="control-label">账户ID：</label>${bean.acctInfoId!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1支付单 2充值单 3退款单 4提现单">交易单类型：</label>${bean.billType!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1 成功 2 异常">账单状态：</label>${bean.billStatus!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1 入账 2 出账">交易类型：</label>${bean.tradeType!}
	</div>
    <div class="form-group">
		<label class="control-label">支付交易订单号：</label>${bean.paySerialNo!}
	</div>
    <div class="form-group">
		<label class="control-label">余额：</label>${bean.totalBalance!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>