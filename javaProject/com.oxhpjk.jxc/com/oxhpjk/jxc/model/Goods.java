package com.oxhpjk.jxc.model;

public class Goods extends BaseModel {
	private String id;
	private String goodsname;// ȫ��
	private String shorts;// ���
	private String productplace;// ���ء�
	private String size;// ���
	private String packages;// ��װ
	private String productcode;// ��Ʒ����
	private String promitcode;// ��׼�ĺ�
	private float price;// �۸�
	private String memo;// ��ע
	private String providerId;// ��Ӧ�̱��
	private int available;// 0:�����ã�1������
	
	public Goods() {
		super();
	}
	

	public Goods(String id, String goodsname, String shorts, String productplace, String size, String packages,
			String productcode, String promitcode, float price, String memo, String providerId) {
		super();
		this.id = id;
		this.goodsname = goodsname;
		this.shorts = shorts;
		this.productplace = productplace;
		this.size = size;
		this.packages = packages;
		this.productcode = productcode;
		this.promitcode = promitcode;
		this.price = price;
		this.memo = memo;
		this.providerId = providerId;
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getShorts() {
		return shorts;
	}

	public void setShorts(String shorts) {
		this.shorts = shorts;
	}

	public String getProductplace() {
		return productplace;
	}

	public void setProductplace(String productplace) {
		this.productplace = productplace;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getPromitcode() {
		return promitcode;
	}

	public void setPromitcode(String promitcode) {
		this.promitcode = promitcode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public Object getValue(Integer columnNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
