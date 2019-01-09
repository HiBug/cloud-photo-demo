package com.xin.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.xin.base.core.DefaultPageRequestBean;
import com.xin.base.core.NotFoundRequestBean;
import com.xin.base.core.RequestBean;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * @author three
 * @since 2018/12/26 23:27
 * <p>
 *
 * </p>
 */
@Getter
public enum FunctionEnum {
    schoolList(FunctionCode.schoolList, "学校列表", DefaultPageRequestBean.class),
    notFound(FunctionCode.notFound, "doNothing", NotFoundRequestBean.class);

    private String                       code;
    private String                       desc;
    private Class<? extends RequestBean> requestBeanClass;

    FunctionEnum(String code, String desc, Class<? extends RequestBean> requestBeanClass) {
        this.code = code;
        this.desc = desc;
        this.requestBeanClass = requestBeanClass;
    }

    @JsonCreator
    public static FunctionEnum getByCode(String code) {
        return Stream.of(FunctionEnum.values())
                .filter(function -> StringUtils.equals(code, function.getCode()))
                .findAny()
                .orElse(notFound);
    }


}
