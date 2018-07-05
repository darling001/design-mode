package com.gupao.vip.plugin;

import com.gupao.vip.PageHandler;
import com.gupao.vip.util.JSONUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @author : ShenJiaQing
 * @date : 2018/6/14
 * Time: 9:59
 * Description: 分页拦截器1.0版本
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class PageInterceptor implements Interceptor {

    private ResultHandler resultHandler;

    private final PageHandler pageHandler = new PageHandler();

    private final static String DECLARED_FIELD_NAME = "pageParamMap";

    private final static String PAGE_NO = "pageNo";

    private final static String PAGE_SIZE = "pageSize";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
        CachingExecutor executor = (CachingExecutor) invocation.getTarget();
        Object parameterObject = invocation.getArgs()[1];
        RowBounds rowBounds = getPageNoAndSize(pageHandler);
        List<?> list = executor.query(mappedStatement, parameterObject, rowBounds, resultHandler,null,boundSql);
        System.out.println(String.format("Total: %s",list.size()));
        System.out.println(list);
        return list;
    }

    /**
     * 获取RowBounds对象中的offset和limit两个属性值,并初始化RowBounds。
     *
     * @param pageHandler
     * @return
     */
    public RowBounds getPageNoAndSize(PageHandler pageHandler) throws Exception{
        Field field = pageHandler.getClass().getDeclaredField(DECLARED_FIELD_NAME);
        field.setAccessible(true);
        Object pageInfo = field.get(pageHandler);
        String pageInfos = JSONUtil.toJson(pageInfo);
        JSONObject pageJson = JSONObject.fromObject(pageInfos);
        int pageNo = pageJson.getInt(PAGE_NO);
        int pageSize = pageJson.getInt(PAGE_SIZE);
        return new RowBounds((pageNo - 1) * pageSize, pageSize);
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
