package com.weg.reenginered.domain.port;

import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.domain.entity.Local;

import java.util.List;

public interface LocalPort {

    Local save(Local local);
    Local listById(Long id);
    List<Local> listAll(LocalFilter localFilter);
    Local update(Local local, Long id);
    void deleteById(Long id);
}
