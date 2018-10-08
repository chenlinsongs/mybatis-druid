package com.thorough.mybatis.persistence;


import com.thorough.mybatis.persistence.annotation.Primary;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class CommonDaoAspect {

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.insert(..))")
    public void insert(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.countByExample(..))")
    public void countByExample(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.deleteByExample(..))")
    public void deleteByExample(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.deleteByPrimaryKey(..))")
    public void deleteByPrimaryKey(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.insertSelective(..))")
    public void insertSelective(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.selectByExample(..))")
    public void selectByExample(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.selectByPrimaryKey(..))")
    public void selectByPrimaryKey(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.updateByExampleSelective(..))")
    public void updateByExampleSelective(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.updateByExample(..))")
    public void updateByExample(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.updateByPrimaryKeySelective(..))")
    public void updateByPrimaryKeySelective(){}

    @Pointcut("execution(* com.thorough.*.persistence.model.dao.CommonDao.updateByPrimaryKey(..))")
    public void updateByPrimaryKey(){}



    @Around("insert()")
    public Object insert(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if(args != null){
            Object object = args[0];
            Map map = new HashMap();
            List<Map<String,Object>> columnList = getColumnNameAndValue(object);
            Map primaryMap = getPrimaryFieldNameAndValue(object);
            //插入数据时，一定有主键
            if (columnList != null && primaryMap != null){
                columnList.add(primaryMap);
            }else throw new RuntimeException("columnList is null or primaryMap is null");

            map.put("columns",columnList);
            Object[] args2 = {map};
            result = (int) pjp.proceed(args2);
            return result;
        }else return null;

    }

    @Around("insertSelective()")
    public int insertSelective(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if (args != null){
            Object record = args[0];
            Map map = new HashMap();
            List<Map<String,Object>> selectiveColumnList = getSelectiveColumnNameAndValue(record);
            Map<String,Object> primaryMap = getPrimaryFieldNameAndValue(record);
            //更新时一定有主键
            if (selectiveColumnList != null && primaryMap != null){
                selectiveColumnList.add(primaryMap);
            }else throw new RuntimeException("columnList is null or primaryMap is null");

            map.put("columns",selectiveColumnList);
            Object[] args2 = {map};
            result = (int) pjp.proceed(args2);
            return result;
        }return 0;
    }

    @Around("updateByExampleSelective()")
    public int updateByExampleSelective(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if (args != null){
            Object record = args[0];
            Object example = args[1];
            Map map = new HashMap();
            List<Map<String,Object>> selectiveColumnList = getSelectiveColumnNameAndValue(record);
            Map<String,Object> selectivePrimaryMap = getSelectivePrimaryFieldNameAndValue(record);
            //更新时不一定有主键
            if (selectiveColumnList != null){
                if (selectivePrimaryMap != null)
                    selectiveColumnList.add(selectivePrimaryMap);
            }else throw new RuntimeException("columnList is null");

            map.put("columns",selectiveColumnList);
            Object[] args2 = {map,example};
            result = (int) pjp.proceed(args2);
            return result;
        }return 0;

    }

    @Around("updateByExample()")
    public int updateByExample(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if (args != null){
            Object record = args[0];
            Object example = args[1];
            Map map = new HashMap();
            List<Map<String,Object>> columnList = getColumnNameAndValue(record);
            //更新时不一定有主键
            Map primaryMap = getPrimaryFieldNameAndValue(record);
            if (columnList != null){
                if (primaryMap != null)
                    columnList.add(primaryMap);
            }else throw new RuntimeException("columnList is null");

            map.put("columns",columnList);
            Object[] args2 = {map,example};
            result = (int) pjp.proceed(args2);
            return result;
        }return 0;
    }

    @Around("updateByPrimaryKeySelective()")
    public int updateByPrimaryKeySelective(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if (args != null){
            Object record = args[0];
            Map map = new HashMap();
            List<Map<String,Object>> selectiveColumnList = getSelectiveColumnNameAndValue(record);
            Map<String,Object> primaryMap = getPrimaryFieldNameAndValue(record);
            //一定有主键
            if (selectiveColumnList != null && primaryMap != null){
                map.put("columns",selectiveColumnList);
                String primaryKey = (String)(primaryMap.keySet().toArray()[0]);
                Object primaryValue = primaryMap.values().toArray()[0];
                map.put("primaryKey",primaryKey);
                map.put("primaryValue",primaryValue);
            }else throw new RuntimeException("selectiveColumnList is null or primaryMap is null");
            Object[] args2 = {map};
            result = (int) pjp.proceed(args2);
            return result;
        }return 0;
    }

    @Around("updateByPrimaryKey()")
    public int updateByPrimaryKey(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object[] args = pjp.getArgs();
        if (args != null){
            Object record = args[0];
            Map map = new HashMap();
            List<Map<String,Object>> selectiveColumnList = getColumnNameAndValue(record);
            Map<String,Object> primaryMap = getPrimaryFieldNameAndValue(record);
            //一定有主键
            if (selectiveColumnList != null && primaryMap != null){
                map.put("columns",selectiveColumnList);
                String primaryKey = (String)(primaryMap.keySet().toArray()[0]);
                Object primaryValue = primaryMap.values().toArray()[0];
                map.put("primaryKey",primaryKey);
                map.put("primaryValue",primaryValue);
            }else throw new RuntimeException("selectiveColumnList is null or primaryMap is null");
            Object[] args2 = {map};
            result = (int) pjp.proceed(args2);
            return result;
        }return 0;
    }

    @Around("selectByPrimaryKey()")
    public Object selectByPrimaryKey(final ProceedingJoinPoint pjp) throws Throwable {
        Object entityObject = getActualEntityObject(pjp);
        Map<String,Object> primaryMap = getPrimaryFieldNameAndValue(entityObject);
        String primaryKey = (String)(primaryMap.keySet().toArray()[0]);
        Map map = new HashMap();
        map.put("primaryKey",primaryKey);
        Object value = pjp.getArgs()[0];
        map.put("primaryValue",value);
        Object[] args2 = {map};
        return pjp.proceed(args2);
    }

    @Around("deleteByPrimaryKey()")
    public int deleteByPrimaryKey(final ProceedingJoinPoint pjp) throws Throwable {
        int result;
        Object entityObject = getActualEntityObject(pjp);
        Map<String,Object> primaryMap = getPrimaryFieldNameAndValue(entityObject);
        String primaryKey = (String)(primaryMap.keySet().toArray()[0]);
        Map map = new HashMap();
        map.put("primaryKey",primaryKey);
        Object value = pjp.getArgs()[0];
        map.put("primaryValue",value);
        Object[] args2 = {map};
        result = (int) pjp.proceed(args2);
        return result;
    }


    /*
    * 工具类
    * */

    private List<Map<String,Object>> getColumnNameAndValue(Object object) throws IllegalAccessException {
        List<Field> fields =  FieldUtils.getFieldsListWithAnnotation(object.getClass(),Column.class);
        if (fields != null && fields.size() > 0){
            List list = new ArrayList();
            for (Field field:fields){
                field.setAccessible(true) ;
                Column column = field.getAnnotation(Column.class);
                String name = column.name();
                Object value = field.get(object);
                Map columnMap = new HashMap();
                columnMap.put(name,value);
                list.add(columnMap);
            }
            return list;
        }
        return null;
    }

    private List<Map<String,Object>> getSelectiveColumnNameAndValue(Object object) throws IllegalAccessException {
        List<Field> fields =  FieldUtils.getFieldsListWithAnnotation(object.getClass(),Column.class);
        if (fields != null && fields.size() > 0){
            List list = new ArrayList();
            for (Field field:fields){
                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
                Object value = field.get(object);
                if (value != null){
                    String name = column.name();
                    Map columnMap = new HashMap();
                    columnMap.put(name,value);
                    list.add(columnMap);
                }
            }
            return list;
        }
        return null;
    }

    private Map<String,Object> getPrimaryFieldNameAndValue(Object object) throws IllegalAccessException {
        List<Field> IdFields =  FieldUtils.getFieldsListWithAnnotation(object.getClass(),Primary.class);
        if (IdFields != null && IdFields.size() == 1){
            Field field = IdFields.get(0);
            field.setAccessible(true);
            Primary column = field.getAnnotation(Primary.class);
            FieldUtils.removeFinalModifier(field,true);
            String name = column.name();
            Object value = field.get(object);
            Map primaryMap = new HashMap();
            primaryMap.put(name,value);
            return primaryMap;
        }
        return null;
    }

    private Object getActualEntityObject(ProceedingJoinPoint pjp) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Field proxyMethodInvocation =  FieldUtils.getAllFields(pjp.getClass())[1];
        proxyMethodInvocation.setAccessible(true);
        ReflectiveMethodInvocation invocation = (ReflectiveMethodInvocation) proxyMethodInvocation.get(pjp);
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(((Proxy) invocation.getThis()));
        Field field = FieldUtils.getAllFields(((MapperProxy) invocationHandler).getClass())[2];
        field.setAccessible(true);
        FieldUtils.removeFinalModifier(field,true);
        Class actualDao = (Class) field.get(invocationHandler);
        Type[] daoTypes = actualDao.getGenericInterfaces();
        Type type = daoTypes[0];
        Class primaryClass = null;
        Class entityClass = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments !=null && actualTypeArguments.length == 2){
                primaryClass = (Class) actualTypeArguments[0];
                entityClass = (Class) actualTypeArguments[1];
            }else {
                throw new RuntimeException("设置的泛型不对");
            }
        }
        String name = entityClass.getName();
        Object object =  Class.forName(name).newInstance();
        return object;
    }

    private Map<String,Object> getSelectivePrimaryFieldNameAndValue(Object object) throws IllegalAccessException {
        List<Field> IdFields =  FieldUtils.getFieldsListWithAnnotation(object.getClass(),Primary.class);
        if (IdFields != null && IdFields.size() == 1){
            Field field = IdFields.get(0);
            field.setAccessible(true);
            Primary column = field.getAnnotation(Primary.class);
            Object value = field.get(object);
            if (value != null){
                String name = column.name();
                Map primaryMap = new HashMap();
                primaryMap.put(name,value);
                return primaryMap;
            }
        }
        return null;
    }

}
