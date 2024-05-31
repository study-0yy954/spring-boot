package top.liyanxing.springbootstudyuse.common.baseclass;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperOpt
{
    @Getter
    @Autowired
    private ObjectMapper objectMapper;

    public JsonNode readTree(String content)
    {
        try
        {
            return objectMapper.readTree(content);
        }
        catch (Exception e)
        {
            throw RuntimeExceptionOpt.getInstance("反序列化【{}】错误【{}】", content, e.getMessage());
        }
    }

    public <T> T treeToValue(TreeNode n, Class<T> valueType)
    {
        try
        {
            return objectMapper.treeToValue(n, valueType);
        }
        catch (Exception e)
        {
            throw RuntimeExceptionOpt.getInstance("JsonNode置换为对象出错【{}】【{}】", n, e.getMessage());
        }
    }
}
