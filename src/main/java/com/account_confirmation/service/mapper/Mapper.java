package com.account_confirmation.service.mapper;

import java.util.List;

public interface Mapper<T, F> {
    T map(F from);
    List<T> map(List<F> from);
}
