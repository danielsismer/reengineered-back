package com.weg.reenginered.application.usecase.local;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.port.LocalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateLocalUseCase {

    private final LocalPort localPort;

    public Local execute(Local local, Long id){
        return localPort.update(local, id);
    }
}
