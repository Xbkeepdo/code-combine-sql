import com.easyjava.RunDemoApplication;
import com.easyjava.entity.po.ProductInfo;
import com.easyjava.entity.query.ProductInfoQuery;
import com.easyjava.mappers.ProductInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = RunDemoApplication.class)
@RunWith(SpringRunner.class)
public class MapperTest {
    @Resource
    private ProductInfoDao<ProductInfo, ProductInfoQuery> productInfoDao;
    @Test
    public void selectList() {
        ProductInfoQuery query = new ProductInfoQuery();
       // query.setId(1);
        //query.setCreateDateStart("2024-03-13");
        query.setProductNameFuzzy("1");
       List<ProductInfo> dataList = productInfoDao.selectList(query);
       for (ProductInfo productInfo : dataList) {
           System.out.println(productInfo);
       }

       Long count = productInfoDao.selectCount(query);
         System.out.println(count);
    }

    @Test
    public void insert() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setCode("1");
        productInfo.setProductName("1");
       // productInfo.setPrice(1.0);
        productInfo.setSkuType(2);
        productInfo.setColorType(2);
        productInfo.setCreateTime(new Date());
        productInfo.setCreateDate(new Date());
        this.productInfoDao.insert(productInfo);
        System.out.println(productInfo.getId());
    }

    @Test
    public void insertorUpdate() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setCode("2");

        //productInfo.setId(7);
        // productInfo.setPrice(1.0);
        productInfo.setProductName("test2");
        productInfo.setSkuType(2);
        productInfo.setColorType(2);
        productInfo.setCreateTime(new Date());
        productInfo.setCreateDate(new Date());
        this.productInfoDao.insertOrUpdate(productInfo);
        System.out.println(productInfo.getId());
    }

    @Test
    public void insertorUpdateBatch() {
        //批量插入测试用例
        // 创建测试数据列表
        List<ProductInfo> productList = new ArrayList<>();
        // 添加测试数据
        productList.add(new ProductInfo(11, "code1", "3","dada", new BigDecimal(1.2), 1, 1, new Date(),  new Date(),10l, 0,1));
        productList.add(new ProductInfo(15, "code2", "6", "test5", new BigDecimal(1.1), 6,6, new Date(),  new Date(), 1l, 0,1));
        // 调用方法进行批量插入或更新
        this.productInfoDao.insertOrUpdateBatch(productList);



    }

}
