package com.softtek.academy.ws.dao.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class CustomPageable<T> {

    public Page<T> createPage(List<T> elements, final Pageable pageable) {
        final int totalItems = elements.size();
        List<T> chunk = new ArrayList<>();

        if (elements != null && !elements.isEmpty()) {
            final int currentPage = pageable.getPageNumber();
            final int itemsPerPage = pageable.getPageSize();
            final int fromIndex = (currentPage - 1) * itemsPerPage;
            int toIndex = currentPage * itemsPerPage;

            if (elements.size() < toIndex) {
                toIndex = elements.size();
            }

            chunk = elements.subList(fromIndex, toIndex);
        }

        return new PageImpl<>(chunk, pageable, totalItems);
    }

}