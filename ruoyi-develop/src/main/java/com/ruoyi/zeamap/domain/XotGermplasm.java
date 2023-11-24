package com.ruoyi.zeamap.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @program: ruoyi
 * @description:
 * @author: Tinaliasd
 **/
public class XotGermplasm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long xotGermplasmId;

    private String type;

    private String value;

    private String germplasmId;

    private String xotId;

    public XotGermplasm(Long xotGermplasmId, String type, String value, String germplasmId, String xotId) {
        this.xotGermplasmId = xotGermplasmId;
        this.type = type;
        this.value = value;
        this.germplasmId = germplasmId;
        this.xotId = xotId;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getXotGermplasmId() {
        return xotGermplasmId;
    }

    public void setXotGermplasmId(Long xotGermplasmId) {
        this.xotGermplasmId = xotGermplasmId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGermplasmId() {
        return germplasmId;
    }

    public void setGermplasmId(String germplasmId) {
        this.germplasmId = germplasmId;
    }

    public String getXotId() {
        return xotId;
    }

    public void setXotId(String xotId) {
        this.xotId = xotId;
    }


    @Override
    public String toString() {
        return "XotGermplasm{" +
                "xotGermplasmId=" + xotGermplasmId +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", germplasmId='" + germplasmId + '\'' +
                ", xotId='" + xotId + '\'' +
                '}';
    }
}
