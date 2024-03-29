package com.integral.applications.account.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.integral.applications.account.bean.AccountBaseInfo;
import com.integral.applications.account.bean.AccountCardInfo;
import com.integral.applications.account.dao.IAccountCardInfoDao;
import com.integral.applications.account.service.IAccountCardInfoService;
import com.integral.common.dao.impl.BaseDao;

/** 
 * <p>Description: [描述该类概要功能介绍]</p>
 * @author  <a href="mailto: swpigris81@126.com">代超</a>
 * @version $Revision$ 
 */
public class AccountCardInfoServiceImpl implements IAccountCardInfoService {
    private Log log = LogFactory.getLog(AccountCardInfoServiceImpl.class);
    private IAccountCardInfoDao accountCardDao;
    private BaseDao baseDao;
    
    public IAccountCardInfoDao getAccountCardDao() {
        return accountCardDao;
    }

    public void setAccountCardDao(IAccountCardInfoDao accountCardDao) {
        this.accountCardDao = accountCardDao;
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param cardInfo
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public void save(AccountCardInfo cardInfo) {
        log.info("save instance");
        this.accountCardDao.save(cardInfo);
    }
    
    /**
     * <p>Discription:[保存数据]</p>
     * @param cardInfo
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public void update(AccountCardInfo cardInfo){
        log.info("update instance");
        this.accountCardDao.update(cardInfo);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param cardInfo
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public void saveOrUpdate(AccountCardInfo cardInfo) {
        log.info("save or update instance");
        this.accountCardDao.saveOrUpdate(cardInfo);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param cardInfos
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public void saveOrUpdateAll(Collection<AccountCardInfo> cardInfos) {
        log.info("save or update all instances");
        this.accountCardDao.saveOrUpdateAll(cardInfos);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param cardInfos
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public void delete(AccountCardInfo cardInfos) {
        log.info("delete instance");
        this.accountCardDao.delete(cardInfos);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param cardInfos
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public void deleteAll(Collection<AccountCardInfo> cardInfos) {
        log.info("delete all instances");
        this.accountCardDao.deleteAll(cardInfos);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param id
     * @return
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public AccountCardInfo findById(String id) {
        log.info("find by id");
        return this.accountCardDao.findById(id);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param instance
     * @return
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public List<AccountCardInfo> findByExample(AccountCardInfo instance) {
        log.info("find by propertis");
        return this.accountCardDao.findByExample(instance);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param propertyName
     * @param value
     * @return
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public List<AccountCardInfo> findByProperty(String propertyName, Object value) {
        log.info("find by property");
        return this.accountCardDao.findByProperty(propertyName, value);
    }

    /**
     * <p>Discription:[方法功能中文描述]</p>
     * @param sql
     * @param isSql
     * @param paramMap
     * @param start
     * @param limit
     * @return
     * @author:[代超]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */

    @Override
    public List findBySql(String sql, boolean isSql, Map<String, Object> paramMap, int start, int limit) {
        log.info("find by sql : " + sql);
        return this.accountCardDao.findBySql(sql, isSql, paramMap, start, limit);
    }

    @Override
    public List<AccountCardInfo> findInstanceList(Map<String, Object> paramMap, int start, int limit) {
        String sql = "from AccountCardInfo model where model.cardUser = :userName";
        return this.findBySql(sql, false, paramMap, start, limit);
    }

    @Override
    public int findInstanceListSize(Map<String, Object> paramMap) {
        String sql = "select count(model.accountId) from AccountCardInfo model where model.cardUser = :userName";
        List list = this.baseDao.queryPageByHQL(sql, paramMap, -1, -1);
        return NumberUtils.toInt(String.valueOf(list.get(0)), 0);
    }

    @Override
    public void transferAccount(AccountCardInfo outCard, AccountCardInfo inCard, double amount, String comment) throws Exception {
        BigDecimal outAmount = new BigDecimal("" + (outCard.getCardBalance() == null ? 0.0 : outCard.getCardBalance()));
        BigDecimal inAmount = new BigDecimal("" + (inCard.getCardBalance() == null ? 0.0 : inCard.getCardBalance()));
        BigDecimal tranAmount = new BigDecimal("" + amount);
        double newOutAmount = outAmount.add(tranAmount.negate()).doubleValue();
        if(newOutAmount < 0){
            throw new Exception("您所选转出账户余额不足！");
        }
        outCard.setCardBalance(newOutAmount);
        inCard.setCardBalance(inAmount.add(tranAmount).doubleValue());
        List<AccountCardInfo> instances = new ArrayList<AccountCardInfo>();
        instances.add(outCard);
        instances.add(inCard);
        this.accountCardDao.saveOrUpdateAll(instances);
    }

    @Override
    public void backAccount(List<AccountBaseInfo> baseInfoList) {
        if(baseInfoList == null || baseInfoList.isEmpty()){
            return;
        }
        Map<String, Double> back = new HashMap<String, Double>();
        for(AccountBaseInfo info : baseInfoList){
            String cardId = info.getAccountcard();
            double margin = info.getAccountmargin();
            Double temp = back.get(cardId);
            if(temp != null){
                back.put(cardId, (new BigDecimal(margin + "").add(new BigDecimal(temp + ""))).doubleValue());
            }else{
                back.put(cardId, margin);
            }
        }
        Set<String> set = back.keySet();
        List<AccountCardInfo> cardList = new ArrayList<AccountCardInfo>();
        
        for(String key : set){
            AccountCardInfo card = this.accountCardDao.findById(key);
            if(card == null){
                continue;
            }
            card.setCardBalance((new BigDecimal(card.getCardBalance() + "").add(new BigDecimal(back.get(key) + "").negate())).doubleValue());
            cardList.add(card);
        }
        
        if(cardList != null && !cardList.isEmpty()){
            this.accountCardDao.saveOrUpdateAll(cardList);
        }
    }
}
