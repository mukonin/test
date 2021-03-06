package com.site.service.domain;

import com.site.common.CrudSupport;
import com.site.model.domain.AbstractIdentifiable;

public interface CrudService<T extends AbstractIdentifiable> extends CrudSupport<T> {
}