package com.oxhpjk.jxc.commom;

public interface Constants {

	public static final int PSTM_TYPE=0;//传统的预处理模式
    public static final int CALL_TYPE=1;//访问存储过程
    public static final int DATA_DEL= 0;//表示删除数据
    public static final int DATA_FIND = 1;//表示找回数据
    
    //业务类的完整包名
    String OPERATOR_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.OperatorServiceImpl";//操作者业务类
    String CUSTOMER_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.CustomerServiceImpl";//客户业务类
    String  PROVIDER_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.ProviderServiceImpl";//供应商业务类
    String  GOODS_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.GoodsServiceImpl";//供应商业务类

}
