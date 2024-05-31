package top.liyanxing.springbootstudyuse.common.baseclass;

import cn.hutool.core.util.StrUtil;

public class RuntimeExceptionOpt extends java.lang.RuntimeException
{
    private RuntimeExceptionOpt(String message)
    {
        super(message);
    }

    private RuntimeExceptionOpt(Throwable cause)
    {
        super(cause);
    }

    public static RuntimeExceptionOpt getInstance(CharSequence template, Object... params)
    {
        String message = StrUtil.format(template, params);
        RuntimeExceptionOpt obj = new RuntimeExceptionOpt(message);
        return obj;
    }

    public static RuntimeExceptionOpt getInstance(Throwable cause)
    {
        RuntimeExceptionOpt obj = new RuntimeExceptionOpt(cause);
        return obj;
    }
}
