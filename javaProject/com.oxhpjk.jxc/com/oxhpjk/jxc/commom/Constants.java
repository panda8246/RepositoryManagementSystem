package com.oxhpjk.jxc.commom;

public interface Constants {

	public static final int PSTM_TYPE=0;//��ͳ��Ԥ����ģʽ
    public static final int CALL_TYPE=1;//���ʴ洢����
    public static final int DATA_DEL= 0;//��ʾɾ������
    public static final int DATA_FIND = 1;//��ʾ�һ�����
    
    //ҵ�������������
    String OPERATOR_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.OperatorServiceImpl";//������ҵ����
    String CUSTOMER_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.CustomerServiceImpl";//�ͻ�ҵ����
    String  PROVIDER_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.ProviderServiceImpl";//��Ӧ��ҵ����
    String  GOODS_SERVICE_CLASS ="com.oxhpjk.jxc.service.impl.GoodsServiceImpl";//��Ӧ��ҵ����
    String INPORT_SERVICE_CLASS = "com.oxhpjk.jxc.service.impl.InportServiceImp";//����
    String OUTPORT_SERVICE_CLASS = "com.oxhpjk.jxc.service.impl.OutportServiceImp";//����
    String SALES_SERVICE_CLASS = "com.oxhpjk.jxc.service.impl.SalesServiceImp";
    String SALESBACK_SERVICE_CLASS = "com.oxhpjk.jxc.service.impl.SalesbackServiceImp";
    String STOCK_SERVICE_CLASS = "com.oxhpjk.jxc.service.impl.StockServiceImp";

}
