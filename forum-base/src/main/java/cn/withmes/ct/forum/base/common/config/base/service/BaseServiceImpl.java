package cn.withmes.ct.forum.base.common.config.base.service;

import cn.withmes.ct.forum.base.common.config.base.dal.BaseMapper;
import cn.withmes.ct.forum.base.common.config.base.exception.ValidateErrorException;
import cn.withmes.ct.forum.base.common.config.base.utils.Reflections;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * ClassName: BaseServiceImpl
 *
 * @param <T>
 * @author liming
 * @Description: 业务实现层基类
 * @date 2018年3月20日
 * <p>
 * =================================================================================================
 * Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 */
public abstract class BaseServiceImpl<T> implements Serializable {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private Validator validator;

    private BaseMapper<T> mapper;

    protected Class<T> entityClass;

    public BaseServiceImpl() {
        entityClass = Reflections.getClassGenricType(getClass());
    }

    @PostConstruct
    private void initConfig() {
        this.mapper = this.getBaseMapper();
    }

    /**
     * @return
     * @Description: 获取实体对象
     * @author liming
     * @date 2016年9月3日
     */
    public abstract BaseMapper<T> getBaseMapper();

    /**
     * @param entity
     * @throws Exception
     * @Description: 校验器
     * @author liming
     * @date 2018年3月20日
     */
    public void validate(T entity) {
        if (null == validator) {
            return;
        }
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateError.append("属性：").append(constraintViolation.getPropertyPath()).append("报错！")
                        .append(constraintViolation.getMessage()).append(";");
            }
            throw new ValidateErrorException(validateError.toString());
        }
    }

    public int add(T entity) {
        validate(entity);

        return mapper.insert(entity);
    }

    public int update(T entity) {
        return mapper.updateById(entity);
    }


    public int delete(Serializable id) {
        return mapper.deleteById(id);
    }

    public T findById(Serializable id) {
        return mapper.selectById(id);
    }

    public List<T> findBatchIds(Collection<? extends Serializable> idList) {
        return mapper.selectBatchIds(idList);
    }

    public List<T> findByParams(Wrapper<T> wrapper) {
        return mapper.selectList(wrapper);
    }

    public Integer findCount(Wrapper<T> wrapper) {
        return mapper.selectCount(wrapper);
    }




}
