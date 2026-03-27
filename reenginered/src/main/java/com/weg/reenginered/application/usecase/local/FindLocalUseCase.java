package com.weg.reenginered.application.usecase.local;

import com.weg.reenginered.domain.dto.filter.LocalFilter;
import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.port.LocalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindLocalUseCase {

    private final LocalPort localPort;

    public List<Local> execute(LocalFilter local){
        return localPort.listAll(local);
    }
}
