package top.liyanxing.springbotstudy;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.map.MapUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        // 读取数据
        Map<String, String> customerDataMap = getCustomerData();
        List<AccountEntity> accountDataList = getAccountData();

        // 赋值 organizationId // TODO 李艳兴 有个没有赋值上
        for (AccountEntity el : accountDataList)
        {
            el.setOrganizationId(customerDataMap.get(el.getOrganizationName()));
        }
        Console.log("输出数据【{}】", accountDataList);
    }

    private static Map<String, String> getCustomerData()
    {
        Map<String, String> map = MapUtil.newHashMap(22);
        map.put("贵州淇彤安捷汽车销售有限公司","ba9ee579-7e1f-41ed-8359-ce8698d6dc08");
        map.put("湖北晨曦汽车服务有限公司","30b09df8-6be3-42de-b417-32492896230f");
        map.put("威海新贵族商务咨询有限公司","0e22c9b1-8c45-4616-8a40-bca07a1ba978");
        map.put("江西鸣笛汽车销售有限公司","4a748ad5-e71c-42db-a0fb-c5260c9a5ef7");
        map.put("云南裕祥信息咨询有限公司","112a98c8-d070-4fd4-bdb2-b31a1ef02e3a");
        map.put("成都众毅弘创企业管理有限公司","e110b445-c98b-490b-9970-0cc824c8b7fb");
        map.put("成都浩起科技有限公司","b5588826-4a13-436e-b00f-f1a81c26476f");
        map.put("上海众丽二手车销售有限公司","d2f93045-0704-401f-941e-0afb54d8e453");
        map.put("华夏辉煌（厦门）资产管理有限公司","8450d0b0-95d1-4103-9523-660b9c4cabc7");
        map.put("黑龙江牟天融资租赁有限公司","a46b692b-c61b-401f-a90d-dedfd1c71e40");
        map.put("山东招财万福网络科技有限公司","549e0176-39c6-4d1a-b140-c1ca9710bf4a");
        map.put("天津鑫轮汽车贸易有限公司","c19f3e97-dda7-4169-bf2d-197b6299c829");
        map.put("明溪县鑫诚辉汽车服务有限公司","574e8fdd-434f-4684-8c32-95360aebc311");
        map.put("山东美信汽车服务有限公司","ec0ab553-4c21-4f6b-8b65-d058b85df6f0");
        map.put("上海安喜汽车销售服务有限公司","440101c8-da4d-4fe9-a347-662bc022070d");
        map.put("贵州车界汽车服务有限公司","471990d8-24cb-4b8f-92a7-6b3194263396");
        map.put("河北玛萨信息科技有限公司","e455db2b-4b9d-486b-b3f8-36f204371291");
        map.put("湖北随州众大二手专用车交易市场有限公司","62abca16-7506-4993-b394-f6ee34aeb4a6");
        map.put("上海铸驾信息咨询服务有限公司","375b8f67-0a7b-4959-87a8-80f85483617b");
        map.put("襄阳太和汽车贸易有限公司","8bb75677-fea9-4e79-a6df-ae536520fd5c");
        map.put("南领（广州）企业管理有限公司","4029a0da-d044-4728-80f4-0fd858200c24");
        map.put("湖南盛世大数据有限公司","4f222a81-7e22-4fa9-9e5c-3253c4e898e0");
        return map;
    }

    public static List<AccountEntity> getAccountData()
    {
        ExcelReader reader = ExcelUtil.getReader("/Users/leeyx/Library/CloudStorage/Dropbox/电脑数据/工作/01.项目/01.版本开发资料与问题解决资料/【创格项目】_重新推送账号/02.账号数据.xlsx");
        List<AccountEntity> accountEntityList = reader.readAll(AccountEntity.class);
        reader.close();
        return accountEntityList;
    }
}