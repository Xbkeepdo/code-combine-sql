package com.easyjava.service.Impl;


import com.easyjava.entity.po.ProductInfo;
import com.easyjava.entity.query.ProductInfoQuery;
import com.easyjava.entity.query.SimplePage;
import com.easyjava.entity.vo.PaginationResultVO;
import com.easyjava.enums.PageSize;
import com.easyjava.mappers.ProductInfoDao;
import com.easyjava.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:商品信息 业务接口实现
 * @Author:xb
 * @date: 2024/04/12
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService{

	@Resource
	private ProductInfoDao<ProductInfo, ProductInfoQuery> productInfoDao;

	/**
	 * 根据条件查询列表
	 */
	public List<ProductInfo> findListByParam(ProductInfoQuery query) {
		return this.productInfoDao.selectList(query);	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(ProductInfoQuery query) {
		return this.productInfoDao.selectCount(query);	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<ProductInfo> findListByPage(ProductInfoQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<ProductInfo> list = this.findListByParam(query);
		PaginationResultVO<ProductInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(ProductInfo bean) {
		return this.productInfoDao.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<ProductInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.productInfoDao.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<ProductInfo> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.productInfoDao.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据 Id 查询
	 */
	public ProductInfo getProductInfoById(Integer id) {
		return this.productInfoDao.selectById(id);}

	/**
	 * 根据 Id 更新
	 */
	public Integer updateProductInfoById(ProductInfo bean, Integer id) {
		return this.productInfoDao.updateById(bean, id);}

	/**
	 * 根据 Id 删除
	 */
	public Integer deleteProductInfoById(Integer id) {
		return this.productInfoDao.deleteById(id);}

	/**
	 * 根据 Code 查询
	 */
	public ProductInfo getProductInfoByCode(String code) {
		return this.productInfoDao.selectByCode(code);}

	/**
	 * 根据 Code 更新
	 */
	public Integer updateProductInfoByCode(ProductInfo bean, String code) {
		return this.productInfoDao.updateByCode(bean, code);}

	/**
	 * 根据 Code 删除
	 */
	public Integer deleteProductInfoByCode(String code) {
		return this.productInfoDao.deleteByCode(code);}

	/**
	 * 根据 SkuTypeAndColorType 查询
	 */
	public ProductInfo getProductInfoBySkuTypeAndColorType(Integer skuType, Integer colorType) {
		return this.productInfoDao.selectBySkuTypeAndColorType(skuType, colorType);}

	/**
	 * 根据 SkuTypeAndColorType 更新
	 */
	public Integer updateProductInfoBySkuTypeAndColorType(ProductInfo bean, Integer skuType, Integer colorType) {
		return this.productInfoDao.updateBySkuTypeAndColorType(bean, skuType, colorType);}

	/**
	 * 根据 SkuTypeAndColorType 删除
	 */
	public Integer deleteProductInfoBySkuTypeAndColorType(Integer skuType, Integer colorType) {
		return this.productInfoDao.deleteBySkuTypeAndColorType(skuType, colorType);}
}