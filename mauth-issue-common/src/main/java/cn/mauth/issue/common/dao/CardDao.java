package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.Card;
import cn.mauth.issue.util.base.BaseMauth;

import java.util.List;

public interface CardDao extends BaseMauth<Card,Long>{

    List<Card> putAway();
}
